package wsht.runtime.expressions.sbql.store.object;

public abstract class SBAObject {
	
	public String name;
	public Long oid;

	public String toString() {
		return "OID:" + oid + " NAME:" + name;
	}
}
