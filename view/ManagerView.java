package Week13;
import controller.LibrarianController;
import controller.ManagerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class ManagerView {
	User user;
	public ManagerView(User user) {
		this.user=user;
	}
	public Scene showView(Stage primaryStage) {
	
		
		
		BorderPane layout=new BorderPane();
		MenuBar menu=new MenuBar();
		Menu supplier=new Menu("Supplier");
		Menu category=new Menu("Category");
		Menu stock=new Menu("Stock");
		Menu show=new Menu("Show");
		MenuItem performance=new Menu("Performance");
		MenuItem logOut=new Menu("Log Out");
		MenuItem exit=new Menu("Exit");
		MenuItem addSupplier=new MenuItem("Add Supplier");
		MenuItem addStock=new MenuItem("Add Stock");
		MenuItem  addCat=new MenuItem("Add Category");
		MenuItem  viewSupplier=new MenuItem("View Supplier");
		MenuItem checkStock=new MenuItem("Check Stock");
		MenuItem addBook=new MenuItem("Add Book");
		menu.getMenus().addAll(supplier, stock, category,show );
		   supplier.getItems().addAll(addSupplier,viewSupplier);
		   stock.getItems().addAll(addStock,checkStock);
		   category.getItems().addAll(addCat,addBook);
	      show.getItems().addAll(performance,logOut,exit);
		
	
			addSupplier.setOnAction(new EventHandler<ActionEvent>() {
				@Override
	public void handle(ActionEvent event) {
					(new AddSupplier(user)).showView(primaryStage);
				}
	
	});
			viewSupplier.setOnAction(new EventHandler<ActionEvent>() {
				@Override
	public void handle(ActionEvent event) {
					(new ViewSupplier(user)).showView(primaryStage);
				}
	
	});
			
			addStock.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					(new AddStock(user)).showView(primaryStage);

				}
			});
			checkStock.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					(new ViewStock(user)).showView(primaryStage);

				}
			});
			
			addCat.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					(new AddCategory(user)).showView(primaryStage);

				}
			});
			performance.setOnAction(new EventHandler<ActionEvent>() {

				@Override
					public void handle(ActionEvent event) {
						ManagerController mc=new ManagerController();
						String r=mc.CheckLibrarianPerformance(new LibrarianController());
		                if (r=="OK") {
		                	Alert ok=new Alert(AlertType.WARNING);
		                	ok.setHeaderText("Good performance");
		                	ok.setContentText("The performace of the Librarian is satisfying. He has ordered more than 5 books today. You can always check his bills"
		                			+ " in the bills folder inside the project folder.");
		                	
		                }
						
						else if(r=="FAIL") {
						 	Alert warning=new Alert(AlertType.WARNING);
		                	warning.setHeaderText("Good performance");
		                	warning.setContentText("The performace of the Librarian is satisfying. He has ordered more than 5 books today. You can always check his bills"
		                			+ " in the bills folder inside the project folder.");
		                		}
						}
			});
			logOut.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					(new LoginView()).showView(primaryStage);

				}
			});
			exit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

		    		System.exit(0);
			    

				}
			});
			addBook.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					(new AddBook(user)).showView(primaryStage);

				}
			});
	/*		  menu.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/manager1.png'); " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;" +
			           "-fx-background-size: 700 500");*/
			  menu.setStyle("-fx-background-color: #92b7c7; " +
			           "-fx-background-position: center center; " +
			           "-fx-background-repeat: stretch;" +
			           "-fx-background-size: 700 500");
			Scene scene=new Scene(menu,700,500);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Manager of BookShop");
			return scene;
			

}
}
