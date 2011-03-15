package jp.co.recruit.webservice.carsensor.data;

public enum MissionType {
	NONE(0), AT(1), MT(2);
	private int intVal;
	MissionType(final int val) {
		intVal = val;
	}
	public int toInt() {
		return intVal;
	}
	public MissionType valueOf(int val) {
		for (MissionType d : values()) {
			if (d.toInt() == val) {
				return d;
			}
		}
		return MissionType.NONE;
	}
}
