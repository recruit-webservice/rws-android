package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class CountryMasterRequest extends MasterRequest {
	public CountryMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/country/v1/");
	}
}
