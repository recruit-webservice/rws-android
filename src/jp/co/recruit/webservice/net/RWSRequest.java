package jp.co.recruit.webservice.net;

import java.net.URI;
import java.net.URISyntaxException;

import org.ngsdev.android.net.URLRequest;
import org.ngsdev.android.net.URLRequestParams;
import org.ngsdev.android.util.FieldUtil;

import android.content.Context;

public class RWSRequest extends URLRequest {

	public String apiKey = "";
	public static String defaultApiKey = "";
	public int order;
	public int start;
	public int count;
	public static String apiHost = "webservice.recruit.co.jp";

	public RWSRequest(Context context, String apiDir) throws URISyntaxException {
		super(context, new URI("http", apiHost, apiDir, null));
	}

	@Override
	public URLRequestParams getURLRequestParams() {
		URLRequestParams params = new URLRequestParams();
		String apiKey = this.apiKey;
		if (!FieldUtil.isStringWithAnyText(apiKey))
			apiKey = RWSRequest.defaultApiKey;
		if (!FieldUtil.isStringWithAnyText(apiKey))
			throw new Error("You must specify apiKey");
		params.setParameter("key", apiKey);
		params.setParameter("format", "json");
		if (order > 0)
			params.setIntParameter("order", order);
		if (count > 0)
			params.setIntParameter("count", count);
		if (start > 0)
			params.setIntParameter("start", start);
		return params;
	}

	@Override
	public boolean send(RequestListener listener) {
		return super.send(listener);
	}

}
