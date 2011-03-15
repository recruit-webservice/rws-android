package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.Color;
import jp.co.recruit.webservice.data.RWSItem;
import jp.co.recruit.webservice.net.RWSResponse;

public class ColorMasterResponse extends RWSResponse {
	@Override
	public Class<? extends RWSItem> getItemClass() {
		return Color.class;
	}
	@Override
	public String getItemKey() {
		return "color";
	}
}
