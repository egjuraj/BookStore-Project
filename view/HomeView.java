package Week13;

import java.awt.Color;
import java.awt.Image;
import java.beans.EventHandler;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.*;
import Week13.LoginView;

public class HomeView  {
	
	public Scene showView(Stage st) {
		Button exitbt=new Button("Exit");
		Font font2 = Font.font("Arial", FontWeight.BOLD, 20);
		exitbt.setFont(font2);
		exitbt.setStyle(  "-fx-background-color:white;");
		
		Button loginbt=new Button("Log in");
		Font font4 = Font.font("Arial", FontWeight.BOLD, 20);
		loginbt.setStyle("-fx-background-color:white;");
		loginbt.setFont(font4);
		HBox hbox= new HBox();
		hbox.getChildren().addAll(loginbt , exitbt);
		hbox.setPadding(new Insets(5, 5, 5, 5));
		hbox.setMargin(loginbt, new Insets(0, 30, 0, 20));
		
		hbox.setAlignment(Pos.CENTER);
		
		VBox vbox=new VBox();
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0f);

		Text t = new Text();
		t.setEffect(ds);
		t.setCache(true);
		t.setX(10.0f);
		t.setY(270.0f);
		t.setText("...The Written Word...");
		t.setFont(Font.font(null, FontWeight.BOLD, 50));
		t.setStyle( "-fx-text-fill:white;" );
		
		
		Text t1 = new Text();
		
		t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		t1.setText("A library is not a luxury but one of the necessities of life "); 
	     t1.setStyle("-fx-text-fill:white");
		vbox.getChildren().addAll(t,t1,hbox);
		vbox.setSpacing(45);
		vbox.setAlignment(Pos.CENTER);
		Scene sc=new Scene(vbox,700,500);

		st.setScene(sc);
		st.setTitle("ECOSMETICS");
	 /*   vbox.setStyle("-fx-background-image: url('file:///C:/Users/elisa/OneDrive/Desktop/elisa4.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");*/
	
		vbox.setStyle("-fx-background-color: 	#92b7c7; " +
		        "-fx-background-position: center center; " +
		        "-fx-background-repeat: stretch;" +
		        "-fx-background-size: 700 500");

	    st.setResizable(false);
	    st.show();
	    LoginView login=new LoginView();
	    loginbt.setOnAction(e->{
	    		try {
					st.setScene(login.showView(st));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	
	    });
	    
	    exitbt.setOnAction(e->{

    		System.exit(0);
	    
	    		}
	    );
	    		
	    		
	    		
	    
	    
		
		
		return sc;
	}

	
}
