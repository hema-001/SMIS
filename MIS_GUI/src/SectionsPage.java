import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SectionsPage extends Application {
	
	GridPane sectionsPane = new GridPane();
	Button stdBtn = new Button("STUDENTS");
	Button courseBtn = new Button("COURSES");
	Button insBtn = new Button("INSTRUCTORS");
	Button noteBtn = new Button("NOTIFICATIONS");
	Button closeBtn = new Button("CLOSE");
	Button logoutBtn = new Button("LOGOUT");
	Stage Window = new Stage();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Window = primaryStage;
		
		courseBtn.setPrefSize(200, 50);
		stdBtn.setPrefSize(200, 50);
		insBtn.setPrefSize(200, 50);
		noteBtn.setPrefSize(200, 50);
		sectionsPane.setHgap(5);
		sectionsPane.setVgap(5);
		sectionsPane.setAlignment(Pos.CENTER);
		sectionsPane.setPadding(new Insets(10,10,10,10));
		sectionsPane.add(courseBtn, 0, 0);
		sectionsPane.add(stdBtn, 0, 1);
		sectionsPane.add(insBtn, 1, 0);
		sectionsPane.add(noteBtn, 1, 1);
		sectionsPane.add(closeBtn, 0, 2);
		sectionsPane.add(logoutBtn, 1, 2);
		
		Scene scene = new Scene(sectionsPane);
		Window.setScene(scene);
		Window.setTitle("ZJNU's Students MIS");
		Window.show();
		
		
		closeBtn.setOnAction(e ->{
			Window.close();
		});
		
		logoutBtn.setOnAction(e->{
			try {
				Window.close();
				MainPage mp = new MainPage();
				mp.start(mp.Window);
			}catch(Exception x) {
				System.out.println(x.getStackTrace());
			}
		});
		
		stdBtn.setOnAction(e->{
			try {
			StudentsPage sp = new StudentsPage();
			sp.start(sp.Window);
			Window.close();
			}catch(Exception x) {
				System.out.println(x.getMessage());
			}
		});
		
		courseBtn.setOnAction(e->{
			try {
			CoursesPage cp = new CoursesPage();
			cp.start(cp.Window);
			Window.close();
			}catch(Exception x) {
				System.out.println(x.getMessage());
			}
		});
		
		insBtn.setOnAction(e->{
			try {
			InstructorPage ip = new InstructorPage();
			ip.start(ip.Window);
			Window.close();
			}catch(Exception x) {
				System.out.println(x);
			}
		});
		
		noteBtn.setOnAction(e->{
			try {
				NotificationsPage np = new NotificationsPage();
				np.start(np.Window);
				Window.close();
			}catch(Exception x) {
				System.out.println(x.getMessage());
			}
		});


	}

	public static void main(String[] args) {
		
		Application.launch(args);

	}

}
