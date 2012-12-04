package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Comments;

@Repository("commentsRepository")
public class CommentsRepositoryJpa extends DomainRepositoryJpa<Comments> implements ICommentsRepository {

	@Override
	public Class<Comments> getRepositoryModelClass() {
		return Comments.class;
	}

}
