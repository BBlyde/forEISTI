package foreisti.controller;

import foreisti.model.User;
import foreisti.model.Board;
import foreisti.model.Thread;
import foreisti.model.Reply;
import foreisti.dao.Dao;
import foreisti.dao.ThreadDao;
import foreisti.controller.utils.ControllerUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Date;

@Controller
public class PostController {
	@Autowired
	private Dao<Board> boardDao;

	@Autowired
	private Dao<Thread> threadDao;

	@Autowired
	private Dao<Reply> replyDao;

	@Autowired
	private Dao<User> userDao;

	@GetMapping("/{handle}/thread/{id:\\d+}")
	public String getThread(@PathVariable("handle") String handle, @PathVariable("id") int id, Model model) {
		model.addAttribute("op", threadDao.get(id));
		return "thread";
	}

	@PostMapping("/{handle}/create-thread")
	public String createThread(@PathVariable("handle") String handle, @RequestParam("title") String title, @RequestParam("message") String text, @RequestParam("file") Object file, HttpServletRequest req, RedirectAttributes attr) {
		if (!ControllerUtils.isLoggedIn(req)) {
			attr.addFlashAttribute("error", "You must be logged in to create a thread.");
			return "redirect:/login";
		}
		Board b = boardDao.get(handle);
		if (b == null)
			return "redirect:404";
		//TODO Process file
		Thread t = new Thread();
		t.setPoster(userDao.get((String)req.getSession().getAttribute("username")));
		t.setTimestamp(new Date());
		t.setLastUpdated(new Date());
		t.setTitle(title);
		t.setText(text);
		t.setBoard(b);
		t.setPicture(null);
		threadDao.save(t);
		return "redirect:/" + handle + "/thread/" + t.getId();
	}
}
