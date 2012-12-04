package wsht.runtime.expressions.sbql.qres.result;


public class BinderResult extends AbstractQueryResult {

	private AbstractQueryResult value;
	private String name;
	
	public BinderResult(){}
	
	public BinderResult(AbstractQueryResult value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public AbstractQueryResult getValue() {
		return value;
	}
	public void setValue(AbstractQueryResult value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "binder(name=" + name + ", value=" + value + ")";
	}
	
}
