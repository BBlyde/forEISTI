package foreisti.controller.utils;

import foreisti.dao.Dao;
import foreisti.model.User;
import foreisti.model.Role;
import foreisti.model.Category;
import foreisti.model.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

public class ControllerUtils {
	public static boolean userExists(Dao<User> userDao, String username) {
		return userDao.get(username) != null;
	}

	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute("user") instanceof User;
	}

	public static boolean isAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		User u = session == null || !(session.getAttribute("user") instanceof User) ? null : (User)session.getAttribute("user");
		return u != null && u.getRole() == Role.ADMIN;
	}

	public static List<Category> parseCategories(Dao<Category> categoryDao, String[] cats) {
		List<Category> l = new ArrayList<>();
		for (String cat: cats) {
			Category c = categoryDao.get(Integer.parseInt(cat));
			if (c != null)
				l.add(c);
		}
		return l;
	}
}
