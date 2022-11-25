package foreisti.controller;

import foreisti.dao.Dao;
import foreisti.model.User;
import foreisti.model.Role;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Controller
public class UserController {

	@Autowired
	private Dao<User> userDao;

	public boolean userExists(String username) {
		return userDao.get(username) != null;
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

	@GetMapping("/blyde1gay")
	public String blyde1gay() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		if (userExists(username)) {
			model.addAttribute("error", "Username already taken.");
			return "register";
		} else {
			User u = new User();
			u.setUsername(username);
			u.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));
			u.setRole(Role.USER);
			userDao.save(u);
			model.addAttribute("userCreationStatus", true);
			return "redirect:/";
		}
	}
}
