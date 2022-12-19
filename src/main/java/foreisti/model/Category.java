package foreisti.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@Column(name="cat_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name="cat_name")
	@Size(min=1, max=64, message="This field is required and needs to be lower than 64 characters long.")
	private String name;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="board_category", joinColumns=@JoinColumn(name="cat_id"), inverseJoinColumns=@JoinColumn(name="board_handle"))
	private List<Board> boards;

	public int getId() { return id; }
	public String getName() { return name; }
	public List<Board> getBoards() { return boards; }

	public void setId(int i) { id = i; }
	public void setName(String s) { name = s; }
	public void setBoards(List<Board> l) { boards = l; }
}
