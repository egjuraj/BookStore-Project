package Week13;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Manager;
import model.book;
import controller.ProductController;
import model.User;

public class ViewStockA{
    User user;

	public ViewStockA(User user) {
		this.user = user;
	}

	public Scene showView(Stage primaryStage) {
	      HBox hb= new HBox();
	        hb.setAlignment(Pos.BOTTOM_CENTER);
	        Button cancel= new Button("Cancel");
	        cancel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		    cancel.setTextFill(Color.WHITE);
	        hb.getChildren().add(cancel);

		BorderPane pane = new BorderPane();

		ProductController pc=new ProductController();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String,Number> chart =  new BarChart<String,Number>(xAxis,yAxis);
        chart.setTitle("Low Stock Products");     
        chart.setLegendVisible(false);
        chart.setStyle("-fx-background-color: #FF9999");

        XYChart.Series y = new XYChart.Series();


        for(book b: pc.getBooks()) {
        	if(b.getStock()<=5) {
        	y.getData().add(new XYChart.Data(b.getTitle(),b.getStock()));
        	}
        }


  
        cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				    (new AdministrationView(user)).showView(primaryStage);		
			}

        });  


        pane.setCenter(chart);
        pane.setBottom(hb);
        pane.setStyle("-fx-background-color: #FFCCCC");
        Scene sc  = new Scene(pane,500,400);
        chart.getData().addAll(y);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Low Stocks");
        primaryStage.show();
		return sc;

	}

}