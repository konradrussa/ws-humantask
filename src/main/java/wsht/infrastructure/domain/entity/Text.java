package wsht.infrastructure.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleMixedContentElementsBase;

@Entity
@Table(name="WshtText")
public class Text extends ExtensibleMixedContentElementsBase {
	private static final long serialVersionUID = 5815413286870416932L;
	
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
}
