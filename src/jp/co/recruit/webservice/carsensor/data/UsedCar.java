package jp.co.recruit.webservice.carsensor.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import jp.co.recruit.webservice.annotation.JSONField;
import jp.co.recruit.webservice.data.RWSItem;

public class UsedCar extends RWSItem {
	public static String uriFormat = null;
	/**
	 * Automatically set to fields
	 */
	@JSONField("body")
	public BodyType bodyType;
	@JSONField
	public Brand brand;
	@JSONField
	public Shop shop;
	@JSONField
	public String model;
	@JSONField
	public String grade;
	@JSONField
	public String inspection;
	@JSONField
	public String maintenance;
	@JSONField
	public String warranty;
	@JSONField
	public String recycle;
	@JSONField
	public String color;
	@JSONField
	public String engine;
	@JSONField("desc")
	public String description;
	@JSONField
	public String odd;
	@JSONField
	public int year;
	//
	public int price;
	public String priceMessage;
	public String mobileURL;
	public String qrCodeURL;
	public String pcURL;
	public Photo mainPhoto;
	public ArrayList<Photo> subPhotos;
	public UsedCar(JSONObject obj) throws JSONException {
		super(obj);
		if(obj==null)
			return;
		this.price = obj.optInt("price", -1);
		if (obj.has("price")) {
			if (this.price == -1)
				this.priceMessage = obj.getString("price");
		}
		if (obj.has("urls")) {
			JSONObject urls = obj.getJSONObject("urls");
			this.mobileURL = urls.getString("mobile");
			this.pcURL = urls.getString("pc");
			this.qrCodeURL = urls.getString("qr");
		}
		JSONObject photo = null;
		if (obj.has("photo")) {
			photo = obj.getJSONObject("photo");
			if (photo.has("main")) {
				this.mainPhoto = new Photo(photo.getJSONObject("main"));
			}
		}
		if (obj.has("sub_img")) {
			JSONArray subimgs = obj.getJSONArray("sub_img");
			if (subimgs.length() > 0) {
				this.subPhotos = new ArrayList<Photo>();
				for (int i = 0; i < subimgs.length(); i++) {
					this.subPhotos.add(new Photo(subimgs.getJSONObject(i)));
				}
			}
		}
	}

	@Override
	public String detailUriFormat() {
		return uriFormat;
	}

	@Override
	public String codeField() {
		return "id";
	}

}
