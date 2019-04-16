import Figuras.Generico;
import Figuras.RectanguloEsquinasRedondeadas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testFillRectanguloEsquinasRedondeadas extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Generico f=new Generico(Generico.RECTANGULO_ESQUINAS_REDONDEADAS,20,20,200,200);
        RectanguloEsquinasRedondeadas aux=(RectanguloEsquinasRedondeadas)f.getFigura();
        aux.porcentajeProperty().set(10);
        ContenedorPrincipal contenedor=new ContenedorPrincipal(800,600,f,false);
        Scene scene=new Scene(contenedor,800,600);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }

}