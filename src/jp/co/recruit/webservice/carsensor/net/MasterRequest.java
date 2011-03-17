package jp.co.recruit.webservice.carsensor.net;

import org.ngsdev.android.net.URLRequestParams;
import org.ngsdev.android.util.FieldUtil;

import android.content.Context;
import jp.co.recruit.webservice.net.RWSRequest;

public abstract class MasterRequest extends RWSRequest {

	public String code;

	public MasterRequest(Context context, String apiDir) {
		super(context, apiDir);
	}

	@Override
	public URLRequestParams getURLRequestParams() {
		URLRequestParams params = super.getURLRequestParams();
		if (FieldUtil.isStringWithAnyText(code))
			params.setParameter("code", code);
		return params;
	}

}
