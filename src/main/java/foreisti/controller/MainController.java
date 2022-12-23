package foreisti.controller;

import foreisti.model.User;
import foreisti.model.Category;
import foreisti.dao.Dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class MainController {
	@Autowired
	private Dao<Category> categoryDao;

	@GetMapping("403")
	public String error403() {
		return "403";
	}

	@GetMapping("404")
	public String error404() {
		return "404";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", categoryDao.getAll());
		return "index";
	}
}
