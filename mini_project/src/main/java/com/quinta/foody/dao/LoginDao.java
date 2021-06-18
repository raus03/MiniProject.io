package com.quinta.foody.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quinta.foody.model.Login;



@Repository
public interface LoginDao extends JpaRepository<Login, String>{


	@Query(" FROM Login where emailId=:emailId1 and password=:pass1")
	public Login findUser(@Param("emailId1") String emailId,@Param("pass1") String password);

//	@Query(" FROM Login where userid=:userid1 and password=:pass1")
//	public Login findUser(@Param("userid1") int userid,@Param("pass1") String password);
	
}