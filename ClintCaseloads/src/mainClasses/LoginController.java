package mainClasses;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable  {
	
	LoginModel loginModel = new LoginModel();
	@FXML
	private Label dbStatus;
	@FXML
	private TextField userName;
	@FXML 
	private PasswordField password; 
	@FXML
	private ComboBox <option> comboBox;
	@FXML
	private Button login; 
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		if(this.loginModel.isDatabaseConnected()) {
			this.dbStatus.setText("Connected to DB");
		}else {
			this.dbStatus.setText("Not Connected");
		}
		
		
		this.comboBox.setItems(FXCollections.observableArrayList(option.values()) );
	}

}
