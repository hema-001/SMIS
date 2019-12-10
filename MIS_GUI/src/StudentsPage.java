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

public class StudentsPage extends Application {
	TableView<Student> Table;
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
				TableColumn<Student, Integer> idCol = new TableColumn("ID");
				idCol.setMinWidth(100);
				idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));

				TableColumn<Student, String> nameCol = new TableColumn("NAME");
				nameCol.setMinWidth(100);
				nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

				TableColumn<Student, String> dobCol = new TableColumn("DOB");
				dobCol.setMinWidth(100);
				dobCol.setCellValueFactory(new PropertyValueFactory<>("DOB"));

				TableColumn<Student, String> majorCol = new TableColumn("MAJOR");
				majorCol.setMinWidth(100);
				majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));

				TableColumn<Student, String> genderCol = new TableColumn("GENDER");
				genderCol.setMinWidth(100);
				genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
				
				TableColumn<Student, Integer> passCol = new TableColumn("PASSPORT");
				passCol.setMinWidth(100);
				passCol.setCellValueFactory(new PropertyValueFactory<>("passport"));

				TableColumn<Student, String> natCol = new TableColumn("NATIONALITY");
				natCol.setMinWidth(100);
				natCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));
				
				TableColumn<Student, String> collCol = new TableColumn("COLLEGE");
				collCol.setMinWidth(100);
				collCol.setCellValueFactory(new PropertyValueFactory<>("college"));
				
				TableColumn<Student, String> phCol = new TableColumn("PHONE");
				phCol.setMinWidth(100);
				phCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
				
				TableColumn<Student, String> addCol = new TableColumn("ADDRESS");
				addCol.setMinWidth(100);
				addCol.setCellValueFactory(new PropertyValueFactory<>("address"));
				
				TableColumn<Student, String> emailCol = new TableColumn("EMAIL");
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
				Label inslab = new Label("Student Info");
				Back.setOnAction(e -> {
					Window.setScene(scene);
					Window.setTitle("ZJNU Students IMS");
					Table.setItems(getStudentInfo());
				});
				Label insLid = new Label("ID:");
				TextField insTX_id = new TextField();
				insTX_id.setPrefWidth(100);
				Label insLname = new Label("NAME:");
				TextField insTX_name = new TextField();
				insTX_name.setPrefWidth(100);
				Label insLdob = new Label("Date-Of-Birth:");
				TextField insTX_dob = new TextField();
				insTX_dob.setPrefWidth(100);
				Label insLgender = new Label("GENDER:");
				TextField insTX_gender = new TextField();
				insTX_gender.setPrefWidth(100);
				Label insLpassport = new Label("PASSPORT:");
				TextField insTX_passport = new TextField();
				insTX_passport.setPrefWidth(100);
				Label insLnat = new Label("NATIONALITY:");
				TextField insTX_nat = new TextField();
				insTX_nat.setPrefWidth(100);
				Label insLcoll = new Label("COLLEGE:");
				TextField insTX_coll = new TextField();
				insTX_coll.setPrefWidth(100);
				Label insLmajor = new Label("MAJOR:");
				TextField insTX_major = new TextField();
				insTX_major.setPrefWidth(100);
				Label insLphone = new Label("PHONE:");
				TextField insTX_phone = new TextField();
				insTX_phone.setPrefWidth(100);
				Label insLadd = new Label("ADDRESS:");
				TextField insTX_add = new TextField();
				insTX_add.setPrefWidth(100);
				Label insLpass = new Label("PASSWORD:");
				TextField insTX_pass = new TextField();
				insTX_pass.setPrefWidth(100);
				Label insLemail = new Label("EMAIL:");
				TextField insTX_email = new TextField();
				insTX_email.setPrefWidth(100);

				VBox Linsbox = new VBox();
				Linsbox.setPadding(new Insets(10, 10, 10, 10));
				Linsbox.setSpacing(10);
				TextField instx = new TextField();
				//tx.setPrefWidth(500);
				//Label lb = new Label(
				//		"Please type the student info.");
				Linsbox.getChildren().addAll(insLid,insLname,insLdob,insLgender,insLpassport,insLnat,insLcoll,insLmajor,insLphone,insLadd,insLpass,insLemail);
				VBox insBox = new VBox();
				insBox.setPadding(new Insets(10, 10, 10, 10));
				insBox.getChildren().addAll(insTX_id,insTX_name, insTX_dob, insTX_gender,insTX_passport,insTX_nat,insTX_coll,insTX_major,insTX_phone,insTX_add,insTX_pass,insTX_email);
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
					String[] arr = {insTX_id.getText(),insTX_name.getText(),insTX_dob.getText(),insTX_gender.getText(),insTX_passport.getText(),
							insTX_nat.getText(),insTX_coll.getText(),insTX_major.getText(),insTX_phone.getText(),insTX_add.getText(),insTX_pass.getText(),insTX_email.getText()};
					if(insertRecord(arr)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Insert Successful");
						alert.setHeaderText("Student has been successfully added to the system.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getStudentInfo());
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
					Student currstd = Table.getSelectionModel().getSelectedItem();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Warning!");
					alert.setHeaderText("Are you sure want to delete this record?");
					alert.setContentText("The deleted record will be removed completly from the system.");
					Optional<ButtonType> option = alert.showAndWait();
					if(option.get()==ButtonType.OK) {
					Table.getItems().remove(currstd);// take the highlighted record and send it to the method RemoveRecord()
					RemoveRecord(currstd);
					}else {
						alert.close();
					}
				});
				// from here to line 170 is the editScene
				// following is some declarations and initializations
				Button edit = new Button("Edit");
				edit.setPrefWidth(200);
				
				TextField eTX_id = new TextField();
				eTX_id.setPrefWidth(100);
				Label Lname = new Label("NAME:");
				TextField eTX_name = new TextField();
				eTX_name.setPrefWidth(100);
				Label Ldob = new Label("Date-Of-Birth:");
				TextField eTX_dob = new TextField();
				eTX_dob.setPrefWidth(100);
				Label Lgender = new Label("GENDER:");
				TextField eTX_gender = new TextField();
				eTX_gender.setPrefWidth(100);
				Label Lpassport = new Label("PASSPORT:");
				TextField eTX_passport = new TextField();
				eTX_passport.setPrefWidth(100);
				Label Lnat = new Label("NATIONALITY:");
				TextField eTX_nat = new TextField();
				eTX_nat.setPrefWidth(100);
				Label Lcoll = new Label("COLLEGE:");
				TextField eTX_coll = new TextField();
				eTX_coll.setPrefWidth(100);
				Label Lmajor = new Label("MAJOR:");
				TextField eTX_major = new TextField();
				eTX_major.setPrefWidth(100);
				Label Lphone = new Label("PHONE:");
				TextField eTX_phone = new TextField();
				eTX_phone.setPrefWidth(100);
				Label Ladd = new Label("ADDRESS:");
				TextField eTX_add = new TextField();
				eTX_add.setPrefWidth(100);
				Label Lpass = new Label("PASSWORD:");
				TextField eTX_pass = new TextField();
				eTX_pass.setPrefWidth(100);
				Label Lemail = new Label("EMAIL:");
				TextField eTX_email = new TextField();
				eTX_email.setPrefWidth(100);
				

				Button apply = new Button("Apply");
				apply.setOnAction(e -> {
					//String text = eTX.getText();// same technique used in insert before, split and send but this time to
												// UpdateRecord()
					String[] arr = {eTX_id.getText(),eTX_name.getText(),eTX_dob.getText(),eTX_gender.getText(),eTX_passport.getText(),
							eTX_nat.getText(),eTX_coll.getText(),eTX_major.getText(),eTX_phone.getText(),eTX_add.getText(),eTX_pass.getText(),eTX_email.getText()};
					if(UpdateRecord(arr)==true) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Edit successful");
						alert.setHeaderText("Changes has been successfully applied.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getStudentInfo());
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
					Table.setItems(getStudentInfo());// and invoke the method getStudentInfo() to refresh the table with the new
														// changes
				});
				VBox TX_box = new VBox();
				TX_box.setPadding(new Insets(10, 10, 10, 10));
				TX_box.setSpacing(10);
				VBox Label_box = new VBox();
				Label_box.setPadding(new Insets(10, 10, 10, 10));
				Label_box.setSpacing(20);
				Label_box.getChildren().addAll(Lname,Ldob,Lgender,Lpassport,Lnat,Lcoll,Lmajor,Lphone,Ladd,Lpass,Lemail);
				TX_box.getChildren().addAll(eTX_name,eTX_dob,eTX_gender,eTX_passport,
						eTX_nat,eTX_coll,eTX_major,eTX_phone,eTX_add,eTX_pass,eTX_email);
				GridPane editbox = new GridPane();
				editbox.setPadding(new Insets(10, 10, 10, 10));
				editbox.add(Label_box, 0, 0);
				editbox.add(TX_box, 1, 0);
				editbox.add(apply, 0, 1);
				editbox.add(eBack, 1, 1);
				EditScene = new Scene(editbox);
				edit.setOnAction(e -> {
					
					Student std = Table.getSelectionModel().getSelectedItem();
					if (std == null) {// if edit button is pressed but no record selected, set error message
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("ERROR");
						alert.setHeaderText("No records selected...!");
						alert.show();

					} else {// else get the values of the record selected and show them in the text field
							// seperated by commas
						Window.setTitle("Edit");
						Window.setScene(EditScene);
						eTX_id.setText(String.valueOf(std.getID()));
						eTX_name.setText(std.getName());
						eTX_dob.setText(std.getDOB());
						eTX_gender.setText(std.getGender());
						eTX_passport.setText(std.getPassport());
						eTX_nat.setText(std.getNationality());
						eTX_coll.setText(std.getCollege());
						eTX_major.setText(std.getMajor());
						eTX_phone.setText(std.getPhone());
						eTX_add.setText(std.getAddress());
						eTX_pass.setText(std.getPassword());
						eTX_email.setText(std.getEmail());
					}
				});// end of editScene

				// from here to line 198 is the queryScene
				Button query = new Button("Search");
				query.setPrefWidth(200);
				Button QBack = new Button("Back");
				Button QOK = new Button("OK");
				TextField Qtx = new TextField();
				Qtx.setPrefWidth(200);
				Label Qlb = new Label("Student's ID number: ");
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
				
				Hbox.getChildren().addAll(insert, delete, edit, query,backToSecbtn);

				// the TableView initializations
				VBox Vbox = new VBox();
				Table = new TableView<>();
				Table.setItems(getStudentInfo());
				Table.getColumns().addAll(idCol, nameCol, dobCol, genderCol, passCol, natCol, collCol, majorCol, phCol, addCol, emailCol);
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
					PreparedStatement myStmt = myConn.prepareStatement("select * from student where ID = ?"); 
					
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
					String sql = "update student set name = ?, date_of_birth = ?, gender = ?, passport = ?, nationality = ?, college = ?, major = ?, phone = ?, address = ?, password = ?, email = ? WHERE id = ?;";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(12, Long.valueOf(s[0]));
					pr.setString(1, s[1]); 
					pr.setString(2, s[2]);
					pr.setString(3, s[3]); 
					pr.setString(4, s[4]);
					pr.setString(5, s[5]);
					pr.setString(6, s[6]);
					pr.setString(7, s[7]);
					pr.setString(8, s[8]);
					pr.setString(9, s[9]);
					pr.setString(10, s[10]);
					pr.setString(11, s[11]);
					
					
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
					String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
					pr.setString(11, s[10]);
					pr.setString(12, s[11]);
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
			public void RemoveRecord(Student s) {

				try {
					//sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					//sql query and preparedStatement 
					String sql = "delete from student where id = ?";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(1, s.getID());//replace the placeholder with the values we've got from the selectionModel
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
			public ObservableList<Student> getStudentInfo() {

				ObservableList<Student> Students = FXCollections.observableArrayList();
				try {
					//sql connection 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					String sql = "select * from student";
					ResultSet rs = stmt.executeQuery(sql);
					//while there are values in the ResultSet 
					while (rs.next()) {
						Students.add(//add new student to the ObservableList from our students table in the login database
								new Student(rs.getLong("id"), rs.getString("name"), rs.getString("date_of_birth"),rs.getString("gender"),rs.getString("passport") ,
										rs.getString("nationality"), rs.getString("college"), rs.getString("major"),rs.getString("phone"),rs.getString("address"),rs.getString("password"),rs.getString("email")));
						
					}
					con.close();

				} catch (Exception e) {
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.show();
				}
				return Students;
			}
			//done
			private static void display(ResultSet myRs) throws SQLException {
				//while there are values in the result set according to the given ID number 
				if(myRs.next()) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Search Result");
					alert.setHeaderText("A student has been Found!");
					alert.setContentText("Student ID: "+myRs.getLong("ID") + "\nName: " 
					+ myRs.getString("name") + "\nDOB: " +myRs.getString("date_of_birth")
					+"\nGender: " +myRs.getString("gender")+ "\nPassport NO: " 
					+myRs.getString("passport")+ "\nNationality: " + myRs.getString("nationality")+ "\nCollege: " + myRs.getString("college")
					+ "\nMajor: " + myRs.getString("major")+ "\nPhone: " + myRs.getString("phone")+ "\nAddress: "+ myRs.getString("address")
					+ "\nPassword: " + myRs.getString("password")+"\nEmail: "+myRs.getString("email"));
					alert.show();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR!");
					alert.setHeaderText("No Student record has been found!");
					alert.setContentText("Make sure that you have typed the correct id number(i.e. 20xxxxxxxxxx) 12 digits number.\nOr the record exists in the system.");//print the exception in an alert error
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
