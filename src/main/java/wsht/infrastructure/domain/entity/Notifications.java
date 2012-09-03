package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name = "WshtNotifications")
public class Notifications extends ExtensibleElementsBase {
	private static final long serialVersionUID = -7312348805769412952L;
	
	@OneToMany(orphanRemoval=true,cascade = { CascadeType.ALL })
	private List<Notification> notification;

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}
	
}
