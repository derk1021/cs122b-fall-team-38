package com.fabflix.entity;

public class Table {

	private String field;
	private String type;
	private String nullable;
	private String key;
	private String defaultValue;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		if (defaultValue == null) {
			this.setDefaultValue("null");
		} else {
			this.defaultValue = defaultValue;
		}
	}

}
