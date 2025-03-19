package in.kunal.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.kunal.Bindings.ForgotPwd;
import in.kunal.Bindings.Login;
import in.kunal.Bindings.Registration;
import in.kunal.EmailUtils.EmailService;
import in.kunal.Entity.City;
import in.kunal.Entity.Country;
import in.kunal.Entity.States;
import in.kunal.Entity.User;
import in.kunal.Repository.UserRepo;
import in.kunal.Repository.cityRepo;
import in.kunal.Repository.countryRepo;
import in.kunal.Repository.statesRepo;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo userrepo;

	private countryRepo countryrepo;

	private statesRepo statesrepo;

	private cityRepo cityrepo;

	private EmailService emailservice;

	public UserServiceImpl(UserRepo userrepo, countryRepo countryrepo, statesRepo statesrepo, cityRepo cityrepo,
			EmailService emailservice) {
		this.userrepo = userrepo;
		this.countryrepo = countryrepo;
		this.statesrepo = statesrepo;
		this.cityrepo = cityrepo;
		this.emailservice = emailservice;
	}

	public Map<Integer, String> getcountries() {
		Map<Integer, String> countriesMap = new HashMap<>();
		List<Country> countrylist = countryrepo.findAll();
		for (Country country : countrylist) {
			countriesMap.put(country.getCountryId(), country.getCountryName());
		}

		return countriesMap;
	}

	public Map<Integer, String> getStates(Integer countryId) {
		Map<Integer, String> statesMap = new HashMap<>();
		List<States> stateslist = statesrepo.findByCountryId(countryId);
		for (States states : stateslist) {
			statesMap.put(states.getStatesId(), states.getStatesName());
		}
		return statesMap;
	}

	public Map<Integer, String> getCities(Integer statesId) {
		Map<Integer, String> cityMap = new HashMap<>();
		List<City> citylist = cityrepo.findByStatesId(statesId);
		for (City city : citylist) {
			cityMap.put(city.getCityId(), city.getCityName());
		}
		return cityMap;
	}

	public boolean registration(Registration registration) {
		User user = new User();
		BeanUtils.copyProperties(registration, user); // copying data from one obj to another obj
		Country country = countryrepo.findById(registration.getCountryId()).orElse(null);
		user.setCountry(country);

		States states = statesrepo.findById(registration.getStatesId()).orElse(null);
		user.setStates(states);

		City city = cityrepo.findById(registration.getCityId()).orElse(null);
		user.setCity(city);

		String pwd = generatepwd();
		user.setPwd(pwd);
		user.setUpdatepwd("NO");

		User save = userrepo.save(user); // save user and sending email

		if (save.getUserId() != null) {
			String subject = "Your Account Created!";
			String to = registration.getEmail();
			String body = "Your password to Login" + generatepwd();
			emailservice.sendEmail(subject, to, body);
			return true;
		}
		return false;
	}

	public Registration login(Login login) {
		User userEntity = userrepo.findByEmailAndPwd(login.getEmail(), login.getPwd());
		if (userEntity != null) {
			Registration registration = new Registration();
			BeanUtils.copyProperties(userEntity, registration);
			return registration;

		}
		return null;
	}

	public boolean forgotpwd(ForgotPwd forgotPwd) {
		String email = forgotPwd.getEmail();
		User entity = userrepo.findByEmail(email);
		entity.setPwd(forgotPwd.getNewpwd());
		entity.setUpdatepwd("YES");
		userrepo.save(entity);   //UPSERT 
		return true;
	}

	public boolean duplicateEmailCheck(String email) {
		User getEmail = userrepo.findByEmail(email);
		return getEmail != null;
	}

	private String generatepwd() {

		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";

		
		
		String combineAll = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int randomindex = random.nextInt(combineAll.length());
			buffer.append(combineAll.charAt(randomindex));
		}
		return buffer.toString();

	}

}

