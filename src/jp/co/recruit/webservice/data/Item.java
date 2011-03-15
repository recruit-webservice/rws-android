package jp.co.recruit.webservice.data;

import org.json.JSONException;
import org.json.JSONObject;
import org.ngsdev.android.adapter.URLRequestAdapter;
import org.ngsdev.android.util.MD5Digest;

import android.net.Uri;

public abstract class Item implements URLRequestAdapter.Item {

	public String code;
	public String name;
	public String nameEnglish;

	public Item(JSONObject obj) throws JSONException {
		if (obj.has("name"))
			this.name = obj.getString("name");
		if (obj.has("name_en"))
			this.nameEnglish = obj.getString("name_en");
		if (obj.has(this.codeField()))
			this.code = obj.getString(this.codeField());
	}

	public String codeField() {
		return "code";
	}

	public long getId() {
		return Long.parseLong(new MD5Digest(code).toString(), 16);
	}
	public abstract String detailUriFormat();
	public Uri getUri() {
		return Uri.parse(String.format(this.detailUriFormat(), this.code));
	}

}
