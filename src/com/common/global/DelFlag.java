package com.common.global;

public enum DelFlag {
	VALID("有效", 0), INVALID("无效", 1),REPLACED("被其他数据源替换",2);
	private String memo;
	private Integer value;

	DelFlag(String memo, Integer value) {
		this.memo = memo;
		this.value = value;
	}

	public String getMemo() {
		return memo;
	}

	public Integer getValue() {
		return value;
	}

}
