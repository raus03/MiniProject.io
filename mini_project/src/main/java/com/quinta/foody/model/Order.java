package com.quinta.foody.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order_tbl")
public class Order {

	
	@Id
	@Column(name="order_id")
//	@GeneratedValue(generator="mygen",strategy=GenerationType.AUTO)
//	@SequenceGenerator(name="mygen",sequenceName="order_seq",allocationSize=1)
	private int orderId;
	
//	@CreationTimestamp
	@Column(name="ordered_date")
	private LocalDate orderedDate;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private int price;

	@OneToOne
	@JoinColumn(name="item_name")
	@JsonIgnore
	private MenuItem menuItem;
	
	@OneToOne
	@JoinColumn(name="restaurent_id")
	@JsonIgnore
	private Restaurent restaurent;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, LocalDate orderedDate, int quantity, int price, MenuItem menuItem,
			Restaurent restaurent) {
		super();
		this.orderId = orderId;
		this.orderedDate = orderedDate;
		this.quantity = quantity;
		this.price = price;
		this.menuItem = menuItem;
		this.restaurent = restaurent;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	

	public LocalDate getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public Restaurent getRestaurent() {
		return restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedDate=" + orderedDate + ", quantity=" + quantity + ", price="
				+ price + ", menuItem=" + menuItem + ", restaurent=" + restaurent + "]";
	}

	

	}