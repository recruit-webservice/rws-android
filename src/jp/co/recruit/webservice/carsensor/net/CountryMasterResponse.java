package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.Country;
import jp.co.recruit.webservice.data.Item;
import jp.co.recruit.webservice.net.RWSResponse;

public class CountryMasterResponse extends RWSResponse {
	@Override
	public Class<? extends Item> getItemClass() {
		return Country.class;
	}
	@Override
	public String getItemKey() {
		return "country";
	}
}
