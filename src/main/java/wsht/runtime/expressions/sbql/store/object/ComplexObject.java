package wsht.runtime.expressions.sbql.store.object;

import java.util.ArrayList;
import java.util.List;

public class ComplexObject extends SBAObject {
	
	public List<Long> childOIDs = new ArrayList<Long>();
	public ComplexObject parent = null;
	public String type = null;
	public Integer lvl = 0;
	
	public String toString() {
		String oids = "";
		for(Long oid : childOIDs) {
			if("".equals(oids)) {
				oids = "" + oid;
			} else {
				oids = oids+ "," + oid;
			}
		}
		
		return super.toString() + " TYPE:" + type + " LVL:" + lvl + " CHILD_OIDS:" + oids;
	}
}
