package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.BodyType;
import jp.co.recruit.webservice.data.Item;
import jp.co.recruit.webservice.net.RWSResponse;

public class BodyTypeMasterResponse extends RWSResponse {
	@Override
	public Class<? extends Item> getItemClass() {
		return BodyType.class;
	}
	@Override
	public String getItemKey() {
		return "body";
	}
}
