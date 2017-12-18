package io.pivotal.fe.demo.geosearch.data.seed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import io.pivotal.fe.demo.geosearch.controller.ElasticSearchQueryManager;

public class ESBootstrapRunner implements CommandLineRunner {
	private static final Log logger = LogFactory.getLog(ESBootstrapRunner.class);

	@Autowired 
	ElasticSearchQueryManager queryManager;
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Initializing Elastic Search");
		
		if (indexExists()){
			deleteIndex();
		}		
	}
	
	public boolean indexExists(){
		return true;
		
	}
	
	public boolean deleteIndex(){
		return true;
		
	}
	
	public boolean loadSchema(){
		return true;
		
	}
	
	public boolean loadIndex(){
		return true;
	}

}
