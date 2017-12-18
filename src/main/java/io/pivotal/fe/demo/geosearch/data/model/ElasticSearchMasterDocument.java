package io.pivotal.fe.demo.geosearch.data.model;

public class ElasticSearchMasterDocument {

	private int took;
	private ElasticSearchHitsListing hits;
	
	public int getTook() {
		return took;
	}
	public void setTook(int took) {
		this.took = took;
	}
	public ElasticSearchHitsListing getHits() {
		return hits;
	}
	public void setHits(ElasticSearchHitsListing hits) {
		this.hits = hits;
	}
	
}
