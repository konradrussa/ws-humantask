package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.LocalNotification;

@Repository("localNotificationRepository")
public class LocalNotificationRepositoryJpa extends DomainRepositoryJpa<LocalNotification> implements ILocalNotificationRepository {

	@Override
	public Class<LocalNotification> getRepositoryModelClass() {
		return LocalNotification.class;
	}

}
