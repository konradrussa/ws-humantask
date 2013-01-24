package wsht.infrastructure.service;

import wsht.messages.NotificationMessage;

public interface IMessageSender {
	
	public void sendNotification(NotificationMessage message);

}
