package Week13;

import java.util.ArrayList;

import controller.ProductController;
import controller.SupplierController;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
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
import model.book;
import model.Supplier;
import model.User;

public class ViewSupplier {
    User currentUser;
	private Supplier cp;
	ObservableList<book> books;
	int level=0;


	public ViewSupplier(User currentUser) {
		this.currentUser = currentUser;
	}

	public Scene showView(Stage st) {

		SupplierController sc =new SupplierController();
		ObservableList<Supplier> suppliers = FXCollections.observableArrayList(sc.getSuppliers());

		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(30,30,30,30));

		Label supplier = new Label("Suppliers");
		supplier.setAlignment(Pos.CENTER);
		supplier.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 30));
	   	supplier.setStyle("-fx-text-fill: salmon;");

        TableView table = new TableView();

		TableColumn name=new TableColumn("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(90);

		TableColumn email=new TableColumn("Email");
	    email.setCellValueFactory(new PropertyValueFactory<>("email"));
	    email.setMinWidth(150);

		TableColumn phone=new TableColumn("Mobile");
		phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		phone.setMinWidth(90);

		table.setItems(suppliers);
		table.setEditable(true);
		table.getColumns().addAll(name,email,phone);


		table.setRowFactory(tv -> {
            TableRow<Supplier> chosenRow = new TableRow<>();
            chosenRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!chosenRow.isEmpty()) ) {
                    Supplier sup = chosenRow.getItem();
                       Click(st,sup);
                }
            });
            return chosenRow;
        });

		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(50,50,50,50));
		hb.setSpacing(10);
	
		
        Button back=new Button("Back");
		Button add = new Button("Add");
		add.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		add.setTextFill(Color.WHITE);
	    add.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");

	    add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				(new AddSupplier(currentUser)).showView(st);

			}
		});

		Button delete = new Button("Delete");
		delete.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	    delete.setTextFill(Color.WHITE);
	    delete.setStyle("-fx-background-color: linear-gradient(#c50000 , #a60000)");

	    delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				SupplierController sc = new SupplierController();
				ProductController pc = new ProductController();
				if(table.getSelectionModel().getSelectedItems().isEmpty()) {
					new Alert(AlertType.ERROR,"Please select a supplier!!").show();;

				}else {
					Supplier sup = (Supplier)table.getSelectionModel().getSelectedItem();
					ArrayList<book> p = pc.getBooks();
					for(int i=0;i<p.size();i++) {
						if( (p.get(i).getSupplier()).equals(sup.getName()))
							pc.deleteBooks(p.get(i));
					}
					int position = sc.getPosition(sup);
					sc.deleteSupplier(position);
					(new ViewSupplier(currentUser)).showView(st);
				}}
		});

	    back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				    (new ManagerView(currentUser)).showView(st);
			}
		});
		  
		hb.getChildren().addAll(add,delete,back);
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setSpacing(10);
		vb.getChildren().addAll(supplier,table,hb);
		  vb.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/view.png'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");
		Scene scene=new Scene(vb,450,450);
		st.setScene(scene);
		st.setTitle("View Supplier");
		return scene;
	}
	
    void Click(Stage St, Supplier supplier) {
		this.cp=supplier;
		ProductController pc = new ProductController();
		ArrayList<book> book = new ArrayList<book>();
		for(book i: pc.getBooks()) {
			if(i.getSupplier().equals(supplier.getName())){
				book.add(i);	}	}
		books = FXCollections.observableArrayList(book);
		level=1;
		showView(St);

	}

}