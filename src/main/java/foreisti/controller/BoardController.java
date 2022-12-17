package foreisti.controller;

import foreisti.model.Category;
import foreisti.model.Board;
import foreisti.model.Thread;
import foreisti.dao.Dao;
import foreisti.dao.ThreadDao;
import foreisti.controller.utils.ControllerUtils;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.web.util.HtmlUtils.htmlEscape;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Date;

@Controller
public class BoardController {
	@Autowired
	private Dao<Category> categoryDao;

	@Autowired
	private Dao<Board> boardDao;

	@Autowired
	private ThreadDao threadDao;

	//Very important: specify the regex for page, else "/css/style.css" would match and break the site
	@GetMapping("/{handle}/{page:\\d+}")
	public String getBoard(@PathVariable("handle") String handle, @PathVariable("page") int page, Model model) {
		handle = htmlEscape(handle);
		Board b = boardDao.get(handle);
		if (b == null)
			return "404";
		model.addAttribute("categories", categoryDao.getAll());
		model.addAttribute("threads", threadDao.getFromXtoY(b.getHandle(), (page-1)*10, page*10-1));
		model.addAttribute("board", b);
		return "board";
	}

	@GetMapping("/{handle}")
	public String getBoard(@PathVariable("handle") String handle, Model model) {
		return getBoard(handle, 1, model);
	}
}
