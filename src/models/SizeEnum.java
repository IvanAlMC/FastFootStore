package models;

public enum SizeEnum {
	LITTLE("PEQUE�O"),
	MEDIUM("MEDIO"),
	BIG("GRANDE");
	
	private String name;
	
	private SizeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
