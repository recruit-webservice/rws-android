package jp.co.recruit.webservice.data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;
import org.ngsdev.android.adapter.URLRequestAdapter;
import org.ngsdev.android.util.FieldUtil;
import org.ngsdev.android.util.MD5Digest;
import jp.co.recruit.webservice.annotation.JSONField;

import android.net.Uri;

public abstract class Item implements URLRequestAdapter.Item {
	public String code;
	@JSONField
	public String name;
	@JSONField("name_en")
	public String nameEnglish;

	public Item(JSONObject obj) throws JSONException {
		if (obj.has(this.codeField()))
			this.code = obj.getString(this.codeField());

		Class<?> klass = this.getClass();
		Class<?>[] ctArgs = new Class<?>[]{JSONObject.class};
		while (!klass.equals(Object.class)) {
			Field[] fields = klass.getDeclaredFields();
			for (Field f : fields) {
				try {
					Annotation anno = f.getAnnotation(JSONField.class);
					if (anno == null)
						continue;
					Class<?> fkls = f.getType();
					String k = ((JSONField) anno).value();
					if (!FieldUtil.isStringWithAnyText(k))
						k = f.getName();
					if (!obj.has(k))
						continue;
					Object val = obj.get(k);
					if (fkls.equals(String.class)) {
						f.set(this, val.toString());
						continue;
					}
					if (fkls.equals(int.class)) {
						f.setInt(this, Integer.parseInt(val.toString()));
						continue;
					}
					if (fkls.equals(double.class)) {
						f.setDouble(this, Double.parseDouble(val.toString()));
						continue;
					}
					Constructor<?> ct = f.getType().getConstructor(ctArgs);
					if (ct != null)
						f.set(this, ct.newInstance(new Object[]{val}));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			klass = klass.getSuperclass();
		}

	}

	public String codeField() {
		return "code";
	}

	public long getId() {
		return Long.parseLong(new MD5Digest(code).toString(), 16);
	}
	public abstract String detailUriFormat();
	public Uri getUri() {
		String fmt = this.detailUriFormat();
		return FieldUtil.isStringWithAnyText(fmt) ? Uri.parse(String.format(
				fmt, this.code)) : null;
	}

}
