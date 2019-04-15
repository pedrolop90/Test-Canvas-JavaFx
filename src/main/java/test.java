import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Canvas canvas=new CanvasTest();
        StackPane panePrincipal=new StackPane();
        panePrincipal.getChildren().add(canvas);
        Scene scene=new Scene(panePrincipal,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }
}
