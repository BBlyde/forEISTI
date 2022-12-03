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
		return session != null && session.getAttribute("role") instanceof Role;
	}

	public static boolean isAdmin(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null && session.getAttribute("role") == Role.ADMIN;
	}

	public static Map<Category, List<Board>> categoryMap(Dao<Category> categoryDao, Dao<Board> boardDao) {
		Map<Category, List<Board>> m = new HashMap<>();
		for (Category c: categoryDao.getAll())
			m.put(c, boardDao.getByColName("cat_id", ""+c.getId()));
		return m;
	}
}
