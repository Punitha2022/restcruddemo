package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Post {
	@Id
	@SequenceGenerator(name = "post_seq",sequenceName = "post_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_seq")
private int id;
private String title;
private String body;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}

}
