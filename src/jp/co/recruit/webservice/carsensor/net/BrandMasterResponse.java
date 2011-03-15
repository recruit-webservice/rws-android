package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.Brand;
import jp.co.recruit.webservice.data.RWSItem;
import jp.co.recruit.webservice.net.RWSResponse;

public class BrandMasterResponse extends RWSResponse {
	@Override
	public Class<? extends RWSItem> getItemClass() {
		return Brand.class;
	}
	@Override
	public String getItemKey() {
		return "brand";
	}
}
