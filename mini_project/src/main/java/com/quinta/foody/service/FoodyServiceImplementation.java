package com.quinta.foody.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinta.foody.dao.LoginDao;
import com.quinta.foody.dao.MenuItemDao;
import com.quinta.foody.dao.OrderDao;
import com.quinta.foody.dao.RestaurentDao;
import com.quinta.foody.dao.SignUpDao;
import com.quinta.foody.exception.FoodyException;
import com.quinta.foody.model.Login;
import com.quinta.foody.model.MenuItem;
import com.quinta.foody.model.Order;
import com.quinta.foody.model.Restaurent;
import com.quinta.foody.model.SignUp;

@Service
public class FoodyServiceImplementation implements FoodyService {

	@Autowired
	RestaurentDao restaurentDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	MenuItemDao menuItemDao;
	
	@Autowired
	SignUpDao signUpDao;
	
	@Override
	public List<Restaurent> findAllRestaurents(String emailId) throws FoodyException {
		List<Restaurent> list=null;
		if(loginDao.existsById(emailId))
		{
//		System.out.println(restaurentDao.findAll());
		list=restaurentDao.findAll();
		}
		return list;
	}

	
//	@Override
//	public Restaurent selectMenuItem(int restaurentId,MenuItem menuItem) throws FoodyException {
//		Restaurent restaurent=restaurentDao.findById(restaurentId).get();
//		List<MenuItem> menuItems=restaurent.getMenuItems();
//		restaurent.setMenuItems(menuItem);
//		restaurentDao.saveAndFlush(restaurent);
//		return restaurent;
//	}

	@Override
	public Order placeOrder(int restaurentId,int quantity,int price,String itemName) throws FoodyException {
		Restaurent restaurent=restaurentDao.findById(restaurentId).get();
		Order order=new Order();
		Random random = new Random();   
		int orderId = random.nextInt(50);  
		order.setOrderId(orderId);
		order.setOrderedDate(LocalDate.now());
		order.setQuantity(quantity);
		order.setRestaurent(restaurent);
		MenuItem menuItem=menuItemDao.findById(itemName).get();
        order.setMenuItem(menuItem);
		int p=order.getMenuItem().getPrice();
		order.setPrice(p);
		menuItemDao.saveAndFlush(menuItem);
		restaurentDao.saveAndFlush(restaurent);
		orderDao.saveAndFlush(order);
		return order;
	}
	
	@Override
	public Login findUser(String emailId,String password) throws FoodyException {

		return loginDao.findUser(emailId, password);
	
}


	@Override
	public Restaurent findRestaurentById(int restaurentId) throws FoodyException {
//		Restaurent restaurent=null;
//		if(restaurentDao.existsById(restaurentId))
//		{
//			
//		restaurent=restaurentDao.findById(restaurentId).get();
//		}
//		else
//			throw new FoodyException("id not found");
//		
//		return restaurent;
//	}
		Restaurent restaurent=restaurentDao.findById(restaurentId).get();
		return restaurent;

	}
	
	public SignUp createSignUp(SignUp signUp) throws FoodyException{
		SignUp s=signUpDao.saveAndFlush(signUp);
		return s;

	}
}







