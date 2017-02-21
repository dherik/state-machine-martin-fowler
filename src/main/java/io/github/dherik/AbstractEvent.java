package io.github.dherik;

class AbstractEvent {

	private String name, code;

	AbstractEvent(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void code(String code) {
		this.code = code;
	}

}
