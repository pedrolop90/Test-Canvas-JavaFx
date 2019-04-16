import Figuras.Generico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testFillCirculo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Generico f=new Generico(Generico.CIRCULO_FILL,20,20,200,200);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,f,false);
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}
