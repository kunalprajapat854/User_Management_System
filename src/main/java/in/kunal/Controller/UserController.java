package in.kunal.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.kunal.Bindings.ForgotPwd;
import in.kunal.Bindings.Login;
import in.kunal.Bindings.QuotesAPI;
import in.kunal.Bindings.Registration;
import in.kunal.Repository.UserRepo;
import in.kunal.Service.DashboardService;
import in.kunal.Service.UserService;

@Controller
public class UserController {

	private UserService service;

	private DashboardService dashboardService;

	public UserController(UserService service, UserRepo repo, DashboardService dashboardService) {
		this.service = service;
		this.dashboardService = dashboardService;
	}

	@GetMapping("/register")
	public String loadregisterform(Model model) {
		Map<Integer, String> getcountries = service.getcountries();
		Registration registration = new Registration();
		model.addAttribute("countryMap", getcountries);
		model.addAttribute("register", registration);
		return "register";
	}

	@GetMapping("/states/{countryId}")
	@ResponseBody
	public Map<Integer, String> getStates(@PathVariable Integer countryId, Model model) {
		Map<Integer, String> states = service.getStates(countryId);
		model.addAttribute("statesMap", states);
		return states;
	}

	@GetMapping("/cities/{statesId}")
	@ResponseBody
	public Map<Integer, String> getCities(@PathVariable Integer statesId, Model model) {
		Map<Integer, String> cities = service.getCities(statesId);
		model.addAttribute("cityMap", cities);
		return cities;
	}

	@PostMapping("/register")
	public String handleregistration(Model model, Registration registration) {
		boolean save = service.duplicateEmailCheck(registration.getEmail());
		if (save) {
			model.addAttribute("emsg", "Duplicate Email Found");
		} else {
			boolean register = service.registration(registration);
			if (register) {
				model.addAttribute("Saved", "Registration success Check Email");
			} else {
				model.addAttribute("Failed", "Registration Failed Due to Duplicate Email Found");
			}
		}
		model.addAttribute("countries", service.getcountries());
		return "register";

	}

	@GetMapping("/")
	public String loadloginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("/login")
	public String handlelogin(Model model, Login login) {
		Registration registration = service.login(login);
		if (registration == null) {
			model.addAttribute("emsg", "Invalid Credentials");
		} else {
			String updatepwd = registration.getUpdatepwd();
			if (updatepwd.equals("YES")) {
				return "redirect:dashboard";
			} else {
				return "redirect:rest-pwd-page?email=" + registration.getEmail();
			}
		}
		return "login";

	}

	@GetMapping("/dashboard")
	public String dashboardpage(Model model) {
		QuotesAPI quotesApi = dashboardService.getQuotesApi();
		model.addAttribute("quotes", quotesApi);
		return "dashboard";

	}

	@GetMapping("/rest-pwd-page")
	public String loadingrestpwdPage(Model model, @RequestParam("email") String email) {
		ForgotPwd forgotPwd = new ForgotPwd();
		forgotPwd.setEmail(email);
		return "resetPwd";

	}
    
	@PostMapping("/reset-pwd")
	public String handlelogin(Model model, ForgotPwd forgotPwd) {
		boolean password = service.forgotpwd(forgotPwd);
		if (password) {
			return "redirect:dashboard";
		}

		return "resetPwd";

	}

}
