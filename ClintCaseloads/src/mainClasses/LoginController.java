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
import mainClasses.option; 
/*
 this class is created to control the whole application. 
 it controls the login page that gets the data from the LoginModel class. 
 */

public class LoginController implements Initializable  {
	
//	making a instance of LoginMode class. Later used it to read the data from database. 
	
	LoginModel loginModel = new LoginModel();
//	some global variables which have direct links to the ids of the app components  
	@FXML
	private Label dbStatus;
	@FXML
	private TextField userName;
	@FXML 
	private PasswordField password; 
	@FXML
	private ComboBox<option>comboBox;
	@FXML
	private Button login; 
	@FXML
	private Label loginStatus;
	
/* this method is used to indicate of the application is connected to the database 
 it changes the label on the app to connected and not connected */
	
	public void initialize(URL url, ResourceBundle rb) {
		
		if(this.loginModel.isDatabaseConnected()) {
			this.dbStatus.setText("Connected to DB");
		}else {
			this.dbStatus.setText("Not Connected");
		}
		
		this.comboBox.setItems(FXCollections.observableArrayList(option.values()));
	}
	
//	this method is for the log in button which also checks if the user entered the right credentials.  
	
	@FXML
	public void login(ActionEvent event) {
		
		try {
//			checks if the text entered in the textfield match the user and password in the database. 
			if(this.loginModel.isLogin(this.userName.getText(), this.password.getText(),((option)this.comboBox.getValue()).toString())) {
				//once the other window opens then the login window should close. 
				Stage stage= (Stage)this.login.getScene().getWindow();
				stage.close();
				
					//checking the cases for two users CMs and PSOs
					switch(((option)this.comboBox.getValue()).toString()) {
					case "CM":
						CMLogin();
						break;
					case "PSO":
						PSOLogin();
						break;
					}
				
			}else {
				this.loginStatus.setText("Wrong User or Password");
			}
			
		}catch(Exception localException) {
			localException.getMessage();
		}
			
	}
	
//	this method is called when CM is logged in
	
	
//	this method is tested it works fine. 
	public void CMLogin() {
		System.out.println("something");
		
		try {
			
			Stage caseManagerStage= new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = (Pane)loader.load(getClass().getResource("/caseManagers//caseManagers.fxml").openStream());
			
			CaseManagerController cmControl = (CaseManagerController)loader.getController();
			
			Scene scene= new Scene(root);
			caseManagerStage.setScene(scene);
			caseManagerStage.setTitle("Case Mangers CaseLoad");
			caseManagerStage.setResizable(false);
			caseManagerStage.show();
			
		}catch(IOException ex) {
			
			ex.printStackTrace();
		} 
		
	}
	
//	this method is for the PSO login
//	this method is tested it works fine. 
	public void PSOLogin() {
		
		try {
			Stage psoStage= new Stage(); 
			FXMLLoader psoloader = new FXMLLoader();
			Pane psoRoot = (Pane)psoloader.load(getClass().getResource("/pso//pso.fxml").openStream());
			PsoController psoControl =(PsoController)psoloader.getController();
			Scene scene = new Scene(psoRoot);
			psoStage.setScene(scene);
			psoStage.setTitle("PSO DashBoard");
			psoStage.setResizable(false);
			psoStage.show();
			
		}catch(IOException e) {
			e.printStackTrace();
	
		}
		
	}

}
