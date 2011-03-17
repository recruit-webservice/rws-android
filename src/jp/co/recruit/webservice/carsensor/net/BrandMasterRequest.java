package jp.co.recruit.webservice.carsensor.net;

import android.content.Context;

public class BrandMasterRequest extends MasterRequest {
	public BrandMasterRequest(Context context) {
		super(context, "/carsensor/brand/v1/");
		this.response = new BrandMasterResponse();
	}
}
