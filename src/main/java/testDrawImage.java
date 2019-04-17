import Figuras.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class testDrawImage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        List<Object> valores=new ArrayList<>();
        valores.add(0d);
        valores.add(0d);
        valores.add(800d);
        valores.add(400d);
        valores.add("2.jpg");
        //Generico f=new Generico(Generico.DRAWIMAGE,valores);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,false);
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}
