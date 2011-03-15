package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.BodyType;
import jp.co.recruit.webservice.data.RWSItem;
import jp.co.recruit.webservice.net.RWSResponse;

public class BodyTypeMasterResponse extends RWSResponse {
	@Override
	public Class<? extends RWSItem> getItemClass() {
		return BodyType.class;
	}
	@Override
	public String getItemKey() {
		return "body";
	}
}
