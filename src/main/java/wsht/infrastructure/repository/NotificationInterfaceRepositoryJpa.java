package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.NotificationInterface;

@Repository("notificationInterfaceRepository")
public class NotificationInterfaceRepositoryJpa extends DomainRepositoryJpa<NotificationInterface> implements INotificationInterfaceRepository {

	@Override
	public Class<NotificationInterface> getRepositoryModelClass() {
		return NotificationInterface.class;
	}

}
