package com.example.demo.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, String> {
//search users by first name
	@Query("Select u From User  u Where u.firstname=:fname")
	List<User> getUsersByFName(@Param("fname")String fname);
	//search users by last name
	@Query("Select u From User u Where u.lastname=:lname")
	List<User>getUsersByLName(@Param("lname")String lname);
}
