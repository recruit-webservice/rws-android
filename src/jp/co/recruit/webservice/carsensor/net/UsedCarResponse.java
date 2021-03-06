package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.UsedCar;
import jp.co.recruit.webservice.data.RWSItem;
import jp.co.recruit.webservice.net.RWSResponse;

public class UsedCarResponse extends RWSResponse {
	@Override
	public Class<? extends RWSItem> getItemClass() {
		return UsedCar.class;
	}
	@Override
	public String getItemKey() {
		return "usedcar";
	}
}
