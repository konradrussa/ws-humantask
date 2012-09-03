package wsht.infrastructure.repository;

import org.springframework.stereotype.Repository;

import wsht.infrastructure.domain.entity.Comment;

@Repository("commentRepository")
public class CommentRepositoryJpa extends DomainRepositoryJpa<Comment> implements ICommentRepository {

	@Override
	public Class<Comment> getRepositoryModelClass() {
		return Comment.class;
	}

}
