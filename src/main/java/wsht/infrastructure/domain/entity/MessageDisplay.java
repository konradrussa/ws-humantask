package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtMessageDisplay")
public class MessageDisplay extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = -648227838662400046L;

	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
