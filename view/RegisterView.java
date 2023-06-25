package Week13;
import controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;
import javafx.scene.text.Text;
public class RegisterView {
User user;
public RegisterView(User user) {
	this.user=user;
}
public Scene showView(Stage stage){

	GridPane pane = new GridPane();
	pane.setHgap(10);
	pane.setVgap(10);
	pane.setPadding(new Insets(10, 10, 10, 10));
	pane.setAlignment(Pos.CENTER);
	Text t = new Text();
	DropShadow ds = new DropShadow();
	ds.setOffsetY(3.0f);
	StackPane sp=new StackPane();
	
	t.setEffect(ds);
	t.setCache(true);
	t.setX(10.0f);
	t.setY(270.0f);
	t.setText("USER REGISTRATION");
	t.setFont(Font.font(null, FontWeight.BOLD, 16));
	t.setStyle( "-fx-text-fill:black;" );
	sp.setAlignment(Pos.BASELINE_CENTER);
	sp.getChildren().add(t);
	pane.add(sp, 2, 0);
	Label firstNameL=new Label("First Name");
	firstNameL.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   firstNameL.setStyle("fx-text-fill:black");
   TextField firstNamef = new TextField();
	pane.add(firstNameL, 1, 1);
	pane.add(firstNamef, 2, 1);

	Label lastNameL= new Label("Last Name");
	lastNameL.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	lastNameL.setStyle("-fx-text-fill: black;");
	TextField lastNamef = new TextField();
	pane.add(lastNameL, 1, 2);
	pane.add(lastNamef, 2, 2);

	Label username= new Label("Username");
	username.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	username.setStyle("-fx-text-fill: black;");
	TextField usernameF = new TextField();
	usernameF.setTooltip(new Tooltip("Username can contain only lowercase letters"));
	pane.add(username, 1, 3);
	pane.add(usernameF, 2, 3);

	Label passwordLabel = new Label("Password");
	passwordLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	passwordLabel.setStyle("-fx-text-fill: black;");
	PasswordField passwordF= new PasswordField();
	pane.add(passwordLabel, 1, 4);
	pane.add(passwordF, 2, 4);

	Label verifyLabel = new Label("Verify Password");
	verifyLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	verifyLabel.setStyle("-fx-text-fill: black;");
	PasswordField verifyF= new PasswordField();
	pane.add(verifyLabel, 1, 5);
	pane.add(verifyF, 2, 5);


	Label PhoneLabel= new Label("Phone");
	PhoneLabel.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	PhoneLabel.setStyle("-fx-text-fill: black;");
	pane.add(PhoneLabel, 1, 6);
	TextField PhoneF= new TextField();
	pane.add(PhoneF, 2, 6);

	Label profession= new Label("Profession");
	profession.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 15));
   	profession.setStyle("-fx-text-fill: black;");
	pane.add(profession, 1, 7);
	ComboBox  professionDropDown= new ComboBox();
	professionDropDown.getItems().add("Librarian");
	professionDropDown.getItems().add("Manager");
	pane.add(professionDropDown, 2, 7);
	TextField nametf=new TextField();
	HBox hb= new HBox();
	Button add= new Button("Submit");
	Button back = new Button("Back");
	add.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    add.setTextFill(Color.DARKSALMON);
    back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    back.setTextFill(Color.WHITE);
    back.setStyle("-fx-background-color:#E9967A");
    hb.setMargin(back, new Insets(0,10,0,10));
    hb.getChildren().addAll(add, back);
	pane.add(hb, 2, 10);

	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			viewEmployee av=new viewEmployee(user);
			Scene sc = av.showView(stage);
			stage.setScene(sc);
		}

	});

	add.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
		    String firstname=firstNamef.getText();
		    String lastName= lastNamef.getText();
			String username= usernameF.getText();
			String password= passwordF.getText();
			String verifyPassword= verifyF.getText();
			String phone=PhoneF.getText();
			String profession = (String)professionDropDown.getValue();
			String salary ="";

			UserController uc= new UserController();
			if(username.matches("[_\\da-z]{3,}") && phone.matches("06[789]\\d{7}")  && (!firstname.isEmpty())&& (!lastName.isEmpty())&&   (!password.isEmpty()) && (!verifyPassword.isEmpty()) && (!phone.isEmpty()) && (!profession.isEmpty())) {
			boolean isRegistered = uc.signUp(firstname, lastName, username, password, verifyPassword, phone, profession, salary);
			if(isRegistered){
				Alert successAlert= new Alert(AlertType.CONFIRMATION);
				successAlert.setHeaderText("The user was registered successfully!");
				successAlert.showAndWait();
				AdministrationView lv= new AdministrationView(user);

				stage.setScene(lv.showView(stage));
				successAlert.close();
			}
			else if(!password.equals(verifyPassword)) {

				Alert errorAlert= new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("Password should match!!");
				errorAlert.show();
			}
			}
			else{
				Alert errorAlert= new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("The user was not registered successfully!Make sure that the fields are not empty and the credentials match the format!!");
				errorAlert.show();
			}
		}


	});
	 pane.setStyle("-fx-background-image: url('resources/adduser.jpg'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 480 500") ;

	Scene scene = new Scene(pane, 480,500);
	stage.setTitle("Add Employee");
	return scene;
}

}