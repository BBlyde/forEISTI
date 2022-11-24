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
public class Reply {
	@Id
	@Column(name="reply_id")
	private int id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="thread_id")
	private Thread thread;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User poster;

	@Column(name="reply_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="text")
	@Size(min=1, message="This field is required")
	private String text;

	public int getId() { return id; }
	public Thread getThread() { return thread; }
	public User getPoster() { return poster; }
	public Date getTimestamp() { return timestamp; }
	public String getText() { return text; }

	public void setId(int i) { id = i; }
	public void setThread(Thread t) { thread = t; }
	public void setPoster(User u) { poster = u; }
	public void setTimestamp(Date d) { timestamp = d; }
	public void setText(String s) { text = s; }
}
