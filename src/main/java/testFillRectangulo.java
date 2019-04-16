import Figuras.Generico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class testFillRectangulo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        List<Object> valores=new ArrayList<>();
        valores.add(20d);
        valores.add(20d);
        valores.add(200d);
        valores.add(200d);
        Generico f=new Generico(Generico.RECTANGULO_FILL,valores);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,f,false);
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}
