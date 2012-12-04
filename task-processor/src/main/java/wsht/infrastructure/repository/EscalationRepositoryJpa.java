package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Escalation;

@Repository("escalationRepository")
public class EscalationRepositoryJpa extends DomainRepositoryJpa<Escalation> implements IEscalationRepository {

	@Override
	public Class<Escalation> getRepositoryModelClass() {
		return Escalation.class;
	}

}
