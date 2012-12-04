package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.MessageField;

@Repository("messageFieldRepository")
public class MessageFieldRepositoryJpa extends DomainRepositoryJpa<MessageField> implements IMessageFieldRepository {

	@Override
	public Class<MessageField> getRepositoryModelClass() {
		return MessageField.class;
	}

}
