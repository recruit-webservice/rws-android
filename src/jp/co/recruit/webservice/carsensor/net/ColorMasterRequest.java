package jp.co.recruit.webservice.carsensor.net;

import java.net.URISyntaxException;
import android.content.Context;

public class ColorMasterRequest extends MasterRequest {
	public ColorMasterRequest(Context context) throws URISyntaxException {
		super(context, "/carsensor/color/v1/");
	}
}
