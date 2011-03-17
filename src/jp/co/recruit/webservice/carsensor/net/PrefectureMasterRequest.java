package jp.co.recruit.webservice.carsensor.net;

import org.ngsdev.android.net.URLRequestParams;
import org.ngsdev.android.util.FieldUtil;

import android.content.Context;

public class PrefectureMasterRequest extends MasterRequest {
	public String largeAreaCode = null;
	public PrefectureMasterRequest(Context context) {
		super(context, "/carsensor/pref/v1/");
		this.response = new PrefectureMasterResponse();
	}
	@Override
	public URLRequestParams getURLRequestParams() {
		URLRequestParams params = super.getURLRequestParams();
		if (FieldUtil.isStringWithAnyText(largeAreaCode))
			params.setParameter("large_area", largeAreaCode);
		return params;
	}
}
