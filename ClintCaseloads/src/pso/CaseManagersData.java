package pso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CaseManagersData {
	private final StringProperty ID;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty email;
	private final StringProperty dob; 
	
//	creating a constructor for this class.
	public CaseManagersData(String id, String firstName, String lastName, String email, String dob) {
		
		this.ID= new SimpleStringProperty(id);
		this.firstName= new SimpleStringProperty(firstName);
		this.lastName= new SimpleStringProperty(lastName);
		this.email= new SimpleStringProperty(email);
		this.dob = new SimpleStringProperty(dob);
		
	}

	
//	getters 
	
	public String getID() {
		return ID.get();
	}
	
	public StringProperty IDProperty() {
		return ID;
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public StringProperty getFirstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getEmail() {
		return email.get();
	}
	public StringProperty getEmailProperty() {
		return email;
	}

	public String getDob() {
		return dob.get();
	}
	public StringProperty getDobProperty() {
		return dob;
	}

	
//	setters 
	
	public void setID(String iD) {
		this.ID.set(iD);
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);;
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public void setDob(String dob) {
		this.dob.set(dob);
	}
	

}
