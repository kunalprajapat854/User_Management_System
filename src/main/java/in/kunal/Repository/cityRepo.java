package in.kunal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.City;

public interface cityRepo extends JpaRepository<City, Integer> {

	public List<City> findByStatesId(Integer statesId);

}
