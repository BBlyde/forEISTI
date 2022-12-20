package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
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
	@Size(min=1, max=8, message="This field is required")
	private String handle;

	@Column(name="board_name")
	@Size(min=1, max=64, message="This field is required")
	private String name;

	@ManyToMany(mappedBy="boards")
	private List<Category> categories;

	@Column(name="description")
	@Size(min=1, max=2048, message="This field is required")
	private String description;

	@OneToMany(mappedBy="board", cascade=CascadeType.ALL)
	private List<Thread> threads;

	public String getHandle() { return handle; }
	public String getName() { return name; }
	public List<Category> getCategories() { return categories; }
	public String getDescription() { return description; }
	public List<Thread> getThreads() { return threads; }

	public void setHandle(String s) { handle = s; }
	public void setName(String s) { name = s; }
	public void setCategories(List<Category> l) { categories = l; }
	public void setDescription(String s) { description = s; }
	public void setThreads(List<Thread> l) { threads = l; }

	public String categoryIdList() {
		if (categories.isEmpty())
			return "[]";
		String res = "[";
		Category lastElement = categories.get(categories.size()-1);
		categories.remove(lastElement);
		for (Category c: categories)
			res += c.getId() + ", ";
		res += lastElement.getId() + "]";
		categories.add(lastElement);
		return res;
	}
}
