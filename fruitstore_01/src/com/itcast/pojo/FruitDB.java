package com.itcast.pojo;

public class FruitDB {
	private int id;
	private String name;
	private double price;
	private String unit;

	public FruitDB() {
	};

	public FruitDB(String id, String name, String price, String unit) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.price = Double.parseDouble(price);
		this.unit = unit;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
