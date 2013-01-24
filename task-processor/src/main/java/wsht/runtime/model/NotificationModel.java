package wsht.runtime.model;

import org.springframework.stereotype.Component;

import wsht.runtime.listeners.INotificationListener;

@Component("NotificationModel")
public class NotificationModel extends AbstractTaskModel implements INotificationListener {

	public void onNotificationRead() {
		
	}

	public void onRemoveRead() {
		
	}

	
}
