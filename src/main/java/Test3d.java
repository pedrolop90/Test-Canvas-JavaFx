import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class Test3d extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // crear un cubo 3D, anchura, altura y profundidad
        Box box = new Box(100, 100, 100);
        box.setLayoutX(0);
        box.setLayoutY(0);
        // crear una luz puntual
        PointLight light = new PointLight();
        light.setTranslateX(-350);
        light.setTranslateY(-180);
        light.setTranslateZ(-500);

        Group root = new Group(box, light);

        // crear la escena, true para activar el buffer de profindidad
        Scene scene = new Scene(root, 900, 600, true, SceneAntialiasing.BALANCED);

        // crear una camara en perspectiva
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene.getWidth() / -2.0);
        camera.setTranslateY((scene.getHeight() / -2.0) - 150);

        scene.setCamera(camera);
        stage.setTitle("JavaFX Graficos 3D");
        stage.setScene(scene);
        stage.show();
    }
}
