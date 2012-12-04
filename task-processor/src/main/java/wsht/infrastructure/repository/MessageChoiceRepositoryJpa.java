package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.MessageChoice;

@Repository("messageChoiceRepository")
public class MessageChoiceRepositoryJpa extends DomainRepositoryJpa<MessageChoice> implements IMessageChoiceRepository {

	@Override
	public Class<MessageChoice> getRepositoryModelClass() {
		return MessageChoice.class;
	}

}
