package foreisti.controller;

import foreisti.dao.Dao;
import foreisti.model.User;
import foreisti.model.Role;
import foreisti.controller.utils.ControllerUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Controller
public class UserController {

	@Autowired
	private Dao<User> userDao;

	@GetMapping("/register")
	public String getRegisterPage(HttpServletRequest req) {
		if (ControllerUtils.isLoggedIn(req))
			return "redirect:/"; //Redirect to index.jsp if user is already connected
		return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest req, Model model, RedirectAttributes rattr) {
		if (ControllerUtils.userExists(userDao, username)) { //Verify if user already exists
			model.addAttribute("error", "Username already taken.");
			return "register";
		} else {
			User u = new User();
			u.setUsername(username);
			u.setPasswordHash(BCrypt.hashpw(password, BCrypt.gensalt()));
			u.setRole(Role.USER);
			userDao.save(u); //Save user in DB
			rattr.addFlashAttribute("userCreationStatus", true);
			req.getSession().setAttribute("user", u);
			return "redirect:/";
		}
	}

	@GetMapping("/login")
	public String getLoginPage(HttpServletRequest req) {
		if (ControllerUtils.isLoggedIn(req))
			return "redirect:/"; //Redirect to index.jsp if user is already connected
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest req, Model model) {
		User u = userDao.get(username);
		if (u == null || !BCrypt.checkpw(password, u.getPasswordHash())) { //Verify if user exists and the right password was used
			model.addAttribute("error", "Incorrect credentials.");
			return "login";
		} else {
			req.getSession().setAttribute("user", u);
			return "redirect:/";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, RedirectAttributes attr) {
		User u = (User)req.getSession().getAttribute("user");
		if (u != null) {
			attr.addFlashAttribute("logoutStatus", "Goodbye, " + u.getUsername());
			req.getSession().removeAttribute("user");
		}
		return "redirect:/";
	}
}
