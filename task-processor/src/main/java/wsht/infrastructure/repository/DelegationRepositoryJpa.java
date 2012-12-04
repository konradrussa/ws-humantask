package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Delegation;

@Repository("delegationRepository")
public class DelegationRepositoryJpa extends DomainRepositoryJpa<Delegation> implements IDelegationRepository {

	@Override
	public Class<Delegation> getRepositoryModelClass() {
		return Delegation.class;
	}

}
