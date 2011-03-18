package jp.co.recruit.webservice.carsensor.data;
/**
 * ソート順
 */
public enum OrderBy {
	/**
	 * ブランド順
	 */
	BRAND(0),
	/**
	 * 価格安い順
	 */
	PRICE_ASC(1),
	/**
	 * 価格高い順
	 */
	PRICE_DESC(2),
	/**
	 * 車種名順
	 */
	MODEL_NAME(3),
	/**
	 * 年式古い順
	 */
	YEAR_ASC(4),
	/**
	 * 年式新しい順
	 */
	YEAR_DESC(5),
	/**
	 * 走行距離少ない順
	 */
	ODD(6);
	private int intVal;
	OrderBy(final int val) {
		intVal = val;
	}
	public int toInt() {
		return intVal;
	}
	public static OrderBy valueOf(int val) {
		for (OrderBy d : values()) {
			if (d.toInt() == val) {
				return d;
			}
		}
		return OrderBy.BRAND;
	}
}