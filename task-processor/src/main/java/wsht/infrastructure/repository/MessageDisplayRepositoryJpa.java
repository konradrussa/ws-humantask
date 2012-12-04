package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.MessageDisplay;

@Repository("messageDisplayRepository")
public class MessageDisplayRepositoryJpa extends DomainRepositoryJpa<MessageDisplay> implements IMessageDisplayRepository {

	@Override
	public Class<MessageDisplay> getRepositoryModelClass() {
		return MessageDisplay.class;
	}

}
