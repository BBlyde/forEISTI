package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Thread extends Post {
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="handle")
	private Board board;

	@Column(name="title")
	@Size(min=1, message="This field is required")
	private String title;

	@Column(name="last_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

	public Board getBoard() { return board; }
	public String getTitle() { return title; }
	public Date getLastUpdated() { return lastUpdated; }

	public void setBoard(Board b) { board = b; }
	public void setTitle(String s) { title = s; }
	public void setLastUpdated(Date d) { lastUpdated = d; }
}
