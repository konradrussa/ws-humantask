package wsht.runtime.expressions.sbql.qres;

import java.util.EmptyStackException;
import java.util.Stack;

import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;

public class QRES {
	
	private QRES(){}
	private volatile static QRES instance;
	
	private final Stack<AbstractQueryResult> stack = new Stack<AbstractQueryResult>();
	
	public static QRES getInstance() {
		synchronized (QRES.class) {
			if(instance == null) 
				instance = new QRES();
			return instance;
	
		}
	}
	
	public static void clean() {
		QRES.getInstance().stack.clear();
	}
	
	public AbstractQueryResult pop(boolean nullable) {
		try {
			if (nullable && stack.empty()) return null;
			return stack.pop();
		} catch (EmptyStackException e) {
			throw new SBQLEvalException(e.getMessage());
		}
		
	}
	
	public void push(AbstractQueryResult item) {
		stack.push(item);
	}
	
	public int getStackSize() {
		return stack.size();
	}
	
}
