package wsht.infrastructure.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import wsht.infrastructure.domain.entity.base.ExtensibleElementsBase;

@Entity
@Table(name="WshtEscalation")
public class Escalation extends ExtensibleElementsBase {
	private static final long serialVersionUID = -3321647521531609736L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private BooleanExpr condition;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private ToParts toParts;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Notification notification;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private LocalNotification localNotification;
    
	@ManyToOne(cascade=CascadeType.ALL)
	private Reassignment reassignment;
    
	private String name;
    
	public BooleanExpr getCondition() {
		return condition;
	}
	public void setCondition(BooleanExpr condition) {
		this.condition = condition;
	}
	public ToParts getToParts() {
		return toParts;
	}
	public void setToParts(ToParts toParts) {
		this.toParts = toParts;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public LocalNotification getLocalNotification() {
		return localNotification;
	}
	public void setLocalNotification(LocalNotification localNotification) {
		this.localNotification = localNotification;
	}
	public Reassignment getReassignment() {
		return reassignment;
	}
	public void setReassignment(Reassignment reassignment) {
		this.reassignment = reassignment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
