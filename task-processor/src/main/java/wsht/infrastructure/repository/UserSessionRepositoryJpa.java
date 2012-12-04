package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.UserSession;

@Repository("userSessionRepository")
public class UserSessionRepositoryJpa extends DomainRepositoryJpa<UserSession> implements IUserSessionRepository {

	@Override
	public Class<UserSession> getRepositoryModelClass() {
		return UserSession.class;
	}

}
