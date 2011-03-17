package jp.co.recruit.webservice.carsensor.net;

import android.content.Context;

public class CountryMasterRequest extends MasterRequest {
	public CountryMasterRequest(Context context) {
		super(context, "/carsensor/country/v1/");
		this.response = new CountryMasterResponse();
	}
}
