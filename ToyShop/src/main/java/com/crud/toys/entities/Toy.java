package com.crud.toys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Toys")
public class Toy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String toyName;
	
	private int price;

	public Toy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toy(int id, String toyName, int price) {
		super();
		this.id = id;
		this.toyName = toyName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Toy [id=" + id + ", toyName=" + toyName + ", price=" + price + "]";
	}
	
	
}
