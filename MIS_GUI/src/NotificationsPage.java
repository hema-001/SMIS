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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotificationsPage extends Application {
	TableView<Notification> Table;
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
				TableColumn<Notification, Integer> idCol = new TableColumn("ID");
				idCol.setMinWidth(100);
				idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

				TableColumn<Notification, String> titleCol = new TableColumn("TITLE");
				titleCol.setMinWidth(100);
				titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

				TableColumn<Notification, String> contentCol = new TableColumn("CONTENT");
				contentCol.setMinWidth(100);
				contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));

				TableColumn<Notification, String> dateCol = new TableColumn("ISSUE DATE");
				dateCol.setMinWidth(100);
				dateCol.setCellValueFactory(new PropertyValueFactory<>("issue_date"));

				TableColumn<Notification, String> authorCol = new TableColumn("AUTHOR");
				authorCol.setMinWidth(100);
				authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
								
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
					Table.setItems(getNoteInfo());
				});
				Label insLid = new Label("ID:");
				TextField insTX_id = new TextField();
				insTX_id.setPrefWidth(100);
				Label insLtitle = new Label("Title:");
				TextField insTX_title = new TextField();
				insTX_title.setPrefWidth(200);
				Label insLcontent = new Label("Content:");
				TextArea insTX_content = new TextArea();
				insTX_content.setPrefSize(500, 500);
				insTX_content.setWrapText(true);
				Label insLauthor = new Label("Author:");
				TextField insTX_author = new TextField();
				insTX_author.setPrefWidth(150);
				
				HBox Linsbox = new HBox();
				Linsbox.setPadding(new Insets(10, 10, 10, 10));
				Linsbox.setSpacing(10);
				TextField instx = new TextField();
				HBox btns = new HBox();
				btns.setPadding(new Insets(10,10,10,10));
				btns.setSpacing(10);
				btns.getChildren().addAll(Back,enter);
				Linsbox.getChildren().addAll(insLtitle,insTX_title,insLauthor,insTX_author);
				VBox insBox = new VBox();
				insBox.setPadding(new Insets(10, 10, 10, 10));
				insBox.getChildren().addAll(insTX_content);
				GridPane insgp = new GridPane();
				insgp.add(Linsbox, 0, 0);
				insgp.add(insBox, 0, 1);
				insgp.add(btns, 0, 2);
				InsertScene = new Scene(insgp);
				insert.setOnAction(e -> {
					insTX_title.setText("");
					insTX_content.setText("");
					insTX_author.setText("");
					Window.setTitle("Insert");
					Window.setScene(InsertScene);// if the button insert is pressed change the scene to the insertScene
				});
				enter.setOnAction(e -> {
					String[] arr = {insTX_title.getText(),insTX_content.getText(),insTX_author.getText()};
					if(insertRecord(arr)) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Insert Successful");
						alert.setHeaderText("Note has been successfully issued.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getNoteInfo());
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
					Notification note = Table.getSelectionModel().getSelectedItem();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Warning!");
					alert.setHeaderText("Are you sure want to delete this record?");
					alert.setContentText("The deleted record will be removed completly from the system.");
					Optional<ButtonType> option = alert.showAndWait();
					if(option.get() == ButtonType.OK) {
						Table.getItems().remove(note);// take the highlighted record and send it to the method RemoveRecord()
						RemoveRecord(note);
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
				Label ltitle = new Label("Title:");
				TextField TX_title = new TextField();
				TX_title.setPrefWidth(200);
				Label lcontent = new Label("Content:");
				TextArea TX_content = new TextArea();
				TX_content.setPrefSize(500, 500);
				TX_content.setWrapText(true);
				Label lauthor = new Label("Author:");
				TextField TX_author = new TextField();
				TX_author.setPrefWidth(150);
				
				Button apply = new Button("Apply");
				apply.setOnAction(e -> {
					//String text = eTX.getText();// same technique used in insert before, split and send but this time to
												// UpdateRecord()
					String[] arr = {TX_id.getText(),TX_title.getText(),TX_content.getText(),TX_author.getText()};
					if(UpdateRecord(arr)==true) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Edit successful");
						alert.setHeaderText("Changes has been successfully applied.");
						alert.show();
						Window.setTitle("ZJNU Students IMS");
						Window.setScene(scene);
						Table.setItems(getNoteInfo());
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
					Table.setItems(getNoteInfo());// and invoke the method getStudentInfo() to refresh the table with the new
														// changes
				});
				VBox TX_box = new VBox();
				TX_box.setPadding(new Insets(10, 10, 10, 10));
				TX_box.setSpacing(10);
				HBox Label_box = new HBox();
				Label_box.setPadding(new Insets(10, 10, 10, 10));
				Label_box.setSpacing(20);
				Label_box.getChildren().addAll(ltitle,TX_title,lauthor,TX_author);
				TX_box.getChildren().addAll(TX_content);
				HBox editBtns = new HBox();
				editBtns.setPadding(new Insets(10,10,10,10));
				editBtns.setSpacing(10);
				editBtns.getChildren().addAll(eBack,apply);
				GridPane editbox = new GridPane();
				editbox.setPadding(new Insets(10, 10, 10, 10));
				editbox.add(Label_box, 0, 0);
				editbox.add(TX_box, 0, 1);
				editbox.add(editBtns, 0, 2);
				EditScene = new Scene(editbox);
				edit.setOnAction(e -> {
					
					Notification note = Table.getSelectionModel().getSelectedItem();
					if (note == null) {// if edit button is pressed but no record selected, set error message
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("ERROR");
						alert.setHeaderText("No records selected...!");
						alert.show();

					} else {// else get the values of the record selected and show them in the text field
							// seperated by commas
						Window.setTitle("Edit");
						Window.setScene(EditScene);
						TX_id.setText(String.valueOf(note.getId()));
						TX_title.setText(note.getTitle());
						TX_content.setText(note.getContent());
						TX_author.setText(note.getAuthor());
					}
				});// end of editScene

				// from here to line 198 is the queryScene
				Button query = new Button("Search");
				query.setPrefWidth(200);
				Button QBack = new Button("Back");
				Button QOK = new Button("OK");
				TextField Qtx = new TextField();
				Qtx.setPrefWidth(200);
				Label Qlb = new Label("Note ID number: ");
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
					selectRecord(Integer.valueOf(Qtx.getText()));
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
				Table.setItems(getNoteInfo());
				Table.getColumns().addAll(idCol, titleCol, contentCol, authorCol, dateCol);
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
			private static void selectRecord(int i) {

				try {
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");//to create sql connection
					//sql preparedStatement with sql query where '?' is the placeholder 
					PreparedStatement myStmt = myConn.prepareStatement("select * from notifications where id = ?"); 
					
					myStmt.setInt(1, i);// this is going to replace the placeholder which is '?'																	

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
					String sql = "update notifications set title = ?, content = ?, author = ? WHERE id = ?;";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setLong(4, Integer.valueOf(s[0]));
					pr.setString(1, s[1]); 
					pr.setString(2, s[2]);
					pr.setString(3, s[3]);
					
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
					String sql = "insert into notifications(title,content,author) values(?,?,?);";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setString(1, s[0]); 
					pr.setString(2, s[1]);
					pr.setString(3, s[2]);
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
			public void RemoveRecord(Notification s) {

				try {
					//sql connection
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					//sql query and preparedStatement 
					String sql = "delete from notifications where id = ?";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setInt(1, s.getId());//replace the placeholder with the values we've got from the selectionModel
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
			public ObservableList<Notification> getNoteInfo() {

				ObservableList<Notification> note = FXCollections.observableArrayList();
				try {
					//sql connection 
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "124536");
					Statement stmt = con.createStatement();
					String sql = "select * from notifications";
					ResultSet rs = stmt.executeQuery(sql);
					//while there are values in the ResultSet 
					while (rs.next()) {
						String content = "";
						if(rs.getString("content").length()>50) {
							content = rs.getString("content").substring(0, 50).concat("...");
						}else {
							content = rs.getString("content");
						}
						note.add(//add new student to the ObservableList from our students table in the login database
								new Notification(rs.getInt("id"), rs.getString("title"), content,rs.getDate("issue_date"),rs.getString("author")));
						
					}
					con.close();

				} catch (Exception e) {
					System.out.println(e);
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(e.getMessage());
					alert.show();
				}
				return note;
			}
			//done
			private static void display(ResultSet myRs) throws SQLException {
				//while there are values in the result set according to the given ID number 
				if(myRs.next()) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Search Result");
					alert.setHeaderText("A Course has been Found!");
					alert.setContentText("Note ID: "+myRs.getLong("id") + "\nTitle: " 
					+ myRs.getString("title") + "\nContent: " +myRs.getString("content").substring(0, 50).concat("...")
					+"\nIssue Date: " +myRs.getDate("issue_date")+ "\nAuthor: " 
					+myRs.getString("author"));
					alert.show();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR!");
					alert.setHeaderText("No Notification record has been found!");
					alert.setContentText("Make sure that you have typed the correct Notification id number.\nOr the record exists in the system.");//print the exception in an alert error
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
