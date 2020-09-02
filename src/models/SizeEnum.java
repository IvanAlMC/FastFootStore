package models;

public enum SizeEnum {
	LITTLE("PEQUEÑO"),
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
