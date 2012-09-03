package wsht.runtime.expressions.sbql.envs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BinderResult;
import wsht.runtime.expressions.sbql.qres.result.ReferenceResult;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.store.object.SBAObject;

public class ENVS {
	
	private ENVS(){}
	private volatile static ENVS instance;
	
	private SBAStore store;
	
	private final Stack<ENVSStackFrame> stack = new Stack<ENVSStackFrame>();
	
	public static ENVS getInstance() {
		synchronized(ENVS.class) {
			if(instance == null) {
				instance = new ENVS();
			}
			return instance;
		}
	}
	
	public void init(boolean clearStack, Long... rootOIDs) {
		if(clearStack) stack.clear();
		ENVSStackFrame frame = new ENVSStackFrame();
		for(long refOID : rootOIDs) {
			ReferenceResult ref = new ReferenceResult();
			ref.setOidValue(refOID);
			ENVSBinder binder = new ENVSBinder();
			binder.setValue(ref);
			binder.setName(store.objectMap.get(refOID).name);
			frame.add(binder);
		}
		stack.push(frame);
	}
	
	public BagResult bind(String name) {
		BagResult result = new BagResult();
		for (int i = stack.size() - 1; i >= 0; i--) {
			for(ENVSBinder b : stack.elementAt(i).getElements()) {
				if(b.getName().equals(name)) {
					result.add(b.getValue());
				}
			}
			if(!result.getElements().isEmpty()) {
				return result;
			}
		}
		throw new SBQLEvalException("bind: brak elementu o nazwie: " + name);
	}
	
	public List<ENVSBinder> nested(AbstractQueryResult object) {
		ENVSStackFrame frame = new ENVSStackFrame();
		List<ENVSBinder> binderList = new ArrayList<ENVSBinder>();
		if(object instanceof ReferenceResult) {
			SBAObject rootObject = store.objectMap.get(((ReferenceResult)object).getOidValue());
			if(rootObject instanceof ComplexObject) {
				List<Long> childOids = ((ComplexObject) rootObject).childOIDs;
				for(Long oid : childOids) {
					ENVSBinder binder = new ENVSBinder();
					ReferenceResult ref = new ReferenceResult();
					ref.setOidValue(oid);
					binder.setValue(ref);
					binder.setName(store.objectMap.get(oid).name);
					frame.add(binder);
					binderList.add(binder);
				}
			} else {
				ENVSBinder binder = new ENVSBinder();
				ReferenceResult ref = new ReferenceResult();
				ref.setOidValue(rootObject.oid);
				binder.setValue(ref);
				binder.setName(rootObject.name);
				frame.add(binder);
				binderList.add(binder);
			}
			stack.push(frame);
		} else if(object instanceof BinderResult) {
			ENVSBinder binder = new ENVSBinder();
			binder.setName(((BinderResult)object).getName());
			binder.setValue(((BinderResult)object).getValue());
			frame.add(binder);
			stack.push(frame);
		} 
		return binderList;
	}
	
	
	public ENVSStackFrame pop() {
		return stack.pop();
	}
	
	public void push(ENVSStackFrame frame) {
		stack.push(frame);
	}
	
	//S/G
	public SBAStore getStore() {
		return store;
	}

	public void setStore(SBAStore store) {
		this.store = store;
	}
	
	public int getStackSize() {
		return stack.size();
	}
	
}
