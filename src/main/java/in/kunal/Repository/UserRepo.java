package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByEmail (String email);
	
   public User findByEmailAndPwd(String email, String pwd);

}
