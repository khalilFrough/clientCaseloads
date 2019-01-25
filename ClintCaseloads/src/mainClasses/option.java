package mainClasses;

public enum option {
	CM, PSO;
	
	private option () {}
	
	public String value() {
		return name(); 
	}
	
	public static option fromvalue(String v) {
		return valueOf(v);
	}

}
