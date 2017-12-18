package io.pivotal.fe.demo.geosearch.data.impl;

import java.util.ArrayList;
import java.util.HashMap;

public interface GeoBoundingSearchDao {

	public ArrayList<HashMap<String, Object>> getAllGeoBoundedLocations(String lat1, String lon1, String lat2, String lon2);
	
}
