package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class PrefectureMasterRequest extends MasterRequest {
	public PrefectureMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/pref/v1/");
	}
}
