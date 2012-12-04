package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.AttachmentInfo;

@Repository("attachmentInfoRepository")
public class AttachmentInfoRepositoryJpa extends DomainRepositoryJpa<AttachmentInfo> implements IAttachmentInfoRepository {

	@Override
	public Class<AttachmentInfo> getRepositoryModelClass() {
		return AttachmentInfo.class;
	}

}
