package in.kunal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Country;
import in.kunal.Entity.States;

public interface statesRepo extends JpaRepository<States, Integer> {
	
	public List<States> findByCountryId(Integer countryId);

}
