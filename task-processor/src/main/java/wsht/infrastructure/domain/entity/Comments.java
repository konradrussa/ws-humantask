package wsht.infrastructure.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WshtComments")
public class Comments implements Serializable {
	private static final long serialVersionUID = 1086835820319249873L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL})
	private List<Comment> comment;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Comment returnCommentById(String commentIdentifier) {
		for(Comment c : comment) {
			if(c.getId().toString().equals(commentIdentifier)) return c;
		}
		return null;
	}
	
	
}
