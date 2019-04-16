import Figuras.Shape;
import javafx.collections.MapChangeListener;
import javafx.scene.control.SplitPane;

public class ContenedorPrincipal extends SplitPane {

    private CanvasTest canvas;
    private PaneControl control;

    public ContenedorPrincipal(double width,double height){
        canvas=new CanvasTest(width,height);
        control=new PaneControl();
        getItems().addAll(control,canvas);
        control.getProperties().addListener((MapChangeListener<Object, Object>) change -> {
            if (change.getKey().equals("figura")) {
                canvas.getAccionActual().set((Shape)change.getValueAdded());
            }
        });
    }
}
