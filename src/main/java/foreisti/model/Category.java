package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@Column(name="cat_id")
	private int id;

	@Column(name="cat_name")
	@Size(min=1, message="This field is required.")
	private String name;

	public int getId() { return id; }
	public String getName() { return name; }

	public void setId(int i) { id = i; }
	public void setName(String s) { name = s; }
}
