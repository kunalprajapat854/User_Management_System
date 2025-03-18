package in.kunal.Service;

import java.util.Map;

import in.kunal.Bindings.ForgotPwd;
import in.kunal.Bindings.Login;
import in.kunal.Bindings.Registration;

public interface UserService {

	public Map<Integer, String> getcountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer statesId);

	public boolean registration(Registration registration);

	public Registration login(Login login);

	public boolean forgotpwd(ForgotPwd forgotPwd);
	
	public boolean duplicateEmailCheck(String email);
	

}
