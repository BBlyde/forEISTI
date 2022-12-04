package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
	@Size(min=1, message="This field is required.")
	private String name;

	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Board> boards;

	public int getId() { return id; }
	public String getName() { return name; }
	public List<Board> getBoards() { return boards; }

	public void setId(int i) { id = i; }
	public void setName(String s) { name = s; }
	public void setBoards(List<Board> l) { boards = l; }
}
