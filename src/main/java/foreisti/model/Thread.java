package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Thread extends Post {
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="board_id")
	private Board board;

	@Column(name="title")
	@Size(min=1, message="This field is required")
	private String title;

	public Board getBoard() { return board; }
	public String getTitle() { return title; }

	public void setBoard(Board b) { board = b; }
	public void setTitle(String s) { title = s; }
}
