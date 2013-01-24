package wsht.infrastructure.repository;

import wsht.infrastructure.domain.entity.Fault;
import wsht.exception.WSHTException;

public interface IFaultRepository extends DomainRepository<Fault> {

	public Fault getFaultByIdentifier(String identifier) throws WSHTException;
}
