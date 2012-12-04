package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Notification;

@Repository("notificationRepository")
public class NotificationRepositoryJpa extends DomainRepositoryJpa<Notification> implements INotificationRepository {

	@Override
	public Class<Notification> getRepositoryModelClass() {
		return Notification.class;
	}

}
