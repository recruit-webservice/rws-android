package jp.co.recruit.webservice.carsensor.data;

import org.json.JSONException;
import org.json.JSONObject;

import jp.co.recruit.webservice.data.RWSItem;

public class Prefecture extends RWSItem {

	public Prefecture(JSONObject obj) throws JSONException {
		super(obj);
	}

	@Override
	public String detailUriFormat() {
		return null;
	}

}
