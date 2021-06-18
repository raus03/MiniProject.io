package com.quinta.foody.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinta.foody.model.SignUp;

@Repository
public interface SignUpDao extends JpaRepository<SignUp,Long>  {


}
