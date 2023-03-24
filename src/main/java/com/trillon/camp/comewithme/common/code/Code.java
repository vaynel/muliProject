package com.trillon.camp.comewithme.common.code;

public enum Code {

	STORAGE_PATH("C:\\Program Files\\CODE\\storage\\");

	public String desc;

	Code(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return desc;
	}

}
