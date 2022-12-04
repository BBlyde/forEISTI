package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name="Posts")
@Table(name="Posts")
public abstract class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private int id;

	@ManyToOne
	@JoinColumn(name="username")
	private User poster;

	@Column(name="post_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@Column(name="text")
	@Size(min=1, message="This field is required")
	private String text;

	@OneToOne(mappedBy="post", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Picture picture;

	public int getId() { return id; }
	public User getPoster() { return poster; }
	public Date getTimestamp() { return timestamp; }
	public String getText() { return text; }
	public Picture getPicture() { return picture; }

	public void setId(int i) { id = i; }
	public void setPoster(User u) { poster = u; }
	public void setTimestamp(Date d) { timestamp = d; }
	public void setText(String s) { text = s; }
	public void setPicture(Picture p) { picture = p; }
}
