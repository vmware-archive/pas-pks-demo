package io.pivotal.fe.demo.geosearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.pivotal.fe.demo.geosearch.data.impl.GeoBoundingSearchDao;

@RestController()
public class GeoSearchRestController{

	@Autowired
	GeoBoundingSearchDao geoLocationDataAccess;
	
	@RequestMapping( value="/geobound/find", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET} )
	public String findParksWithin(@RequestParam("lat1") String lat1, 
								  @RequestParam("lon1") String lon1,
							      @RequestParam("lat2") String lat2,
							      @RequestParam("lon2") String lon2) throws IOException {
		
		ArrayList<HashMap<String, Object>> allParksList = geoLocationDataAccess.getAllGeoBoundedLocations(lat1, lon1, lat2, lon2);
		
		return new Gson().toJson(allParksList);
	}		
}
