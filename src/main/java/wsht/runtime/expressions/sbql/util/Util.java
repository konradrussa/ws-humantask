package wsht.runtime.expressions.sbql.util;

import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BinderResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.ReferenceResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.store.object.BooleanObject;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.store.object.DoubleObject;
import wsht.runtime.expressions.sbql.store.object.IntegerObject;
import wsht.runtime.expressions.sbql.store.object.SBAObject;
import wsht.runtime.expressions.sbql.store.object.StringObject;
import wsht.runtime.expressions.sbql.envs.ENVS;

public class Util {

	public static AbstractQueryResult deref(AbstractQueryResult ref) {
		if(ref instanceof ReferenceResult) {
			ReferenceResult r = (ReferenceResult) ref;
			return getQueryResult(r);
		} else if(ref instanceof BooleanResult) {
			return ref;
		} else if(ref instanceof IntegerResult) {
			return ref;
		} else if(ref instanceof RealResult) {
			return ref;
		} else if(ref instanceof StringResult) {
			return ref;
		} else if(ref instanceof BinderResult) {
			BinderResult r = (BinderResult) ref;
			AbstractQueryResult value = r.getValue();
			if(value instanceof ReferenceResult) {
				return getQueryResult((ReferenceResult)value);
			} else {
				return value;
			}
		} else if (ref instanceof BagResult && ((BagResult) ref).getElements().size() == 1) {
			AbstractQueryResult temp = ((BagResult)ref).getElements().get(0);
			if(temp instanceof BinderResult) {
				BinderResult b = (BinderResult) temp;
				return b.getValue();
			} else if (temp instanceof IntegerResult) {
				return temp;
			} else if (temp instanceof RealResult) {
				return temp;
			} else if (temp instanceof StringResult) {
				return temp;
			} else if (temp instanceof BooleanResult) {
				return temp;
			} else {
				return getQueryResult((ReferenceResult)temp);
			}
		} else if(ref instanceof BagResult) {
			BagResult inBag = (BagResult) ref;
			BagResult bag = new BagResult();
			for(AbstractQueryResult r : inBag.getElements()) {
				if(r instanceof ReferenceResult) {
					bag.add(getQueryResult((ReferenceResult) r));
				} else {
					bag.add(r);
				}
			}
			return bag;
		} else if(ref instanceof StructResult) {
			StructResult inStruct = (StructResult) ref;
			BagResult bag = new BagResult();
			for(AbstractQueryResult r : inStruct.getAtoms()) {
				if(r instanceof ReferenceResult)
					bag.add(getQueryResult((ReferenceResult) r));
				else
					bag.add(r);
			}
			return bag;
		} else {
			throw new RuntimeException("Blad deref: " + ref);
		}
	}
	
	private static AbstractQueryResult getQueryResult(ReferenceResult ref) {
		 SBAObject object = ENVS.getInstance().getStore().objectMap.get(ref.getOidValue());
		 if(object.getClass() == BooleanObject.class) {
			 BooleanResult result = new BooleanResult();
			 result.setValue(((BooleanObject)object).value);
			 return result;
		 } else if(object.getClass() == IntegerObject.class) {
			 IntegerResult result = new IntegerResult();
			 result.setValue(((IntegerObject)object).value);
			 return result;
		 } else if(object.getClass() == DoubleObject.class) {
			 RealResult result = new RealResult();
			 result.setValue(((DoubleObject)object).value);
			 return result;
		 } else if(object.getClass() == StringObject.class) {
			 StringResult result = new StringResult();
			 result.setValue(((StringObject)object).value);
			 return result;
		 } else if(object.getClass() == ComplexObject.class) {
			 ComplexObject result = (ComplexObject) object;
			 BinderResult result2 = new BinderResult(new ReferenceResult(result.oid), result.name);
			 return result2;
		 }
		 throw new RuntimeException();
	}
}
