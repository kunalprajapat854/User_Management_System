package in.kunal.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	@Column(unique = true, updatable = true)
	private String email;
	@Column(length = 10, unique = true)
	private String phno;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	@ManyToOne
	@JoinColumn(name = "states_id")
	private States states;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(unique = true, updatable = true, name = "Password")
	private String pwd;
	private String updatepwd;

	@UpdateTimestamp
	@Column(name = "UpdateDate", insertable = false)
	private LocalDate updateDate;

	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	private LocalDate createdDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUpdatepwd() {
		return updatepwd;
	}

	public void setUpdatepwd(String updatepwd) {
		this.updatepwd = updatepwd;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

}
