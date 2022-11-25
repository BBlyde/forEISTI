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

	@Autowired
	private Dao<Thread> threadDao;
	@Autowired
	private Dao<Reply> replyDao;
	@Autowired
	private Dao<User> userDao;

	@GetMapping("/")
	public String index() {
		System.out.println(threadDao.get(1));
		return "index";
	}

	@GetMapping("/test")
	public String test() {
		Thread t = new Thread();
		t.setPoster(userDao.get("snowflav"));
		t.setText("this is a thread");
		t.setTitle("this is a thread title");
		t.setBoard(null);
		Reply r = new Reply();
		r.setPoster(userDao.get("blyde1bogoss"));
		r.setText("widepeepoHappy");
		r.setThread(t);
		threadDao.save(t);
		replyDao.save(r);
		return "test";
	}
}
