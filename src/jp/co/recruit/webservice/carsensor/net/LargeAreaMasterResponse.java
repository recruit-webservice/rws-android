package jp.co.recruit.webservice.carsensor.net;

import jp.co.recruit.webservice.carsensor.data.LargeArea;
import jp.co.recruit.webservice.data.RWSItem;
import jp.co.recruit.webservice.net.RWSResponse;

public class LargeAreaMasterResponse extends RWSResponse {
	@Override
	public Class<? extends RWSItem> getItemClass() {
		return LargeArea.class;
	}
	@Override
	public String getItemKey() {
		return "large_area";
	}
}
