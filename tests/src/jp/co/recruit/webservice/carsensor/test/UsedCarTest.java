package jp.co.recruit.webservice.carsensor.test;

import jp.co.recruit.webservice.carsensor.*;
import jp.co.recruit.webservice.net.RWSRequest;

import java.net.URISyntaxException;

import org.ngsdev.android.util.Log20;

import android.test.InstrumentationTestCase;

public class UsedCarTest extends InstrumentationTestCase {
	private static final String TAG = "UsedCarTest";

	protected void setUp() throws Exception {
		Log20.enable = true;
		Log20.Tag = TAG;
		RWSRequest.defaultApiKey = "2e9f07a047728523";
	}
	
	public void testRequest() throws URISyntaxException {
		UsedCarRequest req = new UsedCarRequest(this.getInstrumentation().getContext());
		req.bodyCode = "C";
		Log20.d(req.getURLRequestParams().toQueryString());
	}
	
	
}
