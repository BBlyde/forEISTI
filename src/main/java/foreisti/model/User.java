package foreisti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name="username")
	private String username;

	@Column(nullable=false, name="passwordHash")
	private String passwordHash;

	@Column(nullable=false, name="role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy="poster", cascade=CascadeType.ALL)
	private List<Post> posts;

	public String getUsername() { return username; }
	public String getPasswordHash() { return passwordHash; }
	public Role getRole() { return role; }

	public void setUsername(String s) { username = s; }
	public void setPasswordHash(String hash) { passwordHash = hash; }
	public void setRole(Role r) { role = r; }
}
