package com.quinta.foody.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="restaurent_tbl")
public class Restaurent {

	@Id
	@Column(name="restaurent_id")
//	@GeneratedValue(generator="mygen",strategy=GenerationType.AUTO)
	private int restaurentId;
//	@SequenceGenerator(name="mygen",sequenceName="restaurent_seq",allocationSize=1)
	
	@Column(name="restaurent_name",length=20)
	private String restaurentName;
	
	@Column(name="location",length=20)
	private String location;
	
	@Column(name="rating")
	private int rating;
	
//	@Column(name="menuItem")
//	private MenuItem menuItem;
	
//	@OneToMany(mappedBy="restaurent")
//	private List<MenuItem> menuItems=new ArrayList<MenuItem>();
//	@ManyToOne
//	@JoinColumn(name="item_name")
//	@JsonIgnore
//	private MenuItem menuItem;
	
	public Restaurent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurent(int restaurentId, String restaurentName, String location, int rating) {
		super();
		this.restaurentId = restaurentId;
		this.restaurentName = restaurentName;
		this.location = location;
		this.rating = rating;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurent [restaurentId=" + restaurentId + ", restaurentName=" + restaurentName + ", location="
				+ location + ", rating=" + rating + "]";
	}

	
	
	}