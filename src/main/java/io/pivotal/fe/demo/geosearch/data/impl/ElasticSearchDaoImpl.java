package io.pivotal.fe.demo.geosearch.data.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import io.pivotal.fe.demo.geosearch.controller.ElasticSearchQueryManager;
import io.pivotal.fe.demo.geosearch.data.model.ElasticSearchHitBucket;
import io.pivotal.fe.demo.geosearch.data.model.ElasticSearchMasterDocument;

@Component
public class ElasticSearchDaoImpl implements GeoBoundingSearchDao{

	private static final Log logger = LogFactory.getLog(ElasticSearchDaoImpl.class);
	
	@Autowired 
	ElasticSearchQueryManager queryManager;
	
	@Override
	public ArrayList<HashMap<String, Object>> getAllGeoBoundedLocations(String lat1, String lon1, String lat2, String lon2){
		
		ArrayList<HashMap<String, Object>> allLocationList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> holder = new HashMap<String, Object>();
		
		String esquery = "{\"query\": {\"bool\" : "
									+ "{\"must\" : "
									+ "{\"match_all\" : {}},\"filter\" : "
									+ "{\"geo_bounding_box\" : {\"location\" : "
									+ "{\"top_right\" : {\"lat\" : "
									+ lat1
									+ ",\"lon\" : "
									+ lon1
									+ "},\"bottom_left\" : {\"lat\" : "
									+ lat2
									+ ",\"lon\" : "
									+ lon2
									+ "}}}}}}}";
		
		try{			
			ElasticSearchMasterDocument jsonJavaRootObject = new Gson().
																fromJson(queryManager.execute("/_search?size=1000", esquery), 
																		ElasticSearchMasterDocument.class);
			
			logger.debug("Query Execution Time: " + jsonJavaRootObject.getTook());
			logger.debug("Query Results Count: " + jsonJavaRootObject.getHits().getTotal());
			
			
			ArrayList<ElasticSearchHitBucket> myList = jsonJavaRootObject.getHits().getHits();
			for (int i=0; i<myList.size(); i++){
				holder = new HashMap<String, Object>(); 
				ElasticSearchHitBucket myHit = myList.get(i);
				Float[] coordinates = new Float[2];
				coordinates[0] = new Float(myHit.get_source().getLocation().getLat());
				coordinates[1] = new Float(myHit.get_source().getLocation().getLon());
				
				holder.put("name", myHit.get_source().getCity()+ ", "+myHit.get_source().getState());
				holder.put("position", coordinates);
				allLocationList.add(holder);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
		}	
		return allLocationList;
	}

}
