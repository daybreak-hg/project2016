package jp.shoko.web.regist.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistPageAction {

	@RequestMapping("/regist")
	public String execute(final Model model, @RequestParam("userName") final String userName) throws Exception {

		if (userName == null || userName.trim().isEmpty()) {
			return "redirect:refer";
		}

		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			statement.execute(String.format("INSERT INTO DB_TEST(USERNAME, UPDATE_DATE) VALUES ('%s', datetime('now', 'localtime'))", userName));
		} catch (final Exception e) {
			throw e;
		}

		return "redirect:refer";
	}
}
