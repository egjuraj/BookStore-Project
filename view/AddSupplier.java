package Week13;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import controller.SupplierController;
import model.User;
import model.CheckInput;

public class AddSupplier {
User user;
public AddSupplier(User user) {
	this.user=user;
}
public void showView(Stage primaryStage) {
	Text t=new Text();
	DropShadow ds = new DropShadow();
	ds.setOffsetY(3.0f);
	t.setEffect(ds);
	t.setCache(true);
	t.setX(10.0f);
	t.setY(270.0f);
	t.setText("Supplier");
	t.setFont(Font.font("Arial", FontWeight.BOLD, 30));
	StackPane spane=new StackPane();
	spane.getChildren().add(t);
	Label name=new Label("Name");
	Label email=new Label("E-mail");
	Label phonenr=new Label("Mobile");
	TextField nameF = new TextField();
	TextField emailF = new TextField();
	TextField phonenrF = new TextField();
	Tooltip tp = new Tooltip("Phone MUST be in the format 069XXXXXXX");
	phonenrF.setTooltip(tp);
	GridPane gp = new GridPane();
	gp.setHgap(10);
	gp.setVgap(10);
	gp.setPadding(new Insets(10,10,10,10));
	gp.addColumn(0,name, email, phonenr);
	gp.addColumn(1,nameF, emailF, phonenrF);
	Button next = new Button("Next");
	next.setFont(Font.font("Arial", FontWeight.BOLD, 15));
   	next.setTextFill(Color.SALMON);
	Button back = new Button("Cancel");
	back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    back.setTextFill(Color.WHITE);
   	back.setStyle("-fx-background-color: linear-gradient(#c50000 , #a60000)");

	HBox hb = new HBox();
	hb.setSpacing(10);
	hb.setAlignment(Pos.BASELINE_CENTER);
	hb.getChildren().addAll(next,back);
	gp.add(hb, 1, 4);
	gp.setHgap(10);
	gp.setVgap(10);
	gp.setPadding(new Insets(10,10,10,10));
	gp.setAlignment(Pos.CENTER);
	
	VBox vb = new VBox();
	vb.setAlignment(Pos.CENTER);
	vb.setId("vbox");
	vb.setSpacing(30);
	vb.getChildren().addAll(spane,gp);
	BorderPane bp = new BorderPane();
	  bp.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/supplier1.png'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 700 500");
	bp.setPadding(new Insets(100, 130, 100, 130));
	bp.setCenter(vb);
    Scene scene = new Scene(bp,500,500);
	primaryStage.setScene(scene);

	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
	
					(new ManagerView(user)).showView(primaryStage);
			}
		

	});

	next.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			SupplierController rws = new SupplierController();
			boolean validname=false;
			boolean validemail=false;
			boolean validphone=false;

			if((nameF.getText()).isEmpty()) {
				nameF.setPromptText("Please enter a supplier");
				nameF.setStyle("-fx-prompt-text-fill: blue");
			}else {
					if(rws.RegisterSupplier(nameF.getText().toString())) {
						nameF.clear();
						nameF.setPromptText("Username is used");
						nameF.setStyle("-fx-prompt-text-fill: red");
					}else {
						validname=true;
					}
			}

			if((emailF.getText()).isEmpty()) {
				emailF.setPromptText("Please enter E-mail");
				emailF.setStyle("-fx-prompt-text-fill: blue");
			}else {
				if(!(new CheckInput().checkEmail(emailF.getText().toString()))){
					emailF.clear();
					emailF.setPromptText("Something went wrong");
					emailF.setStyle("-fx-prompt-text-fill: blue");
				}else {
					validemail=true;
				}
			}
			if((phonenrF.getText()).isEmpty()) {
				phonenrF.setPromptText("Please enter mobile phone");
				phonenrF.setStyle("-fx-prompt-text-fill: blue");
			}else {
				if(new CheckInput().checkPhone(phonenrF.getText().toString())) {
					validphone = true;
				}else {
					phonenrF.clear();
					phonenrF.setPromptText("Check the format!");
					phonenrF.setStyle("-fx-prompt-text-fill: blue");
				}
			}
			if(validname  && validemail && validphone) {
				(new AddBook(user,nameF.getText(),emailF.getText(),phonenrF.getText())).showView(primaryStage);
			}
		}

	});

	
}

	
	
	
}

