package wsht.runtime.expressions.sbql.store.infrastructure;

import java.util.Date;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.object.BooleanObject;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.store.object.DateObject;
import wsht.runtime.expressions.sbql.store.object.DoubleObject;
import wsht.runtime.expressions.sbql.store.object.FloatObject;
import wsht.runtime.expressions.sbql.store.object.IntegerObject;
import wsht.runtime.expressions.sbql.store.object.LongObject;
import wsht.runtime.expressions.sbql.store.object.SimpleObject;
import wsht.runtime.expressions.sbql.store.object.StringObject;

public abstract class SBAProcessing {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SBAProcessing.class);
	
	protected final SBAStore sbaStore;
	protected final Stack objects = new Stack();
	protected Object currentObject;
	protected String objectFieldName = null;
	protected Boolean taskContainerNotProcesseed = false;
	
	protected Integer lvl = 0;
	
	protected ComplexObject complexObject;
	
	public SBAProcessing(SBAStore sbaStore, Object obj) {
		this.sbaStore = sbaStore;
	}
	
	protected String currentObjectClassSimpleName() {
		return currentObject.getClass().getSimpleName();
	}
	
	protected String returnObjectName() {
		String objName= objectFieldName == null ?  
				currentObjectClassSimpleName() : objectFieldName;
		return objName;
	}
	

	
	protected void createFirstEntry(String name) {
		complexObject = new ComplexObject();
		complexObject.oid = sbaStore.entryOID;
		complexObject.name = name;
		complexObject.type = currentObjectClassSimpleName();
		sbaStore.objectMap.put(complexObject.oid, complexObject);
	}
	
	protected ComplexObject processComplexObject(String name, ComplexObject previous) {
		complexObject = new ComplexObject();
		complexObject.parent = filterOutParentByNameForComplex(name, previous);
		complexObject.oid = SBAStore.generateOID();	
		complexObject.name = name;
		complexObject.type = currentObjectClassSimpleName();
		complexObject.lvl = ++lvl;
		sbaStore.objectMap.put(complexObject.oid, complexObject);
		complexObject.parent.childOIDs.add(complexObject.oid);
		sbaStore.entryOID = complexObject.oid;
		return complexObject;
	}
	
	
	
   private ComplexObject filterOutParentByNameForComplex(String name, ComplexObject previous) {
		
		if(previous.lvl == lvl 
				&& previous.type.equals(currentObjectClassSimpleName()) 
				&& !previous.name.equals(name) 
				&& previous.parent != null) {
			--lvl;
			return previous.parent;
		} else {
			return previous;
		}
	}
	
	protected void processSimpleObject(String name, Object value) {
		SimpleObject simpleObject = processSimpleObject(value);
		if(simpleObject != null) {
			simpleObject.name = name;
			simpleObject.oid = SBAStore.generateOID();
			complexObject = returnComplexObjectWhenSimpleProcessed(); //from currentObject
			complexObject.childOIDs.add(simpleObject.oid);
			sbaStore.objectMap.put(simpleObject.oid, simpleObject);
		}
	}
	
	private ComplexObject returnComplexObjectWhenSimpleProcessed() {
		String name = null;
		
		if(objectFieldName != null) { 
			name = objectFieldName;
			return filterOutParentByNameForSimple(name,complexObject);
		} else if(complexObject.name.equals(currentObject.getClass().getSimpleName()))
			return complexObject;
		else if(complexObject.parent != null 
				&& complexObject.parent.name.equals(currentObject.getClass().getSimpleName())
				&& complexObject.parent.type.equals(currentObject.getClass().getSimpleName())) {
			--lvl;
			return complexObject.parent;
		}
		else if(complexObject.type.equals(currentObject.getClass().getSimpleName()))
			return complexObject;
		else if(complexObject.parent != null) {
			--lvl;
			return complexObject.parent;
		} else {
			name = currentObject.getClass().getSimpleName();
			return filterOutParentByNameForSimple(name,complexObject);
		}	
	}
	
	private ComplexObject filterOutParentByNameForSimple(String name, ComplexObject previous) {
		
		if(previous.name.equals(name) || previous.parent == null) {
			return previous;
		} 
		--lvl;
		return filterOutParentByNameForSimple(name, previous.parent);
		
	}
	
	private SimpleObject processSimpleObject(Object value) {
		
		if(value == null) return null;
		Class<?> type = value.getClass();
		if(type == Boolean.class) {
			BooleanObject booleanObject = new BooleanObject();
			booleanObject.value = (Boolean) value;
			return booleanObject;
		}
		if(type == Integer.class) {
			IntegerObject integerObject = new IntegerObject();
			integerObject.value = (Integer) value;
			return integerObject;
		}
		if(type == Double.class) {
			DoubleObject doubleObject = new DoubleObject();
			doubleObject.value = (Double) value;
			return doubleObject;
		}
		if(type == String.class) {
			StringObject stringObject = new StringObject();
			stringObject.value = (String) value;
			return stringObject;
		}
		if(type == Long.class) {
			LongObject longObject = new LongObject();
			longObject.value = (Long) value;
			return longObject;
		}
		if(type == Date.class) {
			DateObject dateObject = new DateObject();
			dateObject.value = (Date) value;
			return dateObject;
		}
		if(type == Float.class) {
			FloatObject floatObject = new FloatObject();
			floatObject.value = (Float) value;
			return floatObject;
		}
		throw new IllegalArgumentException("Unknown simple type");
	}
	
}
