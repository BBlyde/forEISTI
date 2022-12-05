package foreisti.controller.utils;

import foreisti.dao.Dao;
import foreisti.model.User;
import foreisti.model.Role;
import foreisti.model.Category;
import foreisti.model.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

}
