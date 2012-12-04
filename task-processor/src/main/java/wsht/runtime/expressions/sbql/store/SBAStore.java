package wsht.runtime.expressions.sbql.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import wsht.runtime.expressions.sbql.store.infrastructure.JavaObjectProcessing;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.store.object.SBAObject;


public class SBAStore {
	
	public SBAStore() {}
	
	public Map<Long, SBAObject> objectMap = new HashMap<Long, SBAObject>();
	
	public Long entryOID = 0L;
	private static Long generated = 0L;
	
	public static Long generateOID() {
		synchronized (generated) {
			return generated += 1;
		}
	}
	
	
	public void loadContainer(Object obj) {
		new JavaObjectProcessing().loadContainer(this,obj);
	}
	
	public void printDataStore() {
		StringBuffer buffer = new StringBuffer();
		for(Entry<Long, SBAObject> entry : objectMap.entrySet()) {
			buffer.append("<"+entry.getKey() + " " + entry.getValue().name);
			if(entry.getValue() instanceof ComplexObject) {
				List<Long> childOids = ((ComplexObject)entry.getValue()).childOIDs;
				buffer.append(" (type=" + ((ComplexObject)entry.getValue()).type + ", lvl=" + ((ComplexObject)entry.getValue()).lvl + ")");				
				buffer.append(" {");
				for(Long oid : childOids) {
					buffer.append(oid + ",");
				}
				if(buffer.lastIndexOf(",") == buffer.length() - 1)
					buffer.deleteCharAt(buffer.lastIndexOf(","));
				buffer.append("}");
			} else {
				buffer.append(" " + entry.getValue().toString());
			}
			buffer.append(">\n");
		}
		System.out.println(buffer.toString());
	}
	


}
