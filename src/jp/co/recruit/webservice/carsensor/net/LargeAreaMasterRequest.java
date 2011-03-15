package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class LargeAreaMasterRequest extends MasterRequest {
	public LargeAreaMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/large_area/v1/");
	}
}
