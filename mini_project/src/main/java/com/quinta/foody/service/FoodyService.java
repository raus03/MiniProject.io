package com.quinta.foody.service;

import java.util.List;

import com.quinta.foody.exception.FoodyException;
import com.quinta.foody.model.Login;
import com.quinta.foody.model.MenuItem;
import com.quinta.foody.model.Order;
import com.quinta.foody.model.Restaurent;
import com.quinta.foody.model.SignUp;

public interface FoodyService {

	public List<Restaurent> findAllRestaurents(String emailId) throws FoodyException;
	
//	public Restaurent selectMenuItem(int restaurentId,MenuItem menuItem) throws FoodyException ;
	
	public Order placeOrder(int restaurentId,int quantity,int price,String itemName) throws FoodyException;
	
	public Login findUser(String emailId , String password) throws FoodyException;

	public Restaurent  findRestaurentById(int restaurentId) throws FoodyException; 
	
//	public SignUp createSignUp(String fullName,String emailid,String password) throws FoodyException;

	public SignUp createSignUp(SignUp signUp) throws FoodyException;

	
}
