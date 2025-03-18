package in.kunal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statesId;
	private String statesName;

	@Column(name = "country_id")
	private Integer countryId;

	public Integer getStatesId() {
		return statesId;
	}

	public void setStatesId(Integer statesId) {
		this.statesId = statesId;
	}

	public String getStatesName() {
		return statesName;
	}

	public void setStatesName(String statesName) {
		this.statesName = statesName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

}
