package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name="Board")
public class Board {
	@Id
	@Column(name="handle")
	@Size(min=1, message="This field is required")
	private String handle;

	@Column(name="board_name")
	@Size(min=1, message="This field is required")
	private String name;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private Category category;

	@Column(name="description")
	private String description;

	@OneToMany(mappedBy="board", cascade=CascadeType.ALL)
	private List<Thread> threads;

	public String getHandle() { return handle; }
	public String getName() { return name; }
	public Category getCategory() { return category; }
	public String getDescription() { return description; }
	public List<Thread> getThreads() { return threads; }

	public void setHandle(String s) { handle = s; }
	public void setName(String s) { name = s; }
	public void setCategory(Category c) { category = c; }
	public void setDescription(String s) { description = s; }
	public void setThreads(List<Thread> l) { threads = l; }
}
