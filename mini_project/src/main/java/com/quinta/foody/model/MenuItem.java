package com.quinta.foody.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="menu_item")
public class MenuItem {

	@Id
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="price")
	private int price;

//	@ManyToOne
//	@JoinColumn(name="restaurent_id")
//	@JsonIgnore
//	private Restaurent restaurent;
//	
//	@ManyToOne
//	@JoinColumn(name="order_id")
//	@JsonIgnore
//	private Order order;
	
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

public MenuItem(String itemName, int price) {
	super();
	this.itemName = itemName;
	this.price = price;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
public String toString() {
	return "MenuItem [itemName=" + itemName + ", price=" + price + "]";
}

}