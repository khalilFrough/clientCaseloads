package pso;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import dbClass.SqliteDbClass;

/*this class is created to control the PSO page and its all functionality.*/

public class PsoController implements Initializable {
//	some global variables which are linked with the scene (actual GUI fields)
	@FXML
	private TextField id; 
	@FXML
	private TextField firstName; 
	@FXML 
	private TextField lastName; 
	@FXML
	private TextField email; 
	@FXML
	private DatePicker date; 
	@FXML
	private TableView<CaseManagersData> caseManagerTable;
	
//	table columns that shows the data starts here 
	@FXML
	private TableColumn<CaseManagersData, String> tableId;
	@FXML
	private TableColumn<CaseManagersData, String> tableFirstName;
	@FXML
	private TableColumn<CaseManagersData, String> tableLastName;
	@FXML
	private TableColumn<CaseManagersData, String> tableEmail;
	@FXML
	private TableColumn<CaseManagersData, String> tableDob;
	
	private SqliteDbClass dc; 
	private ObservableList<CaseManagersData> data;
	private String sql= "SELECT * FROM caseManagers";
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		this.dc= new SqliteDbClass(); 
		
	}
	
//	
	
	@FXML
	private void loadCmData(ActionEvent event) throws SQLException{
		
		try {
//			getting the data from the SqliteDbClass and the getConnection method which is connected to database 
			
			Connection conn= SqliteDbClass.getConnection();
			this.data=FXCollections.observableArrayList();
			ResultSet rs= conn.createStatement().executeQuery(sql);
			
//			the while loop is used to read the data from the database, but we still need to display it. 
			while(rs.next()) {
//				the numbers in the rs.getString(1) correspondence with the database columns that gets the data
				this.data.add(new CaseManagersData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
		
//		after reading we need to display our data to the table in the app scene. 
		
//		getting the variables from the CaseManagersData Class ..........................this|| variable
		this.tableId.setCellValueFactory(new PropertyValueFactory<CaseManagersData,String>("ID"));
		
//		getting the variables from the CaseManagersData Class ..........................this|| variable
		this.tableFirstName.setCellValueFactory(new PropertyValueFactory<CaseManagersData,String>("firstName"));
		

//		getting the variables from the CaseManagersData Class ..........................this|| variable
		this.tableLastName.setCellValueFactory(new PropertyValueFactory<CaseManagersData,String>("lastName"));
		

//		getting the variables from the CaseManagersData Class ..........................this|| variable
		this.tableEmail.setCellValueFactory(new PropertyValueFactory<CaseManagersData,String>("email"));
		

//		getting the variables from the CaseManagersData Class ..........................this|| variable
		this.tableDob.setCellValueFactory(new PropertyValueFactory<CaseManagersData,String>("dob"));
		
		this.caseManagerTable.setItems(null);
		this.caseManagerTable.setItems(this.data);	
	}
	
//	this method is created to add data to the database 
	
	@FXML
	private void addCaseManager(ActionEvent event) {
		String EnterCmData="INSERT INTO caseManagers(id, Name, LastName, email, DOB) VALUES(?,?,?,?,?)";
		
		try {	
			Connection conn= SqliteDbClass.getConnection();
			PreparedStatement st= conn.prepareStatement(EnterCmData);
			
			st.setString(1, this.id.getText());
			st.setString(2, this.firstName.getText());
			st.setString(3,	this.lastName.getText());
			st.setString(4, this.email.getText());
			st.setString(5, this.date.getEditor().getText());
			st.execute();
			conn.close();
			
		}catch(SQLException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
			
		}
	}
	
//	this method is used for clearing the form 
	
	@FXML
	private void clearFields(ActionEvent event) {
		this.id.setText("");
		this.firstName.setText("");
		this.lastName.setText("");
		this.email.setText("");
		this.date.setValue(null);
		
	}


}
