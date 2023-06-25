package Week13;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddEmployee {
User user;
public AddEmployee(User user) {
	this.user=user;

}
public Scene showView(Stage primaryStage) {
	Button back=new Button("Back");
	Button addEmployee=new Button("Add Employee");
    GridPane pane=new GridPane();
	pane.setHgap(10);
	pane.setVgap(10);
	pane.setPadding(new Insets(50,50,50,50));
	pane.setAlignment(Pos.BASELINE_CENTER);
   
    HBox hbox=new HBox();
    hbox.setPadding(new Insets(5,5,5,5));
    hbox.setSpacing(10);
    hbox.getChildren().addAll(addEmployee,back);
    pane.add(hbox, 2, 5);
    
    
    addEmployee.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			RegisterView sv = new RegisterView(user);
				Scene sc = sv.showView(primaryStage);
				primaryStage.setScene(sc);
    		}
    		
    	 });
    
    
    back.setOnAction(new EventHandler<ActionEvent>()
    		{
    	
    @Override
    public void handle(ActionEvent event) {
    	AdministrationView sv = new AdministrationView(user);
		Scene sc = sv.showView(primaryStage);
		primaryStage.setScene(sc);
    	
    }
    		});
    
    Scene sc=new Scene(pane,300,300);
	primaryStage.setScene(sc);
	primaryStage.setTitle("Add Employee");
	primaryStage.show();
	
return sc;
}
}
