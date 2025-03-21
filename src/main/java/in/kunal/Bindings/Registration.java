package in.kunal.Bindings;

public class Registration {

	private String name;
	private String email;
	private String phno;
	private String pwd;
	private String updatepwd;

	private Integer countryId;
	private Integer statesId;
	private Integer cityId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStatesId() {
		return statesId;
	}

	public void setStatesId(Integer statesId) {
		this.statesId = statesId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getUpdatepwd() {
		return updatepwd;
	}

	public void setUpdatepwd(String updatepwd) {
		this.updatepwd = updatepwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	

}
