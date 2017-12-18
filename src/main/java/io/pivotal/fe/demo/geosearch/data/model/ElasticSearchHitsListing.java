package io.pivotal.fe.demo.geosearch.data.model;

import java.util.ArrayList;

public class ElasticSearchHitsListing {
	
	private int total;
	private ArrayList<ElasticSearchHitBucket> hits  = new ArrayList<ElasticSearchHitBucket> ();
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<ElasticSearchHitBucket> getHits() {
		return hits;
	}
	public void setHits(ArrayList<ElasticSearchHitBucket> hits) {
		this.hits = hits;
	}

	
	
}
