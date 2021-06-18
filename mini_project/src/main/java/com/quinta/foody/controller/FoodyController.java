package com.quinta.foody.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinta.foody.exception.FoodyException;
import com.quinta.foody.model.Login;
import com.quinta.foody.model.Order;
import com.quinta.foody.model.Restaurent;
import com.quinta.foody.model.SignUp;
import com.quinta.foody.service.FoodyService;

@RestController
@CrossOrigin("*")
public class FoodyController {
	
	@Autowired
	FoodyService foodyService;
	
	@GetMapping("admin/login/{email}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("email") String emailId, @PathVariable("pass") String password) throws FoodyException
	{
	  
		 Login log = foodyService.findUser(emailId,password);
		 if(log==null) {
			 throw new FoodyException("Login not successful");
		 }
		 return new ResponseEntity<Login>(log,HttpStatus.OK);
		 
		 
	}
	
	@GetMapping("restaurents/id/{emailId}")
	public ResponseEntity<List<Restaurent>> findAllRestaurents(@PathVariable("emailId") String emailId) throws FoodyException{
		List<Restaurent> list=foodyService.findAllRestaurents(emailId);
		return new ResponseEntity<List<Restaurent>>(list,HttpStatus.OK);
	}
	
//	@PutMapping("restaurent/id/{restaurentId}/items/{items}")
//	public ResponseEntity<Restaurent> selectMenuItems(@PathVariable("restaurentId") int restaurentId,@PathVariable("items") List<MenuItem> items) throws FoodyException{
//		Restaurent restaurent=foodyService.selectMenuItems(restaurentId, items);
//		return new ResponseEntity<Restaurent>(restaurent,HttpStatus.OK);
//	}
	
//	@ResponseBody
	
//	@GetMapping("order/{restaurentId}/{quantity}/{price}/{itemName}")
//	public ResponseEntity<Order> placeOrder(@PathVariable("restaurentId") int restaurentId,@PathVariable("quantity") int quantity,@PathVariable("price") int price,@PathVariable("itemName") String itemName) throws FoodyException{
//	    Order order=foodyService.placeOrder(restaurentId,quantity,price,itemName);
//	    return new ResponseEntity<Order>(order,HttpStatus.OK);
//	}
	
	@GetMapping("order/{restaurentId}/{quantity}/{price}/{itemName}")
	public ResponseEntity<Order> placeOrder(@PathVariable("restaurentId") int restaurentId,@PathVariable("quantity") int quantity,@PathVariable("price") int price,@PathVariable("itemName") String itemName) throws FoodyException{
	    Order order=foodyService.placeOrder(restaurentId,quantity,price,itemName);
	    return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@GetMapping("restaurent/id/{restaurentId}")
	public ResponseEntity<Restaurent> findRestaurentById(@PathVariable("restaurentId") int restaurentId) throws FoodyException {
	   Restaurent restaurent=foodyService.findRestaurentById(restaurentId);
	   return new ResponseEntity<Restaurent>(restaurent,HttpStatus.OK);
	}

	@PostMapping("/signUp")
	public ResponseEntity<SignUp> createSignUp(@RequestBody SignUp signUp) throws FoodyException{
		SignUp s=foodyService.createSignUp(signUp);
		ResponseEntity<SignUp> re=new ResponseEntity<SignUp>(s,HttpStatus.OK);
		return re ;
		
	}
	
	
}
