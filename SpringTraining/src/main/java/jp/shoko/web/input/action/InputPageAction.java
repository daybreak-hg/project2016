package jp.shoko.web.input.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputPageAction {

	@RequestMapping("/input")
	public String execute(final Model model) {
		model.addAttribute("title", "入力画面");
		return "input";
	}
}
