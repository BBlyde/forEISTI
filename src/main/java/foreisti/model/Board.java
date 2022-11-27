package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cat_id")
	private Category category;

	@Column(name="description")
	private String description;

	public String getHandle() { return handle; }
	public String getName() { return name; }
	public Category getCategory() { return category; }
	public String getDescription() { return description; }

	public void setHandle(String s) { handle = s; }
	public void setName(String s) { name = s; }
	public void setCategory(Category c) { category = c; }
	public void setDescription(String s) { description = s; }
}
