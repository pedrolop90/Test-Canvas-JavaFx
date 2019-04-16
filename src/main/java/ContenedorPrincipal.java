import Figuras.Shape;
import javafx.collections.MapChangeListener;
import javafx.scene.control.SplitPane;

public class ContenedorPrincipal extends SplitPane {

    private CanvasTest canvas;
    private PaneControl control;

    public ContenedorPrincipal(double width,double height,Shape accion,boolean ponerPanelControl){
        canvas=new CanvasTest(width,height,accion);
        control=new PaneControl();
        if(ponerPanelControl){
            getItems().addAll(control,canvas);
        }else{
            getItems().addAll(canvas);
        }
    }
}
