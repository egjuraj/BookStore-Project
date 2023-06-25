package Week13;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import controller.CategoryController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Category;
import model.User;

public class AddCategory {
User user;
public AddCategory(User user) {
	this.user=user;
}
public Scene showView(Stage primaryStage) {
	GridPane pane=new GridPane();
	pane.setHgap(10);
	pane.setVgap(10);
	pane.setAlignment(Pos.BASELINE_LEFT);
	Label category = new Label("New Category");
	Button create=new Button("Create");
	Button cancel=new Button("Cancel");
	TextField categorytf=new TextField();
	pane.add(category, 1, 1);
	pane.add(categorytf, 2, 1);
	create.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent event) {
			CategoryController cc = new CategoryController();
		    cc.addCategory(new Category(categorytf.getText()));
		    categorytf.clear();
			Alert al= new Alert(AlertType.INFORMATION, "The New Category has been added to your store! ");
			al.show() ;
	
		}
	}	);
	
	cancel.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			(new ManagerView(user)).showView(primaryStage);
		}
		});

		HBox hbox=new HBox();
		hbox.getChildren().addAll(create,cancel);
		hbox.setSpacing(10);
		pane.add(hbox, 2, 2);
		
	
			
		Scene scene = new Scene(pane,450,300);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		

		primaryStage.setTitle("Add New Category");
		primaryStage.show();
	
			
			
	return scene;
}

}
