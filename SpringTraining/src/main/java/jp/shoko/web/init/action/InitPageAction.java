package jp.shoko.web.init.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitPageAction {

	@RequestMapping("/init")
	public String execute(final Model model) throws Exception {

		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			statement.execute("DROP TABLE DB_TEST");
			statement.execute("CREATE TABLE DB_TEST(USERNAME TEXT, UPDATE_DATE DATE, PRIMARY KEY (USERNAME))");

			statement.execute(String.format("INSERT INTO DB_TEST(USERNAME, UPDATE_DATE) VALUES ('%s', datetime('now', 'localtime'))", "hoge"));
			statement.execute(String.format("INSERT INTO DB_TEST(USERNAME, UPDATE_DATE) VALUES ('%s', datetime('now', 'localtime'))", "fuga"));
			statement.execute(String.format("INSERT INTO DB_TEST(USERNAME, UPDATE_DATE) VALUES ('%s', datetime('now', 'localtime'))", "piyo"));
		} catch (final Exception e) {
			throw e;
		}

		return "redirect:refer";
	}
}
