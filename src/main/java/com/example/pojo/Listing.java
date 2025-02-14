// Listing.java
package com.example.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "listings")
public class Listing {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "listing_id")
 private Long id;

 @Column(name = "username")
 private String username;
 
 @Column(name = "location")
 private String location;
 
 @Column(name = "listingname")
 private String listingName;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getListingName() {
	return listingName;
}
public void setListingName(String listingName) {
	this.listingName = listingName;
}

 
}