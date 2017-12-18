package io.pivotal.fe.demo.geosearch.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearchServiceController {

	 private static final Log logger = LogFactory.getLog(ElasticSearchServiceController.class);
	 
	 @Value("${elastic_search.client.service.serviceUrl}")
	 private String elasticSearchUrl;
	 
	 @Value("${elastic_search.client.service.servicePort}")
	 private String elasticSearchPort;
	 
	 @Value("${elastic_search.client.service.esindex}")
	 private String elasticSearchIndex;
	 
	 public String getElasticSearchServiceUrl(){
		 return elasticSearchUrl;
	 }
	 
	 public String getElasticSearchServicePort(){
		 return elasticSearchPort;
	 }
	 
	 public String getElasticSearchIndex(){
		 return elasticSearchIndex;
	 }
	 
	 public String toString(){
		 logger.debug("Elastic Search URL: " + elasticSearchUrl + ":" + elasticSearchPort + "/" + elasticSearchIndex);
		 return elasticSearchUrl + ":" + elasticSearchPort + "/" + elasticSearchIndex;
	 }
}
