import java.sql.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.applet.Main;

public class MainPage extends Application implements EventHandler<ActionEvent> {
	// members of the class
	TableView<Student> Table;
	Stage Window = new Stage();
	Scene MISscene;
	//Scene LoginScene;
	GridPane gp = new GridPane();
	Label user = new Label("UserName:");
	Label Password = new Label("Password:");
	Button logbtn = new Button("Login");
	Button cancelbtn = new Button("Cancel");
	PasswordField passfield = new PasswordField();
	TextField logtxt = new TextField();
	BorderPane bp = new BorderPane();
	Scene loginscene = new Scene(bp, 400, 200);
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Window = primaryStage;// set the stage as member of the class so we can access it from different
								// methods

		// login face initialization
		gp.add(user, 0, 0);
		gp.add(Password, 0, 1);
		gp.add(logbtn, 0, 2);
		gp.add(logtxt, 1, 0);
		gp.add(passfield, 1, 1);
		gp.add(cancelbtn, 1, 2);
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(5);
		gp.setVgap(10);
		bp.setCenter(gp);
		
		logbtn.setOnAction(e -> handle(e));// register the event to the handler

		cancelbtn.setOnAction(e -> {
			Window.close();// if cancel is pressed just close the stage
		});
		// the main stage initialization
		
		
		Window.setScene(loginscene);
		Window.setTitle("ZJNU's Students MIS");
		Window.show();
		
				
	}
	@Override
	public void handle(ActionEvent event) {//to handle the login face 

		try {
			//sql connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
			//String sql = "SELECT * FROM staff WHERE emp_id = ? AND password = ?";
			PreparedStatement stat = con.prepareStatement("SELECT * FROM staff WHERE emp_id = ? AND password = ?");
			stat.setInt(1,Integer.valueOf(logtxt.getText()));
			stat.setString(2, passfield.getText());
			ResultSet rs = stat.executeQuery();
			Alert al = new Alert(AlertType.NONE);
			if (rs.next()) {
				//show confirmation alert 
				al.setAlertType(AlertType.INFORMATION);
				al.setTitle("login successful...");
				al.setHeaderText("Welcome Mr/Mrs."+rs.getString("last_name"));
				al.showAndWait();
				Window.close();
				SectionsPage sp = new SectionsPage();
				sp.start(sp.Window);
				//Window.setScene(MISscene);//and switch to the MISscene which includes the TableView
			} else {
				//if there is no records according to the username and password given show an error alert
				al.setAlertType(AlertType.ERROR);
				al.setContentText("inccorect username or password...");
				al.showAndWait();
			}
			con.close();
		} catch (Exception x) {
			System.out.print(x);
		}

	}

	public static void main(String[] args) {

		launch(args);

	}

}
