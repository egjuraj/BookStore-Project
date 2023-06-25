package Week13;

import controller.LibrarianController;
import controller.ManagerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.User;

public class AdministrationView {
	User user;
	public AdministrationView(User user) {
		this.user=user;
	}
	public Scene showView(Stage primaryStage) {
		BorderPane layout=new BorderPane();
		MenuBar menu=new MenuBar();
		Menu supplier=new Menu("Supplier");
		Menu category=new Menu("Category");
		Menu stock=new Menu("Stock");
		Menu show=new Menu("Show");
		Menu employee=new Menu("Employee");
		MenuItem addEmployee=new MenuItem("Add Employee");
		MenuItem viewEmployee=new MenuItem("View Employee");
		MenuItem performance=new Menu("Performance");
		MenuItem logOut=new Menu("Log Out");
		MenuItem exit=new Menu("Exit");
		MenuItem addSupplier=new MenuItem("Add Supplier");
		MenuItem addStock=new MenuItem("Add Stock");
		MenuItem  addCat=new MenuItem("Add Category");
		MenuItem  viewSupplier=new MenuItem("View Supplier");
		MenuItem checkStock=new MenuItem("Check Stock");
		MenuItem addBook=new MenuItem("Add Book");
		menu.getMenus().addAll(employee,supplier, stock, category,show );
		   supplier.getItems().addAll(addSupplier,viewSupplier);
		   stock.getItems().addAll(addStock,checkStock);
		   category.getItems().addAll(addCat,addBook);
	      show.getItems().addAll(performance,logOut,exit);
	      employee.getItems().addAll(addEmployee,viewEmployee);
	  	addSupplier.setOnAction(new EventHandler<ActionEvent>() {
			@Override
public void handle(ActionEvent event) {
				(new AddSupplierA(user)).showView(primaryStage);
			}

});
		viewSupplier.setOnAction(new EventHandler<ActionEvent>() {
			@Override
public void handle(ActionEvent event) {
				(new ViewSupplierA(user)).showView(primaryStage);
			}

});
		
		addStock.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddStockA(user)).showView(primaryStage);

			}
		});
		checkStock.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new ViewStockA(user)).showView(primaryStage);

			}
		});
		
		addCat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddCategoryA(user)).showView(primaryStage);

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

				(new AddBookA(user)).showView(primaryStage);

			}
		});
		addEmployee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				(new AddEmployee(user)).showView(primaryStage);
			}
		});
		viewEmployee.setOnAction(new EventHandler<ActionEvent>()
				
				{
			@Override
			public void handle(ActionEvent event) {
				viewEmployee view=new viewEmployee(user);
				Scene scene=view.showView(primaryStage);
				primaryStage.setScene(scene);
			}
				}
				
				);
		
		
		Scene scene=new Scene(menu,700,500);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Manager of BookShop");
		return scene;
		
			
		

	}

}
