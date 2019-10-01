package com.example.demo.models;

public class CatalogItem {

	private Integer id=0;
	private String name;
	private String desc;
	private int rating;
	
	public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public CatalogItem(String name, String desc, int rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	public CatalogItem(String name, String desc, int rating,int id) {
		super();
		this.id=id;
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	
	

}
