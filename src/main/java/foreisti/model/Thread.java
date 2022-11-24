package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name="Thread")
public class Thread {
	@Id
	@Column(name="thread_id")
	private int id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="board_id")
	private Board board;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User poster;

	@Column(name="title")
	@Size(min=1, message="This field is required")
	private String title;

	@Column(name="post_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="text")
	@Size(min=1, message="This field is required")
	private String text;

	public int getId() { return id; }
	public Board getBoard() { return board; }
	public User getPoster() { return poster; }
	public String getTitle() { return title; }
	public Date getTimestamp() { return timestamp; }
	public String getText() { return text; }

	public void setId(int i) { id = i; }
	public void setBoard(Board b) { board = b; }
	public void setPoster(User u) { poster = u; }
	public void setTitle(String s) { title = s; }
	public void setTimestamp(Date d) { timestamp = d; }
	public void setText(String s) { text = s; }
}
