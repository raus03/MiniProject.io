package com.quinta.foody.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinta.foody.model.MenuItem;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem,String>  {

	
}
