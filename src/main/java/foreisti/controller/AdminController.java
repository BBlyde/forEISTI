package foreisti.controller;

import foreisti.model.Category;
import foreisti.model.Board;
import foreisti.model.User;
import foreisti.model.Role;
import foreisti.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

@Controller
public class AdminController {

	@Autowired
	private Dao<Category> categoryDao;
	@Autowired
	private Dao<Board> boardDao;

	public boolean isAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute("role") == Role.ADMIN;
	}

	@GetMapping("/admin-view")
	public String adminView(HttpServletRequest req) {
		if (isAdmin(req))
			return "admin/admin-view"; //Show admin view only if user is connected as an admin
		return "403"; //Else return a 403 error
	}

	@GetMapping("/admin/board-manager")
	public String getBoardManager(HttpServletRequest req) {
		if (isAdmin(req))
			return "admin/board-manager"; //Show admin view only if user is connected as an admin
		return "403"; //Else return a 403 error
	}

	@PostMapping("/admin/add-category")
	@ResponseBody
	public ResponseTransfer addCategory(@RequestParam("new") String category, HttpServletRequest req) {
		if (!isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		if (categoryDao.getByColName("cat_name", category) != null)
			return new ResponseTransfer(false, "Category already exists");
		Category c = new Category();
		c.setName(category);
		categoryDao.save(c);
		return new ResponseTransfer(true, "Category " + category + " was created");
	}
}
