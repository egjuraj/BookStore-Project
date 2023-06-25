package Week13;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Category;
import model.book;
import controller.CategoryController;
import controller.ProductController;
import controller.SupplierController;
import controller.UserController;
import model.Supplier;
import model.User;
import model.CheckInput;

public class AddBook {
    User user;
    int view=0;
    String supplierName;
    String phone;
    String email;

    public AddBook(User user, String supplierName, String email, String phone) {
		   super();
		   this.user = user;
		   this.supplierName = supplierName;
		   this.email = email;
		   this.phone = phone;
		   view=1;
    }

	public AddBook(User user, String supplierName) { 
	         	this.user = user;
		        this.supplierName=supplierName;
	}
public AddBook(User user) {
	            this.user=user;
}

		public Scene showView(Stage primaryStage) {	
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10,0,10,0));
		gp.setAlignment(Pos.CENTER_LEFT);

		Text text = new Text("Products");
		text.setFont(Font.font("Amasis MT Pro Black", FontWeight.EXTRA_BOLD, 25));
	   	text.setStyle("-fx-text-fill: black;");

		Label supplier = new Label("Supplier");
		supplier.setFont(Font.font("Amasis MT Pro Black", FontWeight.EXTRA_BOLD, 15));
	   	supplier.setStyle("-fx-text-fill: black;");

		TextField supField = new TextField(supplierName);

		Label barcode = new Label("ISBN");
		barcode.setFont(Font.font("Amasis MT Pro Black", FontWeight.EXTRA_BOLD, 15));
	   	barcode.setStyle("-fx-text-fill: black;");
		TextField barField = new TextField();
		barField.setTooltip(new Tooltip("Barcode should be of the format ABXXXXXXXX"));

		Label name = new Label("Name");
		name.setFont(Font.font("Amasis MT Pro Black", FontWeight.EXTRA_BOLD, 15));
	   	name.setStyle("-fx-text-fill: black;");
		TextField nameField = new TextField();

		Label category = new Label("Category");	
		category.setFont(Font.font("Amasis MT Pro Black", FontWeight.EXTRA_BOLD, 15));
	   	category.setStyle("-fx-text-fill: black;");
		CategoryController cc = new CategoryController();
		ChoiceBox categoryField = new ChoiceBox(FXCollections.observableArrayList(cc.getCategories()));
		categoryField.getSelectionModel().select(0);

		gp.addColumn(0, supplier, barcode, name, category);
		gp.addColumn(1,supField, barField, nameField, categoryField);

        Button create = new Button("Create");
        create.setFont(Font.font("Arial", FontWeight.BOLD, 15));
      	create.setTextFill(Color.LIGHTCORAL);

      	create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			ProductController pc = new ProductController();
			SupplierController sc = new SupplierController();
				try {

				boolean isValidname=false;
				if(nameField.getText().isEmpty()){
					nameField.clear();
					nameField.setPromptText("Please enter the name");
					nameField.setStyle("-fx-prompt-text-fill: red");
				}else {
						isValidname=true;
				}


				boolean isValidBarcode=false;
				if((barField.getText()).isEmpty()) {
					barField.setPromptText("Please enter the barcode");
					barField.setStyle("-fx-prompt-text-fill: red");
				}else {
					if(barField.getText().toString().matches("^AB[0-9]{8}$")) {
						if(pc.useISBN(barField.getText().toString())) {
							barField.clear();
							barField.setPromptText("This barcode is already used");
							barField.setStyle("-fx-prompt-text-fill: red");
						}else {
							isValidBarcode=true;
						}
					}else {
						barField.clear();
						barField.setPromptText("Check the format");
						barField.setStyle("-fx-prompt-text-fill: red");
					}
				}


				if(isValidBarcode  && isValidname) {
					String ct = categoryField.getSelectionModel().getSelectedItem().toString();
					pc.addBooks(new book(barField.getText(), nameField.getText(),ct, supplierName));
				}
				}
				catch(Exception e) {
				}
				}
		});



        Button back = new Button("Cancel");
        back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        back.setTextFill(Color.WHITE);
      	back.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
        back.setOnAction(new EventHandler<ActionEvent>() {

   			@Override
   			public void handle(ActionEvent arg0) {
   				(new ViewSupplier(user)).showView(primaryStage);	
   			}
   		});
          Button exit=new Button("Exit");
          back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
          back.setTextFill(Color.WHITE);
   	      back.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
          exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				ManagerView  ab = new ManagerView(user);
				Scene sc = ab.showView(primaryStage);
				primaryStage.setScene(sc);
			
			}
		}); 
   	 
   	 
   	     HBox h = new HBox();
	    	h.setSpacing(10);
            h.getChildren().addAll(create,back,exit);

            gp.add(h, 1, 6);
            VBox vb= new VBox();

            vb.setSpacing(10);
            vb.getChildren().addAll(text,gp);
            vb.setAlignment(Pos.CENTER);
		    BorderPane root = new BorderPane();
		    root.setPadding(new Insets(100, 100, 100, 100));
		    root.setCenter(vb);
		    primaryStage.setTitle("Add Product");
            Scene scene = new Scene(root,500,400);
		    primaryStage.setScene(scene);
		    root.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/book.png'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 500 580") ;


		
		return scene;

		

	}
		
}


