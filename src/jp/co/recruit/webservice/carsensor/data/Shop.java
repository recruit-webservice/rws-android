package jp.co.recruit.webservice.carsensor.data;

import org.json.JSONException;
import org.json.JSONObject;

import jp.co.recruit.webservice.data.RWSItem;

public class Shop extends RWSItem {

	public Prefecture prefecture;
	public double lat;
	public double lng;
	

	public Shop(JSONObject obj) throws JSONException {
		super(obj);
		if (obj.has("pref"))
			this.prefecture = new Prefecture(obj.getJSONObject("pref"));
	}

	@Override
	public String detailUriFormat() {
		return null;
	}

}
