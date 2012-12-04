package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Attachment;

@Repository("attachmentRepository")
public class AttachmentRepositoryJpa extends DomainRepositoryJpa<Attachment> implements IAttachmentRepository {

	
	@Override
	public Class<Attachment> getRepositoryModelClass() {
		return Attachment.class;
	}

}
