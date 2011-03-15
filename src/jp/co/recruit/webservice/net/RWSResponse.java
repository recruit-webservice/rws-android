package jp.co.recruit.webservice.net;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ngsdev.android.net.impl.JSONResponse;
import jp.co.recruit.webservice.data.Item;

public abstract class RWSResponse extends JSONResponse {

	private ArrayList<Item> items;
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
		items = new ArrayList<Item>();
		JSONArray ar = res.getJSONArray(this.getItemKey());
		for (int i = 0; i < ar.length(); i++) {
			items.add(this.createNewEntry(ar.getJSONObject(i)));
		}

	}
	public Item createNewEntry(JSONObject obj) throws SecurityException,
			NoSuchMethodException, JSONException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class<? extends Item> cls = this.getItemClass();
		Class<?> argt[] = new Class<?>[1];
		argt[0] = JSONObject.class;
		Constructor<? extends Item> ct = cls.getConstructor(argt);
		Object args[] = new Object[1];
		args[0] = obj;
		return ct.newInstance(args);
	}

	public abstract Class<? extends Item> getItemClass();

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
	public ArrayList<? extends Item> getItems() {
		return items;
	}

}
