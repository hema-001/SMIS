import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstructorPage extends Application {
	TableView<Instructor> Table;
	Stage Window = new Stage();
	Scene scene;
	Scene LoginScene;
	Scene QueryScene;
	Scene InsertScene;
	Scene EditScene;
	//ObservableList<Student> students;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Window = primaryStage;
		// the tableColumns initialization
				TableColumn<Instructor, Integer> idCol = new TableColumn("ID");
				idCol.setMinWidth(100);
				idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

				TableColumn<Instructor, String> nameCol = new TableColumn("NAME");
				nameCol.setMinWidth(100);
				nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

				TableColumn<Instructor, String> dobCol = new TableColumn("DOB");
				dobCol.setMinWidth(100);
				dobCol.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));

				TableColumn<Instructor, String> genderCol = new TableColumn("GENDER");
				genderCol.setMinWidth(100);
				genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));

				TableColumn<Instructor, String> collCol = new TableColumn("COLLEGE");
				collCol.setMinWidth(100);
				collCol.setCellValueFactory(new PropertyValueFactory<>("college"));
				
				TableColumn<Instructor, Integer> phoneCol = new TableColumn("PHONE");
				phoneCol.setMinWidth(100);
				phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));

				TableColumn<Instructor, String> addressCol = new TableColumn("ADDRESS");
				addressCol.setMinWidth(100);
				addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
				
				TableColumn<Instructor, String> passCol = new TableColumn("PASSWORD");
				passCol.setMinWidth(100);
				passCol.setCellValueFactory(new PropertyValueFactory<>("password"));
				
				TableColumn<Instructor, String> degreeCol = new TableColumn("DEGREE");
				degreeCol.setMinWidth(100);
				degreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
				
				TableColumn<Instructor, String> emailCol = new TableColumn("EMAIL");
				emailCol.setMinWidth(100);
				emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
				
				HBox Hbox = new HBox();
				Hbox.setPadding(new Insets(10, 10, 10, 10));
				Hbox.setSpacing(10);

				// the TableView's Buttons: insert, delete, edit, and query with their events
				// and handlers
				Button insert = new Button("Insert");/*
														 * from this line to line 126 is declaration and initialization of the
														 * insertScene
														 */
				insert.setPrefWidth(200);
				Button Back = new Button("Back");
				Button enter = new Button("Enter");
				Label inslab = new Label("Instructor Info");
				Back.setOnAction(e -> {
					Window.setScene(scene);
					Window.setTitle("ZJNU Students IMS");
					Table.setItems(getInstructorInfo());
				});
				Label insLid = new Label("ID:");
				TextField insTX_id = new TextField();
				insTX_id.setPrefWidth(100);
				Label insLname = new Label("NAME:");
				TextField insTX_name = new TextField();
				insTX_name.setPrefWidth(100);
				Label insLdob = new Label("DOB:");
				TextField insTX_dob = new TextField();
				insTX_dob.setPrefWidth(100);
				Label insLgender = new Label("Gender:");
				TextField insTX_gender = new TextField();
				insTX_gender.setPrefWidth(100);
				Label insLcoll = new Label("College:");
				TextField insTX_coll = new TextField();
				insTX_coll.setPrefWidth(100);
				Label insLaddress = new Label("Address:");
				TextField insTX_address = new TextField();
				insTX_address.setPrefWidth(100);
				Label insLphone = new Label("Phone:");
				TextField insTX_phone = new TextField();
				insTX_phone.setPrefWidth(100);
				Label insLpass = new Label("Password:");
				TextField insTX_pass = new TextField();
				insTX_pass.setPrefWidth(100);
				Label insLdegree = new Label("Degree:");
				TextField insTX_degree = new TextField();
				insTX_degree.setPrefWidth(100);
				Label insLemail = new Label("Email:");
				TextField insTX_email = new TextField();
				insTX_email.setPrefWidth(100);

				VBox Linsbox = new VBox();
				Linsbox.setPadding(new Insets(10, 10, 10, 10));
				Linsbox.setSpacing(10);
				TextField instx = new TextField();
				//tx.setPrefWidth(500);
				//Label lb = new Label(
				//		"Please type the student info.");
				Linsbox.getChildren().addAll(insLid,insLname,insLdob,insLgender,insLcoll,insLaddress,insLphone,insLpass,insLdegree,insLemail);
				VBox insBox = new VBox();
				insBox.setPadding(new Insets(10, 10, 10, 10));
				insBox.getChildren().addAll(insTX_id,insTX_name, insTX_dob, insTX_gender,insTX_coll,insTX_address,insTX_phone,insTX_pass,insTX_degree,insTX_email);
				GridPane insgp = new GridPane();
				insgp.add(Linsbox, 0, 0);
				insgp.add(insBox, 1, 0);
				insgp.add(Back, 0, 1);
				insgp.add(enter, 1, 1);
				InsertScene = new Scene(insgp);
				insert.setOnAction(e -> {
					Window.setTitle("Insert");
					Window.setScene(InsertScene);// if the button insert is pressed change the scene to the insertScene
				});
				enter.setOnAction(e -> {
					String[] arr = {insTX_id.getText(),insTX_name.getText(),insTX_dob.getText(),insTX_gender.getText(),insTX_coll.getText(),
							insTX_address.getText(),insTX_phone.getText(),insTX_pass.getText(),insTX_degree.getText(),insTX_email.getText()};
					if(insertRecord(arr)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Insert Successful");
						alert.setHeaderText("Instructor has been successfully added to the system.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getInstructorInfo());
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Insert Failed");
						alert.setHeaderText("Something wrong happend try again!");
						alert.show();
					}
				});// end of insertScene

				Button delete = new Button("Delete");
				delete.setPrefWidth(200);
				delete.setOnAction(e -> {
					Instructor currins = Table.getSelectionModel().getSelectedItem();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Warning!");
					alert.setHeaderText("Are you sure want to delete this record?");
					alert.setContentText("The deleted record will be removed completly from the system.");
					Optional<ButtonType> option = alert.showAndWait();
					if(option.get() == ButtonType.OK) {
					Table.getItems().remove(currins);// take the highlighted record and send it to the method RemoveRecord()
					RemoveRecord(currins);
					}else if(option.get() == ButtonType.CANCEL) {
						alert.close();
					}
				});
				// from here to line 170 is the editScene
				// following is some declarations and initializations
				Button edit = new Button("Edit");
				edit.setPrefWidth(200);
				
				Label lid = new Label("ID:");
				TextField TX_id = new TextField();
				TX_id.setPrefWidth(100);
				Label lname = new Label("NAME:");
				TextField TX_name = new TextField();
				TX_name.setPrefWidth(100);
				Label ldob = new Label("DOB:");
				TextField TX_dob = new TextField();
				TX_dob.setPrefWidth(100);
				Label lgender = new Label("Gender:");
				TextField tX_gender = new TextField();
				tX_gender.setPrefWidth(100);
				Label lcoll = new Label("College:");
				TextField TX_coll = new TextField();
				TX_coll.setPrefWidth(100);
				Label lphone = new Label("Phone:");
				TextField TX_phone = new TextField();
				TX_phone.setPrefWidth(100);
				Label laddress = new Label("Address:");
				TextField TX_address = new TextField();
				TX_address.setPrefWidth(100);
				Label lpass = new Label("Password:");
				TextField TX_pass = new TextField();
				TX_pass.setPrefWidth(100);
				Label ldegree = new Label("Degree:");
				TextField TX_degree = new TextField();
				TX_degree.setPrefWidth(100);
				Label lemail = new Label("Email:");
				TextField TX_email = new TextField();
				TX_email.setPrefWidth(100);
				
				Button apply = new Button("Apply");
				apply.setOnAction(e -> {
					//String text = eTX.getText();// same technique used in insert before, split and send but this time to
												// UpdateRecord()
					String[] arr = {TX_id.getText(),TX_name.getText(),TX_dob.getText(),tX_gender.getText(),TX_coll.getText(),
							TX_phone.getText(),TX_address.getText(),TX_pass.getText(),TX_degree.getText(),TX_email.getText()};
					if(UpdateRecord(arr)==true) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Edit successfull");
						alert.setHeaderText("Changes has been successfully applied.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getInstructorInfo());
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Edit failed");
						alert.setHeaderText("Something wrong happend try again!");
						alert.show();
					}
				});
				Button eBack = new Button("Back");
				eBack.setOnAction(e -> {
					Window.setTitle("ZJNU Students IMS");
					Window.setScene(scene);// when back is pressed go back to MISscene which is the main scene with the
												// tableView
					Table.setItems(getInstructorInfo());// and invoke the method getStudentInfo() to refresh the table with the new
														// changes
				});
				VBox TX_box = new VBox();
				TX_box.setPadding(new Insets(10, 10, 10, 10));
				TX_box.setSpacing(10);
				VBox Label_box = new VBox();
				Label_box.setPadding(new Insets(10, 10, 10, 10));
				Label_box.setSpacing(20);
				Label_box.getChildren().addAll(lname,ldob,lgender,lcoll,lphone,laddress,lpass,ldegree,lemail);
				TX_box.getChildren().addAll(TX_name,TX_dob,tX_gender,TX_coll,
						TX_phone,TX_address,TX_pass,TX_degree,TX_email);
				GridPane editbox = new GridPane();
				editbox.setPadding(new Insets(10, 10, 10, 10));
				editbox.add(Label_box, 0, 0);
				editbox.add(TX_box, 1, 0);
				editbox.add(apply, 0, 1);
				editbox.add(eBack, 1, 1);
				EditScene = new Scene(editbox);
				edit.setOnAction(e -> {
					
					Instructor instructor = Table.getSelectionModel().getSelectedItem();
					if (instructor == null) {// if edit button is pressed but no record selected, set error message
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("ERROR");
						alert.setHeaderText("No records selected...!");
						alert.show();

					} else {// else get the values of the record selected and show them in the text field
							// seperated by commas
						Window.setTitle("Edit");
						Window.setScene(EditScene);
						TX_id.setText(String.valueOf(instructor.getId()));
						TX_name.setText(instructor.getName());
						TX_dob.setText(instructor.getDate_of_birth());
						tX_gender.setText(instructor.getGender());
						TX_coll.setText(instructor.getCollege());
						TX_phone.setText(instructor.getPhone());
						TX_address.setText(instructor.getAddress());
						TX_pass.setText(instructor.getPassword());
						TX_degree.setText(instructor.getDegree());
						TX_email.setText(instructor.getEmail());
					}
				});// end of editScene

				// from here to line 198 is the queryScene
				Button query = new Button("Search");
				query.setPrefWidth(200);
				Button QBack = new Button("Back");
				Button QOK = new Button("OK");
				TextField Qtx = new TextField();
				Qtx.setPrefWidth(200);
				Label Qlb = new Label("Instructor ID number: ");
				HBox qHBox = new HBox();
				qHBox.setPadding(new Insets(10, 10, 10, 10));
				qHBox.setSpacing(10);
				qHBox.getChildren().addAll(Qlb, Qtx, QOK, QBack);
				QueryScene = new Scene(qHBox);
				query.setOnAction(e -> {
					// start the queryScene
					Window.setScene(QueryScene);
					Window.setTitle("Search");
				});
				QOK.setOnAction(e -> {
					// get the value from the text message as a String and convert it to integer,
					// then send it to the method selectRecord(int)
					if(isNumeric(Qtx.getText())) {
					selectRecord(Long.valueOf(Qtx.getText()));
					Qtx.setText("");
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Invalid value!");
						alert.setHeaderText("The ID must be a number");
						alert.show();
					}
				});
				QBack.setOnAction(e -> {
					Window.setTitle("ZJNU Students IMS");
					Window.setScene(scene);
				});// end of QueryScene

				
				Button backToSecbtn = new Button("Back");
				backToSecbtn.setOnAction(e->{
					try {
					
					SectionsPage sp = new SectionsPage();
					sp.start(sp.Window);
					Window.close();
					}catch(Exception x){
						System.out.println(x.getMessage()+"\n"+x.getStackTrace());
					}
				});
				Hbox.getChildren().addAll(insert, delete, edit, query, backToSecbtn);

				// the TableView initializations
				VBox Vbox = new VBox();
				Table = new TableView<>();
				Table.setItems(getInstructorInfo());
				Table.getColumns().addAll(idCol, nameCol, dobCol, collCol, phoneCol, addressCol, passCol, genderCol,degreeCol,emailCol);
				Vbox.getChildren().addAll(Table, Hbox);
				Vbox.setStyle("-fx-background-color: whitesmoke; -fx-padding: 10;");
				Table.setStyle("-fx-background-color:steelblue ;");

				// the main stage initialization
				scene = new Scene(Vbox);
				Window.setScene(scene);
				Window.setTitle("ZJNU's Students MIS");
				Window.show();

			}
			//a method to select a record according to a given ID number
			private static void selectRecord(Long i) {

				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");//to create sql connection
					//sql preparedStatement with sql query where '?' is the placeholder 
					PreparedStatement myStmt = myConn.prepareStatement("select * from teacher where id = ?"); 
					
					myStmt.setLong(1, i);// this is going to replace the placeholder which is '?'																	

					ResultSet myRs = myStmt.executeQuery();//execute the query and assign it to Resultset
					
					display(myRs);//send the executed resultset result to display() which going to display the result

				} catch (Exception e) {//catch any exception if any 
					System.out.println(e.getMessage());
				}
			

			}
			//done
			private boolean UpdateRecord(String[] s) {

				boolean ret = false;
				try {
					//first three lines to create sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					String sql = "update teacher set name = ?, date_of_birth = ?, gender = ?, college = ?, phone = ?, address = ?, password = ?, degree = ?, email = ?  WHERE id = ?;";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(10, Long.valueOf(s[0]));
					pr.setString(1, s[1]); 
					pr.setString(2, s[2]);
					pr.setString(3, s[3]); 
					pr.setString(4, s[4]);
					pr.setString(5, s[5]);
					pr.setString(6, s[6]);
					pr.setString(7, s[7]);
					pr.setString(8, s[8]);
					pr.setString(9, s[9]);
					
					int id = pr.executeUpdate();
					if(id==1) {
						ret = true;
					}
					con.close();
					


				} catch (Exception e) {
					System.out.println("UpdateRecord() :"+e.getMessage());
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.show();
				}
				return ret;

			}
			//done
			private boolean insertRecord(String[] s) {
				boolean ret = false;
				try {
					//sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					String sql = "insert into teacher values(?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(1, Long.valueOf(s[0]));
					pr.setString(2, s[1]); 
					pr.setString(3, s[2]);
					pr.setString(4, s[3]); 
					pr.setString(5, s[4]);
					pr.setString(6, s[5]);
					pr.setString(7, s[6]);
					pr.setString(8, s[7]);
					pr.setString(9, s[8]);
					pr.setString(10, s[9]);
					int id = pr.executeUpdate();
					if(id == 1) {ret = true;}
					con.close();

				} catch (Exception e) {
					//catch exceptions and print it as error alert
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e + "");
					alert.show();
				}
				return ret;

			}
			//done
			public void RemoveRecord(Instructor s) {

				try {
					//sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					//sql query and preparedStatement 
					String sql = "delete from teacher where id = ?";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(1, s.getId());//replace the placeholder with the values we've got from the selectionModel
					pr.execute();//execute the statement
					con.close();

				} catch (Exception e) {
					//get the exception message and print it in an error alert
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("No Record Selected!...");
					alert.show();
				}

			}
			//done
			public ObservableList<Instructor> getInstructorInfo() {

				ObservableList<Instructor> instructors = FXCollections.observableArrayList();
				try {
					//sql connection 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					String sql = "select * from teacher";
					ResultSet rs = stmt.executeQuery(sql);
					//while there are values in the ResultSet 
					while (rs.next()) {
						instructors.add(//add new student to the ObservableList from our students table in the login database
								new Instructor(rs.getLong("id"), rs.getString("name"), rs.getString("date_of_birth"),rs.getString("gender"),rs.getString("college") ,
										rs.getString("phone"), rs.getString("address"), rs.getString("password"),rs.getString("degree"),rs.getString("email")));
						
					}
					con.close();

				} catch (Exception e) {
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.show();
				}
				return instructors;
			}
			//done
			private static void display(ResultSet myRs) throws SQLException {
				//while there are values in the result set according to the given ID number 
				if(myRs.next()) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Search Result");
					alert.setHeaderText("An Instructor has been Found!");
					alert.setContentText("Instructor ID: "+myRs.getLong("id") + "\nName: " 
					+ myRs.getString("name") + "\nDOB: " +myRs.getString("date_of_birth")
					+"\nGender: " +myRs.getString("gender")+ "\nCollege: " 
					+myRs.getString("college")+ "\nPhone: " + myRs.getString("phone")+ "\nAddress: " + myRs.getString("address")
					+ "\nPassword: " + myRs.getString("password")+"\nDegree: "+myRs.getString("degree")+"\nEmail: "+myRs.getString("email"));
					alert.show();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR!");
					alert.setHeaderText("No Instructor record has been found!");
					alert.setContentText("Make sure that you have typed the correct instructor id number.\nOr the record exists in the system.");//print the exception in an alert error
					alert.show();
				}

			}
			
			public static boolean isNumeric(final String str) {

		        // null or empty
		        if (str == null || str.length() == 0) {
		            return false;
		        }

		        return str.chars().allMatch(Character::isDigit);

		    }


	public static void main(String[] args) {
		
		Application.launch(args);

	}

}
