package com.ty.bootfoodapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.bootfoodapp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.email=:myemail AND u.password=:mypassword")
	User validateUser(@Param("myemail")String email ,@Param("mypassword") String password);
}
