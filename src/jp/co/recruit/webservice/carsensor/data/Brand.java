package jp.co.recruit.webservice.carsensor.data;

import org.json.JSONException;
import org.json.JSONObject;

import jp.co.recruit.webservice.annotation.JSONField;
import jp.co.recruit.webservice.data.RWSItem;

public class Brand extends RWSItem {

	@JSONField
	public Country country;
	public Brand(JSONObject obj) throws JSONException {
		super(obj);
	}

	@Override
	public String detailUriFormat() {
		return null;
	}

}
