package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.Prefecture;
import jp.co.recruit.webservice.data.Item;
import jp.co.recruit.webservice.net.RWSResponse;

public class PrefectureMasterResponse extends RWSResponse {
	@Override
	public Class<? extends Item> getItemClass() {
		return Prefecture.class;
	}
	@Override
	public String getItemKey() {
		return "pref";
	}
}
