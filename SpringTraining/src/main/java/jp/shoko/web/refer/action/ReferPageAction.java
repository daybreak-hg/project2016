package jp.shoko.web.refer.action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.shoko.web.refer.dto.ReferPageOutputDto;

@Controller
public class ReferPageAction {

	@RequestMapping("/refer")
	public String execute(final Model model) throws Exception {

		Class.forName("org.sqlite.JDBC");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:../sqlite3.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			final ResultSet resultSet = statement.executeQuery("SELECT * FROM DB_TEST ORDER BY USERNAME");
			final List<ReferPageOutputDto> list = new ArrayList<ReferPageOutputDto>();
			int i = 0;
			while (resultSet.next()) {
				final ReferPageOutputDto output = new ReferPageOutputDto();
				i++;
				output.setRecNo(new BigDecimal(i));
				output.setUserName(resultSet.getString("USERNAME"));
				output.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString("UPDATE_DATE")));
				list.add(output);
			}
			resultSet.close();
			statement.close();
			connection.close();

			model.addAttribute("outputs", list);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "refer";
	}
}
