package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Parameter;

@Repository("parameterRepository")
public class ParameterRepositoryJpa extends DomainRepositoryJpa<Parameter> implements IParameterRepository {

	@Override
	public Class<Parameter> getRepositoryModelClass() {
		return Parameter.class;
	}

}
