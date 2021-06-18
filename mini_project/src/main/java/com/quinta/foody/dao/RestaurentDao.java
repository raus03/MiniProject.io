package com.quinta.foody.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinta.foody.model.Restaurent;

@Repository
public interface RestaurentDao extends JpaRepository<Restaurent,Integer> {


	
}
