package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.MessageSchema;

@Repository("messageSchemaRepository")
public class MessageSchemaRepositoryJpa extends DomainRepositoryJpa<MessageSchema> implements IMessageSchemaRepository {

	@Override
	public Class<MessageSchema> getRepositoryModelClass() {
		return MessageSchema.class;
	}

}
