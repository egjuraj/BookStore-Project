package Week13;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.BillController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Bill;
import model.User;
import model.book;
import controller.ProductController;

public class AddBillView {
User user;
 ArrayList<book>books;
	public AddBillView(User user) {
		this.user=user;
}
	public Scene showView(Stage primaryStage) {
		GridPane pane=new GridPane();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setHgap(10.0);
		pane.setVgap(10.0);
	Text t=new Text();
	DropShadow ds = new DropShadow();
	ds.setOffsetY(3.0f);
	t.setEffect(ds);
	t.setCache(true);
	t.setX(10.0f);
	t.setY(270.0f);
	t.setText("Create Bill");	
	t.setFont(Font.font("Arial", FontWeight.BOLD, 40));
	pane.add(t, 2, 10);
	Label name=new Label("Name of Book");
	TextField nametf=new TextField();
	pane.add(name, 1, 15);
	pane.add(nametf, 2, 15);
	Label category=new Label("Category");
	ComboBox<String> categoryf=new ComboBox<String>();
	categoryf.getItems().add("Comics");
	categoryf.getItems().add("Thriller");
	pane.add(category, 1, 16);
	pane.add(categoryf, 2, 16);
	Label author=new Label("Supplier");
	TextField authorf=new TextField();
	pane.add(author, 1, 17);
	pane.add(authorf, 2, 17);
	Label quantity=new Label("Quantity");
	TextField quantityf=new TextField();
	pane.add(quantity, 1, 18);
	pane.add(quantityf, 2, 18);
	Label price=new Label("Price");
	TextField pricetf=new TextField();
	pane.add(pricetf, 2, 19);
	pane.add(price, 1, 19);
	DatePicker dateP=new DatePicker();
	Label date=new Label("Date");
	pane.add(date, 1, 20);
	pane.add(dateP, 2, 20);
	Button cancel=new Button("Cancel");
	Button addBill=new Button("Add Bill");
	HBox hbox=new HBox();
	hbox.getChildren().addAll(addBill,cancel);
	hbox.setSpacing(30);
	pane.add(hbox, 2, 21);
		
			 
		            
			addBill.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					int r;
					String name=nametf.getText();
				    String supplier = authorf.getText();
			         r = Integer.parseInt(quantityf.getText());
			        LocalDate date = dateP.getValue();
			        double sellPrice = Double.parseDouble(pricetf.getText());
			        BillController bc = new BillController();
			        Bill bill = new Bill(name,supplier,date,sellPrice,r);
			        bc.writeBill(bill);
			        Alert addBill = new Alert(Alert.AlertType.CONFIRMATION);
			        addBill.setHeaderText("The bill was created successfully. You can always check it in the bill folder under the project folder.");
			        addBill.showAndWait();
			        LibrarianView cv=new LibrarianView(user);
			        primaryStage.setScene(cv.showView(primaryStage));
			                
			        }
				
			});
				 cancel.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							(new LibrarianView(user)).showView(primaryStage);	
						}
				   });
				  pane.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/bill1.png'); " +
				           "-fx-background-position: center center; " +
				           "-fx-background-repeat: stretch;" +
				           "-fx-background-size: 700 500");
            Scene sc=new Scene(pane,700,500);
			primaryStage.setScene(sc);
			primaryStage.show();


		 return sc ;
	}
			  }
		
