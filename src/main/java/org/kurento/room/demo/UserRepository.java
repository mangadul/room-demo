package org.kurento.room.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByEmail(String email);

  	@Query(value = "select * from user where username = ?1 and password = ?2", nativeQuery = true)
  	List<User> findByUsernameAndPassword(String username, String password);
}

