package in.kunal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	private String cityName;

	@Column(name = "states_id")
	private Integer statesId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getStatesId() {
		return statesId;
	}

	public void setStatesId(Integer statesId) {
		this.statesId = statesId;
	}

}
