package sample.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sample.spring.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT x FROM User x WHERE x.name = :name")
	public Optional<User> findByName(@Param("name") String name);	
	
}
