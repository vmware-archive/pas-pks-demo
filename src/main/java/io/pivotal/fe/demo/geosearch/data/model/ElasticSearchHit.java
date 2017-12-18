package io.pivotal.fe.demo.geosearch.data.model;

public class ElasticSearchHit {

	private String city;
	private String state;
	private Location location;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String toString(){
		return "City: "+city +"; State: "+state;
	}
	
}
