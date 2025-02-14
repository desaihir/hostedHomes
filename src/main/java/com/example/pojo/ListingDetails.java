//ListingDetails.java
package com.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "listing_details")
public class ListingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "listingdetails_id")
	private Long listingDetailsId;

	@Column(name = "listing_id")
	private Long listing;
	
	private String location;
	private double cost;
	private int beds;
	private int baths;
	private double ratings;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "listing_id")
//    private Listing listing;
//	private Long listing;
	
//	@Column(columnDefinition = "text[]")
	private String[] facilities;

	public Long getListingDetailsId() {
		return listingDetailsId;
	}

	public void setListingId(Long listingDetailsId) {
		this.listingDetailsId = listingDetailsId;
	}
	
//	public Listing getListing() {
//		return listing;
//	}
//
//	public void setListing(Listing listing) {
//		this.listing = listing;
//	}

	public Long getListing() {
		return listing;
	}

	public void setListing(Long listing) {
		this.listing = listing;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String[] getFacilities() {
		return facilities;
	}

	public void setFacilities(String[] facilities) {
		this.facilities = facilities;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

//
//package com.example.pojo;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "listing_details")
//public class ListingDetails {
//
//    @Id
//    @Column(name = "listing_id")
//    private Long listingId;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "cost")
//    private double cost;
//
//    @Column(name = "beds")
//    private int beds;
//
//    @Column(name = "baths")
//    private int baths;
//
//    @Column(name = "ratings")
//    private double ratings;
//
//    @Column(name = "facilities")
//    private String[] facilities;
//
//	public Long getListingId() {
//		return listingId;
//	}
//
//	public void setListingId(Long listingId) {
//		this.listingId = listingId;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public double getCost() {
//		return cost;
//	}
//
//	public void setCost(double cost) {
//		this.cost = cost;
//	}
//
//	public int getBeds() {
//		return beds;
//	}
//
//	public void setBeds(int beds) {
//		this.beds = beds;
//	}
//
//	public int getBaths() {
//		return baths;
//	}
//
//	public void setBaths(int baths) {
//		this.baths = baths;
//	}
//
//	public double getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(double ratings) {
//		this.ratings = ratings;
//	}
//
//	public String[] getFacilities() {
//		return facilities;
//	}
//
//	public void setFacilities(String[] facilities) {
//		this.facilities = facilities;
//	}
//
//    // Getters and setters
//    
//}
