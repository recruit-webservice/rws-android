package jp.co.recruit.webservice.carsensor.net;

import android.content.Context;

public class ColorMasterRequest extends MasterRequest {
	public ColorMasterRequest(Context context) {
		super(context, "/carsensor/color/v1/");
		this.response = new ColorMasterResponse();
	}
}
