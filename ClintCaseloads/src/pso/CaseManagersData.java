package pso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CaseManagersData {
	
	private StringProperty ID;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty dob; 
	
//	creating a constructor for this class.
	public CaseManagersData(String id, String firstName, String lastName, String email, String dob) {
		
		this.ID= new SimpleStringProperty(id);
		this.firstName= new SimpleStringProperty(firstName);
		this.lastName= new SimpleStringProperty(lastName);
		this.email= new SimpleStringProperty(email);
		this.dob = new SimpleStringProperty(dob);
		
	}

	
//	getters 
	
	public StringProperty getID() {
		return ID;
	}

	public StringProperty getFirstName() {
		return firstName;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getDob() {
		return dob;
	}

	
//	setters 
	
	public void setID(StringProperty iD) {
		ID = iD;
	}

	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public void setDob(StringProperty dob) {
		this.dob = dob;
	}
	

}
