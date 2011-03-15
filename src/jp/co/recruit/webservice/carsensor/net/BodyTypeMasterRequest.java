package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class BodyTypeMasterRequest extends MasterRequest {
	public BodyTypeMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/body/v1/");
	}
}
