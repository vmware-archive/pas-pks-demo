package io.pivotal.fe.demo.geosearch.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ElasticSearchQueryManager {

	private static final Log logger = LogFactory.getLog(ElasticSearchQueryManager.class);
	
	@Autowired
	ElasticSearchServiceController esController;
	
	public String execute(String escommand, String esquery){
		CloseableHttpClient client = null;
		BufferedReader rd = null;
		StringBuffer textView = new StringBuffer();
		
		try{
			client = HttpClients.createDefault();
			HttpPost request = new HttpPost(esController.toString() + escommand);

			request.setEntity(new StringEntity(esquery));	
			HttpResponse response = client.execute(request);

			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
			    textView.append(line);
			}
					
			return textView.toString();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				client.close();
				rd.close();
			} catch (IOException e) {
			}
			
		}	
		logger.trace(textView.toString());
		return textView.toString();
	}
	
}
