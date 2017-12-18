package io.pivotal.fe.demo.geosearch.data.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

public class DataLoaderES {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//String response="{\"took\": 1,\"timed_out\": false,\"_shards\": {\"total\": 5,\"successful\": 5,\"failed\": 0},\"hits\": {\"total\": 43,\"max_score\": 1,\"hits\": [{\"_index\": \"my_us_large_cities\",\"_type\": \"city\",\"_id\": \"AV-nXjilqtX70ycO3sYj\",\"_score\": 1,\"_source\": {\"city\": \"Chicago\",\"state\": \"IL\",\"location\": {\"lat\": \"41.8500330\",\"lon\": \"-87.6500523\"}}},{\"_index\": \"my_us_large_cities\",\"_type\": \"city\",\"_id\": \"AV-nXjw3qtX70ycO3sYo\",\"_score\": 1,\"_source\": {\"city\": \"Rockford\",\"state\": \"IL\",\"location\": {\"lat\": \"42.2711311\",\"lon\": \"-89.0939952\"}}}]}}";
		
		//ELasticMasterDocument jsonJavaRootObject = new Gson().fromJson(new FileReader(new File("/Users/gvijayar/git/parks/src/main/java/org/openshift/data/model/Response.txt")), ELasticMasterDocument.class);

		String query = "{\"query\": {\"bool\" : {\"must\" : {\"match_all\" : {}},\"filter\" : {\"geo_bounding_box\" : {\"location\" : {\"top_right\" : {\"lat\" : 44.75,\"lon\" : -79.33},\"bottom_left\" : {\"lat\" : 38.16,\"lon\" : -96.91}}}}}}}";
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost request = new HttpPost("http://tcp.pcfcloud.com:1060/my_us_large_cities/_search?size=1000");
		System.out.println(query);
		request.setEntity(new StringEntity(query));	
		HttpResponse response = client.execute(request);
		// Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer textView = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
		    textView.append(line);
		}
				
		ElasticSearchMasterDocument jsonJavaRootObject = new Gson().fromJson(textView.toString(), ElasticSearchMasterDocument.class);		
		System.out.println(jsonJavaRootObject.getHits().getHits().size());
		
		
	}

}
