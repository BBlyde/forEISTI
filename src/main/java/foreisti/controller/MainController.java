package foreisti.controller;

import foreisti.model.Thread;
import foreisti.model.Reply;
import foreisti.model.User;
import foreisti.dao.Dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {

	@GetMapping("403")
	public String error403() {
		return "403";
	}

	@GetMapping("404")
	public String error404() {
		return "404";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
