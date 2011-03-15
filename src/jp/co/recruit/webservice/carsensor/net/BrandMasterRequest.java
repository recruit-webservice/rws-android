package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class BrandMasterRequest extends MasterRequest {
	public BrandMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/brand/v1/");
	}
}
