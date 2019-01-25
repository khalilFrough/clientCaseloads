package mainClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import caseManagers.CaseManagerController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import pso.PsoController;



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
	@FXML
	private Label loginStatus;
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		if(this.loginModel.isDatabaseConnected()) {
			this.dbStatus.setText("Connected to DB");
		}else {
			this.dbStatus.setText("Not Connected");
		}
		
		
		this.comboBox.setItems(FXCollections.observableArrayList(option.values()) );
	}
	
//	this method is for the log in button
	
	public void login(ActionEvent event) {
		
		try {
			
			if(this.loginModel.isLogin(this.userName.getText(), this.password.getText(),((option)this.comboBox.getValue()).toString())) {
				Stage stage= (Stage)this.login.getScene().getWindow();
				stage.close();
				
				switch(((option)this.comboBox.getValue()).toString()) {
				
				case"CM":
					CMLogin();
					break;
				case"PSO":
					PSOLogin();
					break;
				
				}
			}
			else {
				this.loginStatus.setText("Wrong UserName and Password");
			}
			
		}catch(Exception localException) {
			
		}
		
		
		
		
	}
	
	public void CMLogin() {
		
		try {
			
			Stage userStage= new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/caseManagers//caseManager.fxml").openStream());
			CaseManagerController cmControl = (CaseManagerController)loader.getController();
			Scene scene= new Scene(root);
			userStage.setScene(scene);
			userStage.setTitle("Case Mangers CaseLoad");
			userStage.setResizable(false);
			userStage.show();
			
		}catch(IOException ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	public void PSOLogin() {
		
		try {
			Stage psoStage= new Stage(); 
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/pso//pso.fxml").openStream());
			PsoController psoControl =(PsoController)loader.getController();
			Scene scene = new Scene(root);
			psoStage.setScene(scene);
			psoStage.setTitle("PSO DashBoard");
			psoStage.setResizable(false);
			psoStage.show();
			
		}catch(IOException ex) {
			ex.printStackTrace();
	
		}
		
	}

}
