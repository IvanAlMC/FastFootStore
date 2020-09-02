package persistence;


public class Utilities {
	public static final String SEMICOLON = ";";
	public Utilities(){
	}

	public static String[] textDivide(String text) {
		return text.split("(;)");
	}
	
	public static String joinStringAndInt(String text1,int text2) {
		return text1+SEMICOLON+text2;
	}
	
	public static String joinString(String text1,String text2) {
		return text1+SEMICOLON+text2;
	}
}
