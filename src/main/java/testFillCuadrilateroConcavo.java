import Figuras.Generico;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class testFillCuadrilateroConcavo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        int cont=0;
        List<List<Object>> valores=new ArrayList<>();
        valores.add(new ArrayList<Object>());
        valores.get(cont).add(20d);
        valores.get(cont).add(20d);
        valores.get(cont).add(100d);
        valores.get(cont).add(100d);
        valores.get(cont).add(0.6d);
        cont++;
        valores.add(new ArrayList<Object>());
        valores.get(cont).add(140d);
        valores.get(cont).add(20d);
        valores.get(cont).add(100d);
        valores.get(cont).add(100d);
        valores.get(cont).add(0.6d);
        List<Integer> figuras=new ArrayList<>();
        figuras.add(Generico.CUADRILATERO_CONCAVO);
        figuras.add(Generico.CUADRILATERO_CONCAVO);
        Generico f=new Generico(figuras,valores);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,f,false);
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}
