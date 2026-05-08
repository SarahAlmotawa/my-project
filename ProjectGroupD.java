package projectgroupd;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;


public class ProjectGroupD extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        CostumerPage page = new CostumerPage();

        page.openPage();    
        EventPage event = new EventPage ();
        event.openPage();
    
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}