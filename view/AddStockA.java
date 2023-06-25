package Week13;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
import javafx.stage.Stage;
import model.Manager;
import model.TheDate;
import model.book;
import controller.ProductController;
import controller.PurchasesController;
import model.User;

public class AddStockA{
    User user;
    ProductController pc = new ProductController();;
    book books;

    ObservableList<book> book = FXCollections.observableArrayList(pc.getBooks());

	public AddStockA(User user) {
		this.user = user;
	}

	public Scene showView(Stage st) {

		BorderPane pane = new BorderPane();
		TextField ISBN = new TextField();
		ISBN.setPromptText("ISBN");

		TextField quantity = new TextField();
		quantity.setPromptText("Quantity");

		TableView table = new TableView();

		TableColumn isbn=new TableColumn("ISBN");
		isbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		isbn.setMinWidth(150);

		TableColumn name = new TableColumn("Book");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(150);

		TableColumn category=new TableColumn("Category");
	    category.setCellValueFactory(new PropertyValueFactory<>("category"));
	    category.setMinWidth(150);

		TableColumn supplier=new TableColumn("Supplier");
		supplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
		supplier.setMinWidth(150);

		TableColumn stock = new TableColumn("Stock");
		stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

		table.setItems(book);
		table.getColumns().addAll(isbn,name,category,supplier,stock);
		stock.setMinWidth(150);


	    table.setRowFactory(tv -> {
            TableRow<book> currRow = new TableRow<>();
            currRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! currRow.isEmpty()) ) {
                    books = currRow.getItem();
                    ISBN.setText(books.getISBN());
                }
            });
            return currRow;
        });


		HBox hb1 = new HBox();	
		hb1.setSpacing(10);
		hb1.setPadding(new Insets(20,20,20,20));
		hb1.setAlignment(Pos.CENTER);

		Button add = new Button("Add");
		add.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		add.setTextFill(Color.WHITE);
	    add.setStyle("-fx-background-color: linear-gradient(#FFE5CC , #FF9999)");


	    add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				boolean isValidbarcode = false;


				if(ISBN.getText().isEmpty()) {
					new Alert(AlertType.WARNING,"Please select a product from table!",ButtonType.OK).show();
				}else {
					isValidbarcode=true;
				}
				boolean isValidquantity=false;
				try {

					if(Integer.parseInt(quantity.getText()) <=0){
						quantity.clear();
						quantity.setPromptText("Enter a valid quantity");
				        quantity.setStyle("-fx-prompt-text-fill: red");
					}else {
					    isValidquantity=true;
					}
				}catch(NumberFormatException e){
					quantity.clear();
					quantity.setPromptText("Enter a valid quantity");
			        quantity.setStyle("-fx-prompt-text-fill: red");
				}

				if(isValidbarcode && isValidquantity) {

					int pos=pc.getPosition(books);
					PurchasesController pcr = new PurchasesController();
					pcr.addBook(pos,isbn.getText(), Integer.parseInt(quantity.getText()));
					(new AddStock(user)).showView(st);
				}

			}
		});

		Button back = new Button("Back");
		back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	    back.setTextFill(Color.WHITE);
	    back.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");

	    back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AdministrationView(user)).showView(st);

			}
		});

		hb1.getChildren().addAll(ISBN,quantity,add,back);

		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(10, 10, 10, 30));
		vb1.getChildren().addAll(table);

		pane.setTop(hb1);
	    pane.setCenter(vb1);
	    Scene sc = new Scene(pane,790,500);
	    st.setScene(sc);
	    st.setTitle("Quantity");
	    st.setResizable(false);
		return sc;

	}


}