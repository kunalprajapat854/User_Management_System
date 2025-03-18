package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Country;

public interface countryRepo extends JpaRepository<Country, Integer>{

}
