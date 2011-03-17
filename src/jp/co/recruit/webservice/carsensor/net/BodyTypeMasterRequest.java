package jp.co.recruit.webservice.carsensor.net;

import android.content.Context;

public class BodyTypeMasterRequest extends MasterRequest {
	public BodyTypeMasterRequest(Context context) {
		super(context, "/carsensor/body/v1/");
		this.response = new BodyTypeMasterResponse();
	}
}
