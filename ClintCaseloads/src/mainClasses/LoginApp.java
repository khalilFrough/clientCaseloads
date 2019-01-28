package mainClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*this is the main class which runs the application. */
public class LoginApp extends Application {
	
	public void start(Stage stage) throws Exception {
		Parent root =  (Parent) FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene= new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client's CaseLoad");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
