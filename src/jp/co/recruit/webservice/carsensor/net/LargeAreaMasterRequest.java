package jp.co.recruit.webservice.carsensor.net;

import android.content.Context;

public class LargeAreaMasterRequest extends MasterRequest {
	public LargeAreaMasterRequest(Context context) {
		super(context, "/carsensor/large_area/v1/");
		this.response = new LargeAreaMasterResponse();
	}
}
