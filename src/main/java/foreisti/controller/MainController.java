package foreisti.controller;

import java.util.List;

import foreisti.model.User;
import foreisti.dao.Dao;
import foreisti.dao.UserDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {
	
	@Autowired
	private UserDao userDao;


	@GetMapping("/")
	public String index() {
		List<User> l = userDao.getAll();
		return "index";
	}
}
