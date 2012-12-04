package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Text;

@Repository("textRepository")
public class TextRepositoryJpa extends DomainRepositoryJpa<Text> implements ITextRepository {

	@Override
	public Class<Text> getRepositoryModelClass() {
		return Text.class;
	}

}
