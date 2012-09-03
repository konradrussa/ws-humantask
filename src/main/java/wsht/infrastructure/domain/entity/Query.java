package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtQuery")
public class Query extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = 2903282683834405654L;

	private String part;
	private String queryLanguage;
	
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getQueryLanguage() {
		return queryLanguage;
	}
	public void setQueryLanguage(String queryLanguage) {
		this.queryLanguage = queryLanguage;
	}
	
	
}
