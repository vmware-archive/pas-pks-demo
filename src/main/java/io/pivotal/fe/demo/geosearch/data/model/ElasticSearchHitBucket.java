package io.pivotal.fe.demo.geosearch.data.model;

public class ElasticSearchHitBucket {

	private String _index;
	private String _type;
	private String _id;
	private ElasticSearchHit _source;
	
	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public ElasticSearchHit get_source() {
		return _source;
	}
	public void set_source(ElasticSearchHit _source) {
		this._source = _source;
	}
	
	
	
}
