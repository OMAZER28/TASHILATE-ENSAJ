package ma.ensaj.clientapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/money_transfer")
	public String money_transfer() {
		return "money_transfer";
	}
	
	@GetMapping("/money_transfer/send_money")
	public String send_money() {
		return "send_money";
	}
	
	@GetMapping("/money_transfer/receive_money")
	public String receive_money() {
		return "receive_money";
	}
	
	@GetMapping("/phone_recharge")
	public String phone_recharge() {
		return "phone_recharge";
	}

	@GetMapping("/we_payment")
	public String we_payment() {
		return "we_payment";
	}
}
