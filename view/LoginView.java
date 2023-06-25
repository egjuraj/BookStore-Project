package Week13;
import controller.UserController;
import model.User;
import model.Administrator;
import model.Librarian;
import model.Manager;
import java.awt.Color;
import java.io.File;
import java.text.*;
import javafx.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.User;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginView  {
	User user;
public Scene showView(Stage primaryStage) 
{   
	GridPane pane=new GridPane();
	pane.setHgap(10);
	pane.setVgap(10);
	pane.setPadding(new Insets(50,50,50,50));
	pane.setAlignment(Pos.CENTER_RIGHT);
	
	Label login=new Label("LogIn");
	Label username=new Label ("Username");
	Label password=new Label ("Password");
	Button loginb=new Button (" Log in");
	Button cancel=new Button(" Cancel");
	TextField usernamtf=new TextField();
	PasswordField  passtf=new PasswordField();
	login.setFont(Font.font("ALGERIAN",FontWeight.BOLD,FontPosture.ITALIC,40));
	login.setStyle( "-fx-text-fill:white;" );
	pane.add(login, 2, 0);
	
	username.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
	username.setStyle("-fx-text-fill:white;");
	pane.add(username, 1, 3);
	pane.add(usernamtf, 2, 3);
	
	password.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
	password.setStyle("-fx-text-fill:white;");
	pane.add(password, 1, 4);
     pane.add(passtf, 2, 4);
     HBox hbox=new HBox();
     hbox.setPadding(new Insets(5,5,5,5));
     hbox.setSpacing(10);
     hbox.getChildren().addAll(loginb,cancel);
     pane.add(hbox, 2, 5);
     usernamtf.setAlignment(Pos.BASELINE_RIGHT);
     passtf.setAlignment(Pos.BASELINE_RIGHT);
     cancel.setStyle("-fx-background-color: white");
     loginb.setStyle("-fx-background-color:white");
    Scene sc=new Scene(pane,700,700);
    primaryStage.setScene(sc);
    primaryStage.setTitle("Log In");
    primaryStage.show();
    /*
    pane.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/elisa.jpg'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 700 700");
*/
    pane.setStyle("-fx-background-color:   #92b7c7; " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 700 700");
    
	cancel.setOnAction(new EventHandler<ActionEvent>()  {
		public void handle (ActionEvent arg0) {
			System.exit(0);
		}
	});
    loginb.setOnAction(e->{
		if(usernamtf.getText().equals("librarian") && passtf.getText().equals("librari123")) {
			LibrarianView librari=new LibrarianView(user);
			Scene scene=librari.showView(primaryStage);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully logged in as a Librarian!");
			alert.show();
			primaryStage.setScene(scene);
		}
		else if(usernamtf.getText().equals("admin") && passtf.getText().equals("Admin123")) {
			AdministrationView admin=new AdministrationView(user);
			Scene scene=admin.showView(primaryStage);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully logged in as a Admin!");
			alert.show();
			primaryStage.setScene(scene);
		}
		else if(usernamtf.getText().equals("manager") && passtf.getText().equals("Manager123")) {
			ManagerView manager=new ManagerView(user);
			Scene scene=manager.showView(primaryStage);
            Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Successfully logged in as a manager!");
	        alert.show();
			primaryStage.setScene(scene);
		}
		else {
			Alert alerts=new Alert(AlertType.ERROR);
			alerts.setTitle("Error");
			alerts.setContentText("Please, enter the correct password and username!");    }
	
    });
    return sc;
}
}
