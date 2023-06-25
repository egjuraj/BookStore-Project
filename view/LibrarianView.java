package Week13;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
public class LibrarianView {
	User users;
	public LibrarianView(User users) {
		this.users=users;
	}

	public Scene showView(Stage primaryStage) {
		Text t=new Text();
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0f);
		t.setY(270.0f);
		t.setText("You are login as Librarian!");
		StackPane pane=new StackPane();
		t.setFont(Font.font(null, FontWeight.BOLD,30));
		t.setFill(Color.ALICEBLUE);
		pane.getChildren().add(t);
		BorderPane layout=new BorderPane();
		MenuBar  mbr=new MenuBar();
		Menu    show=new Menu("Show");
		MenuItem  addBill=new MenuItem("Add Bill");
        MenuItem   help=new MenuItem("Help");
        MenuItem  logOut=new MenuItem("Log Out");
        layout.setCenter(mbr);
        mbr.setUseSystemMenuBar(true);
        mbr.getMenus().add(show);
       show.getItems().addAll(addBill,help,logOut);
 VBox vbox=new VBox(layout,pane);
 vbox.setSpacing(200);
 vbox.setStyle("-fx-background-color: #92b7c7; " +
	        "-fx-background-position: center center; " +
	        "-fx-background-repeat: stretch;" +
	        "-fx-background-size: 700 500");

     Scene scene=new Scene(vbox,700,500);
	primaryStage.setScene(scene);
	primaryStage.setResizable(false);
	primaryStage.show();

	

	addBill.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			AddBillView ab = new AddBillView(users);
			Scene sc = ab.showView(primaryStage);
			primaryStage.setScene(sc);
		}

	});
	
	
	help.setOnAction(new EventHandler<ActionEvent>()
			{
		@Override
		public void handle(ActionEvent event) {
			Alert al= new Alert(AlertType.INFORMATION, "If you have any problem , you may reach us at : 069-34-56-766 ");
			al.show() ;
		}
		
			});
	logOut.setOnAction(new EventHandler<ActionEvent>() {
	@Override	
		public void handle(ActionEvent event) {
			LoginView lv=new LoginView();
			Scene sc = lv.showView(primaryStage);
			primaryStage.setScene(sc);
		}
	});
return scene;
	}

}
