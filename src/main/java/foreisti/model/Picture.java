package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name="Picture")
@Table(name="Picture")
public class Picture {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="picture_id")
	private int id;

	@OneToOne
	@MapsId
	@JoinColumn(name="post_id")
	private Post post;

	@Column(name="original_name")
	private String originalName;

	@Column(name="mime_type")
	private String mimeType;

	public int getId() { return id; }
	public Post getPost() { return post; }
	public String getOriginalName() { return originalName; }
	public String getMimeType() { return mimeType; }

	public void setId(int i) { id = i; }
	public void setPost(Post p) { post = p; }
	public void setOriginalName(String s) { originalName = s; }
	public void setMimeType(String s) { mimeType = s; }

	@Override
	public String toString() {
		return "/img/user-content/" + id + "." + mimeType;
	}
}
