package Week13;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HomeView lv= new HomeView();
		//ManagerView lv= new ManagerView();
		primaryStage.setScene(lv.showView(primaryStage));
		primaryStage.show();
		primaryStage.setResizable(false);
	}


	public static void main(String [] args){
		launch(args);
	}
}