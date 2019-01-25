package mainClasses;

import java.sql.Connection;
import java.sql.SQLException; 
import dbClass.SqliteDbClass;
public class LoginModel {
	
	Connection connection; 
	
	public LoginModel() {
		
		try {
			this.connection= SqliteDbClass.getConnection();
		}catch(SQLException ex){
			ex.printStackTrace();
			
		}
		if(this.connection==null) {
			System.exit(1);
		}
	}

}
