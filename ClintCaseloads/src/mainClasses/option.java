package mainClasses;
// this enum is created to create the two options CM and PSO for the applicaiton. 

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
