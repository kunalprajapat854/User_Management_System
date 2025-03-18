package in.kunal.Controller;

import org.springframework.stereotype.Controller;

import in.kunal.Service.UserService;

@Controller
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

}
