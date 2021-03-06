package jp.co.recruit.webservice.carsensor.data;

import org.json.JSONException;
import org.json.JSONObject;
import jp.co.recruit.webservice.annotation.JSONField;

import jp.co.recruit.webservice.data.RWSItem;

public class Photo extends RWSItem {
	@JSONField("l")
	public String largeURL;
	@JSONField("s")
	public String smallURL;
	@JSONField
	public String caption;

	public Photo(JSONObject obj) throws JSONException {
		super(obj);
	}
	
	@Override
	public String detailUriFormat() {
		return null;
	}

}
