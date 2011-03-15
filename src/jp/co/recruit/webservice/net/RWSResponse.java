package jp.co.recruit.webservice.net;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ngsdev.android.net.impl.JSONResponse;
import jp.co.recruit.webservice.data.RWSItem;

public abstract class RWSResponse extends JSONResponse {

	private ArrayList<RWSItem> items;
	private int total;
	private int start;
	private int count;
	private String apiVersion;
	private ArrayList<Error> errors;

	@Override
	public void processResponse(byte[] byteArray) throws Exception {
		super.processResponse(byteArray);
		JSONObject res = this.getJSONObject().getJSONObject("results");
		if (res.has("api_version"))
			apiVersion = res.getString("api_version");
		if (res.has("error")) {
			JSONArray err = res.getJSONArray("error");
			if (err.length() > 0) {
				errors = new ArrayList<Error>();
				for (int i = 0; i < err.length(); i++) {
					errors.add(new Error(err.getJSONObject(i).getString(
							"message")));
				}
				return;
			}
		}
		if (res.has("results_available"))
			total = res.getInt("results_available");
		if (res.has("results_returned"))
			count = res.getInt("results_returned");
		if (res.has("results_start"))
			start = res.getInt("results_start");
		items = new ArrayList<RWSItem>();
		JSONArray ar = res.getJSONArray(this.getItemKey());
		for (int i = 0; i < ar.length(); i++) {
			items.add(this.createNewEntry(ar.getJSONObject(i)));
		}

	}
	public RWSItem createNewEntry(JSONObject obj) throws SecurityException,
			NoSuchMethodException, JSONException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class<? extends RWSItem> cls = this.getItemClass();
		Class<?> argt[] = new Class<?>[1];
		argt[0] = JSONObject.class;
		Constructor<? extends RWSItem> ct = cls.getConstructor(argt);
		Object args[] = new Object[1];
		args[0] = obj;
		return ct.newInstance(args);
	}

	public abstract Class<? extends RWSItem> getItemClass();

	public abstract String getItemKey();

	public ArrayList<Error> getErrors() {
		return errors;
	}
	public int getTotal() {
		return total;
	}
	public int getStart() {
		return start;
	}
	public int getCount() {
		return count;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public ArrayList<? extends RWSItem> getItems() {
		return items;
	}

}
