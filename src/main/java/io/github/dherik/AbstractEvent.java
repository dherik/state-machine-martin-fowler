package io.github.dherik;

public class AbstractEvent {

	private final String name, code;

	public AbstractEvent(String name, String code) {
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
		this.code(code);
	}

}
