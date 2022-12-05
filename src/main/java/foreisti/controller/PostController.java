package foreisti.controller;

import foreisti.model.User;
import foreisti.model.Board;
import foreisti.model.Thread;
import foreisti.model.Reply;
import foreisti.model.Picture;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Date;
import java.util.Set;
import java.io.File;
import java.io.IOException;

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

	private static final Set<String> ACCEPTED_MIME_TYPES = Set.of("image/png", "image/jpeg", "video/mp4", "video/webm");

	public static boolean acceptableMimeType(String mimeType) {
		return ACCEPTED_MIME_TYPES.contains(mimeType);
	}

	@GetMapping("/{handle}/thread/{id:\\d+}")
	public String getThread(@PathVariable("handle") String handle, @PathVariable("id") int id, Model model) {
		model.addAttribute("op", threadDao.get(id));
		return "thread";
	}

	@PostMapping("/{handle}/create-thread")
	public String createThread(@PathVariable("handle") String handle, @RequestParam("title") String title, @RequestParam("message") String text, @RequestParam("file") MultipartFile file, HttpServletRequest req, RedirectAttributes attr) throws IOException {
		if (!ControllerUtils.isLoggedIn(req)) {
			attr.addFlashAttribute("error", "You must be logged in to create a thread.");
			return "redirect:/login";
		}
		Board b = boardDao.get(handle);
		if (b == null)
			return "404";
		if (!file.isEmpty() && !acceptableMimeType(file.getContentType())) {
			attr.addFlashAttribute("error", "Thread wasn't created because of an invalid file type");
			return "redirect:/" + handle;
		}
		Thread t = new Thread();
		t.setPoster(((User)req.getSession().getAttribute("user")));
		t.setTimestamp(new Date());
		t.setLastUpdated(t.getTimestamp());
		t.setTitle(title);
		t.setText(text); //TODO check equivalnt of htmlspecialchars
		t.setBoard(b);
		Picture p = file.isEmpty() ? null : new Picture();
		if (p != null) {
			p.setPost(t);
			p.setOriginalName(file.getOriginalFilename());
			p.setMimeType(file.getContentType());
		}
		t.setPicture(p);
		threadDao.save(t);
		if (p != null)
			file.transferTo(new File(req.getServletContext().getRealPath("/") + "../resources/static/img/user-content/" + t.getId() + "." + p.getMimeType().split("/")[1])); //A bit bruteforcey but eh
		return "redirect:/" + handle + "/thread/" + t.getId();
	}

	@PostMapping("/{handle}/thread/{id:\\d+}/reply")
	public String replyToThread(@PathVariable("handle") String handle, @PathVariable("id") int id, @RequestParam("message") String text, @RequestParam("file") MultipartFile file, HttpServletRequest req, RedirectAttributes attr) throws IOException {
		if (!ControllerUtils.isLoggedIn(req)) {
			attr.addFlashAttribute("error", "You must be logged in to reply to a thread.");
			return "redirect:/login";
		}
		Thread t = threadDao.get(id);
		if (t == null || !t.getBoard().getHandle().equals(handle))
			return "404";
		if (!file.isEmpty() && !acceptableMimeType(file.getContentType())) {
			attr.addFlashAttribute("error", "Reply wasn't created because of an invalid file type");
			return "redirect:/" + handle + "/" + id;
		}
		Reply r = new Reply();
		r.setPoster(((User)req.getSession().getAttribute("user")));
		r.setTimestamp(new Date());
		t.setLastUpdated(r.getTimestamp());
		r.setText(text); //TODO check equivalent of htmlspecialchars
		r.setThread(t);
		Picture p = file.isEmpty() ? null : new Picture();
		if (p != null) {
			p.setPost(r);
			p.setOriginalName(file.getOriginalFilename());
			p.setMimeType(file.getContentType());
		}
		r.setPicture(p);
		replyDao.save(r);
		if (p != null)
			file.transferTo(new File(req.getServletContext().getRealPath("/") + "../resources/static/img/user-content/" + r.getId() + "." + p.getMimeType().split("/")[1])); //A bit bruteforcey but eh
		return "redirect:/" + handle + "/thread/" + t.getId() + "#p" + r.getId();
	}
}
