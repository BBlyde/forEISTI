package foreisti.controller.utils;

import foreisti.dao.Dao;
import foreisti.model.User;
import foreisti.model.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControllerUtils {
	public static boolean userExists(Dao<User> userDao, String username) {
		return userDao.get(username) != null;
	}

	public static boolean isLoggedIn(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute("role") instanceof Role;
	}

	public static boolean isAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute("role") == Role.ADMIN;
	}
}
