import Figuras.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class testFillSemiCirculo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        int cont=0;
        List<List<Object>> valores=new ArrayList<>();
        valores.add(new ArrayList<>());
        valores.get(cont).add(20d);
        valores.get(cont).add(20d);
        valores.get(cont).add(100d);
        valores.get(cont).add(100d);
        valores.get(cont).add(190d);
        valores.get(cont).add(60d);
        valores.get(cont).add(ArcType.OPEN);
        cont++;
        valores.add(new ArrayList<>());
        valores.get(cont).add(140d);
        valores.get(cont).add(20d);
        valores.get(cont).add(100d);
        valores.get(cont).add(100d);
        valores.get(cont).add(190d);
        valores.get(cont).add(100d);
        valores.get(cont).add(ArcType.ROUND);
        cont++;
        valores.add(new ArrayList<>());
        valores.get(cont).add(260d);
        valores.get(cont).add(20d);
        valores.get(cont).add(100d);
        valores.get(cont).add(100d);
        valores.get(cont).add(190d);
        valores.get(cont).add(60d);
        valores.get(cont).add(ArcType.CHORD);
        cont++;
        List<Integer> figuras=new ArrayList<>();
        //figuras.add(Generico.SEMI_CIRCULO_FILL);
        //figuras.add(Generico.SEMI_CIRCULO_FILL);
        //figuras.add(Generico.SEMI_CIRCULO_FILL);
        //Generico f=new Generico(figuras,valores);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,false);
        contenedor.agregarFigura(ContenedorPrincipal.figuraPredeterminada.SEMICIRCULO_FILL,valores.get(0));
        contenedor.agregarFigura(ContenedorPrincipal.figuraPredeterminada.SEMICIRCULO_FILL,valores.get(1));
        contenedor.agregarFigura(ContenedorPrincipal.figuraPredeterminada.SEMICIRCULO_FILL,valores.get(2));
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}