package jp.co.recruit.webservice.carsensor.data;

public enum DatumType {
	WORLD("world"), TOKYO("tokyo");
	private String strVal;
	DatumType(final String val) {
		strVal = val;
	}
	public String toString() {
		return strVal;
	}
}
