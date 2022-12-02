package foreisti.controller;

import foreisti.model.Category;
import foreisti.model.Board;
import foreisti.model.User;
import foreisti.model.Role;
import foreisti.dao.Dao;
import foreisti.controller.utils.ControllerUtils;
import foreisti.controller.utils.ResponseTransfer;

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

	@GetMapping("/admin-view")
	public String adminView(HttpServletRequest req) {
		if (ControllerUtils.isAdmin(req))
			return "admin/admin-view"; //Show admin view only if user is connected as an admin
		return "403"; //Else return a 403 error
	}

	@GetMapping("/admin/board-manager")
	public String getBoardManager(HttpServletRequest req, Model model) {
		if (!ControllerUtils.isAdmin(req)) //Show admin view only if user is connected as an admin
			return "403"; //Else return a 403 error
		model.addAttribute("categories", categoryDao.getAll());
		model.addAttribute("boards", boardDao.getAll());
		return "admin/board-manager";
	}

	@PostMapping("/admin/add-category")
	@ResponseBody
	public ResponseTransfer addCategory(@RequestParam("new") String category, HttpServletRequest req) {
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		if (categoryDao.getByColName("cat_name", category) != null)
			return new ResponseTransfer(false, "Category already exists");
		Category c = new Category();
		c.setName(category);
		categoryDao.save(c);
		return new ResponseTransfer(true, ""+c.getId());
	}

	@PostMapping("/admin/edit-category")
	@ResponseBody
	public ResponseTransfer editCategory(@RequestParam("id") String id, @RequestParam("name") String name, HttpServletRequest req) {
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		if (categoryDao.getByColName("cat_name", name) != null)
			return new ResponseTransfer(false, "Category already exists");
		Category c = categoryDao.get(Integer.parseInt(id));
		if (c == null)
			return new ResponseTransfer(false, "Category to modify does not exist");
		c.setName(name);
		categoryDao.update(c);
		return new ResponseTransfer(true, "Name successfuly updated");
	}

	@PostMapping("/admin/delete-category")
	@ResponseBody
	public ResponseTransfer deleteCategory(@RequestParam("id") String id, HttpServletRequest req) {
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		Category c = categoryDao.get(Integer.parseInt(id));
		if (c == null)
			return new ResponseTransfer(false, "Category to delete does not exist");
		categoryDao.delete(c);
		return new ResponseTransfer(true, "Category successfully deleted");
	}

	@PostMapping("/admin/add-board")
	@ResponseBody
	public ResponseTransfer addBoard(@RequestParam("handle") String handle, @RequestParam("name") String name, @RequestParam("category") String cat, HttpServletRequest req){
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		if (handle.contains("/") || handle.contains(" "))
			return new ResponseTransfer(false, "Forbidden characters included");
		if (boardDao.get(handle) != null)
			return new ResponseTransfer(false, "Board already exists");
		Category c = categoryDao.get(Integer.parseInt(cat));
		if (c == null)
			return new ResponseTransfer(false, "Category does not exist");
		Board b = new Board();
		b.setHandle(handle);
		b.setName(name);
		b.setCategory(c);
		boardDao.save(b);
		return new ResponseTransfer(true, "Board was created successfully");
	}

	@PostMapping("/admin/delete-board")
	@ResponseBody
	public ResponseTransfer deleteBoard(@RequestParam("handle") String handle, HttpServletRequest req) {
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		Board b = boardDao.get(handle);
		if (b == null)
			return new ResponseTransfer(false, "Board to delete does not exist");
		boardDao.delete(b);
		return new ResponseTransfer(true, "Board successfully deleted");
	}

	@PostMapping("/admin/edit-board")
	@ResponseBody
	public ResponseTransfer editBoard(@RequestParam("oldHandle") String oldHandle, @RequestParam("newHandle") String newHandle, @RequestParam("name") String name, @RequestParam("category") String cat, HttpServletRequest req){
		if (!ControllerUtils.isAdmin(req))
			return new ResponseTransfer(false, "Forbidden");
		if (newHandle.contains("/") || newHandle.contains(" "))
			return new ResponseTransfer(false, "Forbidden characters included");
		Board b = boardDao.get(oldHandle);
		if (b == null)
			return new ResponseTransfer(false, "Board does not exist");
		Category c = categoryDao.get(Integer.parseInt(cat));
		if (c == null)
			return new ResponseTransfer(false, "Category does not exist");
		b.setHandle(newHandle);
		b.setName(name);
		b.setCategory(c);
		boardDao.update(b);
		return new ResponseTransfer(true, "Board was edited successfully");
	}
}
