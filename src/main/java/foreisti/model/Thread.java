package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Thread extends Post {
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="handle")
	private Board board;

	@Column(name="title")
	@Size(min=1, message="This field is required")
	private String title;

	@Column(name="last_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

	@OneToMany(mappedBy="thread", cascade=CascadeType.ALL)
	private List<Reply> replies;

	public Board getBoard() { return board; }
	public String getTitle() { return title; }
	public Date getLastUpdated() { return lastUpdated; }
	public List<Reply> getReplies() { return replies; }

	public void setBoard(Board b) { board = b; }
	public void setTitle(String s) { title = s; }
	public void setLastUpdated(Date d) { lastUpdated = d; }
	public void setReplies(List<Reply> l) { replies = l; }
}
