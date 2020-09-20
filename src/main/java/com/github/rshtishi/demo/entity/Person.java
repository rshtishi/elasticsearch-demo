package com.github.rshtishi.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "resource")
public class Person {
	@Id
	private String id;
	private String fullName;
	private int age;
	
	public Person() {
		super();
	}
	public Person(String id, String fullName, int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", fullName=" + fullName + ", age=" + age + "]";
	}
}
