package com.caps.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dogs_info")
public class Dog {
	@Id @Column(name="dog_id")
	private int dogId;
	
	private String name;
	
	private String color;
	
	private String breed;
	
	
	public int getDogId() {
		return dogId;
	}
	public void setDogId(int dogId) {
		this.dogId = dogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", name=" + name + ", color=" + color + ", breed=" + breed + "]";
	}
}
