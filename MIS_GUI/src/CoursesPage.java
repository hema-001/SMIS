import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoursesPage extends Application {
	TableView<Course> Table;
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
				TableColumn<Course, Integer> idCol = new TableColumn("ID");
				idCol.setMinWidth(100);
				idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

				TableColumn<Course, String> nameCol = new TableColumn("NAME");
				nameCol.setMinWidth(100);
				nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

				TableColumn<Course, String> teacherCol = new TableColumn("TEACHER");
				teacherCol.setMinWidth(100);
				teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));

				TableColumn<Course, String> semesterCol = new TableColumn("SEMESTER");
				semesterCol.setMinWidth(100);
				semesterCol.setCellValueFactory(new PropertyValueFactory<>("semester"));

				TableColumn<Course, String> dayCol = new TableColumn("DAY");
				dayCol.setMinWidth(100);
				dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));
				
				TableColumn<Course, Integer> periodCol = new TableColumn("PERIOD");
				periodCol.setMinWidth(100);
				periodCol.setCellValueFactory(new PropertyValueFactory<>("period"));

				TableColumn<Course, String> creditCol = new TableColumn("CREDITS");
				creditCol.setMinWidth(100);
				creditCol.setCellValueFactory(new PropertyValueFactory<>("credits"));
				
				TableColumn<Course, String> roomCol = new TableColumn("ROOM");
				roomCol.setMinWidth(100);
				roomCol.setCellValueFactory(new PropertyValueFactory<>("room"));
				
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
				Label inslab = new Label("Course Info");
				Back.setOnAction(e -> {
					Window.setScene(scene);
					Window.setTitle("ZJNU Students IMS");
					Table.setItems(getCourseInfo());
				});
				Label insLid = new Label("ID:");
				TextField insTX_id = new TextField();
				insTX_id.setPrefWidth(100);
				Label insLname = new Label("NAME:");
				TextField insTX_name = new TextField();
				insTX_name.setPrefWidth(100);
				Label insLteacher = new Label("Teacher:");
				TextField insTX_teacher = new TextField();
				insTX_teacher.setPrefWidth(100);
				Label insLsemester = new Label("Semester:");
				TextField insTX_semester = new TextField();
				insTX_semester.setPrefWidth(100);
				Label insLday = new Label("Day:");
				TextField insTX_day = new TextField();
				insTX_day.setPrefWidth(100);
				Label insLperiod = new Label("Period:");
				TextField insTX_period = new TextField();
				insTX_period.setPrefWidth(100);
				Label insLcredit = new Label("Credits:");
				TextField insTX_credit = new TextField();
				insTX_credit.setPrefWidth(100);
				Label insLroom = new Label("Room:");
				TextField insTX_room = new TextField();
				insTX_room.setPrefWidth(100);

				VBox Linsbox = new VBox();
				Linsbox.setPadding(new Insets(10, 10, 10, 10));
				Linsbox.setSpacing(10);
				TextField instx = new TextField();
				//tx.setPrefWidth(500);
				//Label lb = new Label(
				//		"Please type the student info.");
				Linsbox.getChildren().addAll(insLid,insLname,insLteacher,insLsemester,insLday,insLperiod,insLcredit,insLroom);
				VBox insBox = new VBox();
				insBox.setPadding(new Insets(10, 10, 10, 10));
				insBox.getChildren().addAll(insTX_id,insTX_name, insTX_teacher, insTX_semester,insTX_day,insTX_period,insTX_credit,insTX_room);
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
					String[] arr = {insTX_id.getText(),insTX_name.getText(),insTX_teacher.getText(),insTX_semester.getText(),insTX_day.getText(),
							insTX_period.getText(),insTX_credit.getText(),insTX_room.getText()};
					if(insertRecord(arr)) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Insert Successful");
						alert.setHeaderText("Course has been successfully added to the system.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getCourseInfo());
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
					Course currstd = Table.getSelectionModel().getSelectedItem();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Warning!");
					alert.setHeaderText("Are you sure want to delete this record?");
					alert.setContentText("The deleted record will be removed completly from the system.");
					Optional<ButtonType> option = alert.showAndWait();
					if(option.get() == ButtonType.OK) {
						Table.getItems().remove(currstd);// take the highlighted record and send it to the method RemoveRecord()
						RemoveRecord(currstd);
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
				Label lteacher = new Label("Teacher:");
				TextField TX_teacher = new TextField();
				TX_teacher.setPrefWidth(100);
				Label lsemester = new Label("Semester:");
				TextField TX_semester = new TextField();
				TX_semester.setPrefWidth(100);
				Label lLday = new Label("Day:");
				TextField TX_day = new TextField();
				TX_day.setPrefWidth(100);
				Label lperiod = new Label("Period:");
				TextField TX_period = new TextField();
				TX_period.setPrefWidth(100);
				Label lcredit = new Label("Credits:");
				TextField TX_credit = new TextField();
				TX_credit.setPrefWidth(100);
				Label lroom = new Label("Room:");
				TextField TX_room = new TextField();
				TX_room.setPrefWidth(100);
				

				Button apply = new Button("Apply");
				apply.setOnAction(e -> {
					//String text = eTX.getText();// same technique used in insert before, split and send but this time to
												// UpdateRecord()
					String[] arr = {TX_id.getText(),TX_name.getText(),TX_teacher.getText(),TX_semester.getText(),TX_day.getText(),
							TX_period.getText(),TX_credit.getText(),TX_room.getText()};
					if(UpdateRecord(arr)==true) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Edit successful");
						alert.setHeaderText("Changes has been successfully applied.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getCourseInfo());
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
					Table.setItems(getCourseInfo());// and invoke the method getStudentInfo() to refresh the table with the new
														// changes
				});
				VBox TX_box = new VBox();
				TX_box.setPadding(new Insets(10, 10, 10, 10));
				TX_box.setSpacing(10);
				VBox Label_box = new VBox();
				Label_box.setPadding(new Insets(10, 10, 10, 10));
				Label_box.setSpacing(20);
				Label_box.getChildren().addAll(lname,lteacher,lsemester,lLday,lperiod,lcredit,lroom);
				TX_box.getChildren().addAll(TX_name,TX_teacher,TX_semester,TX_day,
						TX_period,TX_credit,TX_room);
				GridPane editbox = new GridPane();
				editbox.setPadding(new Insets(10, 10, 10, 10));
				editbox.add(Label_box, 0, 0);
				editbox.add(TX_box, 1, 0);
				editbox.add(apply, 0, 1);
				editbox.add(eBack, 1, 1);
				EditScene = new Scene(editbox);
				edit.setOnAction(e -> {
					
					Course course = Table.getSelectionModel().getSelectedItem();
					if (course == null) {// if edit button is pressed but no record selected, set error message
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("ERROR");
						alert.setHeaderText("No records selected...!");
						alert.show();

					} else {// else get the values of the record selected and show them in the text field
							// seperated by commas
						Window.setTitle("Edit");
						Window.setScene(EditScene);
						TX_id.setText(String.valueOf(course.getId()));
						TX_name.setText(course.getName());
						TX_teacher.setText(course.getTeacher());
						TX_semester.setText(course.getSemester());
						TX_day.setText(course.getDay());
						TX_period.setText(course.getPeriod());
						TX_credit.setText(course.getCredits());
						TX_room.setText(course.getRoom());
					}
				});// end of editScene

				// from here to line 198 is the queryScene
				Button query = new Button("Search");
				query.setPrefWidth(200);
				Button QBack = new Button("Back");
				Button QOK = new Button("OK");
				TextField Qtx = new TextField();
				Qtx.setPrefWidth(200);
				Label Qlb = new Label("Course ID number: ");
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
				Table.setItems(getCourseInfo());
				Table.getColumns().addAll(idCol, nameCol, teacherCol, dayCol, periodCol, creditCol, roomCol, semesterCol);
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
					PreparedStatement myStmt = myConn.prepareStatement("select * from courses where course_code = ?"); 
					
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
					String sql = "update courses set name = ?, teacher = ?, semester = ?, day = ?, period = ?, credits = ?, room = ? WHERE course_code = ?;";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(8, Long.valueOf(s[0]));
					pr.setString(1, s[1]); 
					pr.setString(2, s[2]);
					pr.setString(3, s[3]); 
					pr.setString(4, s[4]);
					pr.setString(5, s[5]);
					pr.setString(6, s[6]);
					pr.setString(7, s[7]);
					
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
					String sql = "insert into courses values(?,?,?,?,?,?,?,?)";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(1, Long.valueOf(s[0]));
					pr.setString(2, s[1]); 
					pr.setString(3, s[2]);
					pr.setString(4, s[3]); 
					pr.setString(5, s[4]);
					pr.setString(6, s[5]);
					pr.setString(7, s[6]);
					pr.setString(8, s[7]);
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
			public void RemoveRecord(Course s) {

				try {
					//sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					//sql query and preparedStatement 
					String sql = "delete from courses where course_code = ?";
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
			public ObservableList<Course> getCourseInfo() {

				ObservableList<Course> courses = FXCollections.observableArrayList();
				try {
					//sql connection 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					String sql = "select * from courses";
					ResultSet rs = stmt.executeQuery(sql);
					//while there are values in the ResultSet 
					while (rs.next()) {
						courses.add(//add new student to the ObservableList from our students table in the login database
								new Course(rs.getLong("course_code"), rs.getString("name"), rs.getString("teacher"),rs.getString("semester"),rs.getString("day") ,
										rs.getString("period"), rs.getString("credits"), rs.getString("room")));
						
					}
					con.close();

				} catch (Exception e) {
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.show();
				}
				return courses;
			}
			//done
			private static void display(ResultSet myRs) throws SQLException {
				//while there are values in the result set according to the given ID number 
				if(myRs.next()) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Search Result");
					alert.setHeaderText("A Course has been Found!");
					alert.setContentText("Course ID: "+myRs.getLong("course_code") + "\nName: " 
					+ myRs.getString("name") + "\nTeacher: " +myRs.getString("teacher")
					+"\nSemester: " +myRs.getString("semester")+ "\nDay: " 
					+myRs.getString("day")+ "\nPeriod: " + myRs.getString("period")+ "\nCredit: " + myRs.getString("credits")
					+ "\nRoom: " + myRs.getString("room"));
					alert.show();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR!");
					alert.setHeaderText("No Course record has been found!");
					alert.setContentText("Make sure that you have typed the correct course id number.\nOr the record exists in the system.");//print the exception in an alert error
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
