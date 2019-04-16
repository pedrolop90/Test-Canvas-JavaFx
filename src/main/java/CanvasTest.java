import Figuras.Shape;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CanvasTest extends Canvas {
    private ObjectProperty<Shape> accionActual=new SimpleObjectProperty<Shape>();
    private List<Shape> figuras=new ArrayList<>();
    private Map<Integer,List<Shape>> colisiones=new TreeMap<>();
    private GraphicsContext context=getGraphicsContext2D();
    private SelectionHandler selectionHandler;
    private IntegerProperty contador=new SimpleIntegerProperty(0);

    public CanvasTest(double width, double height){
        super();
        this.setWidth(width);
        this.setHeight(height);
        selectionHandler= new SelectionHandler();
        this.setOnMousePressed(selectionHandler);
        this.setOnMouseMoved(selectionHandler);
        accionActual.addListener(observable -> {
            accionActual.get().setId(contador.get());
            colisiones.put(contador.get(),new ArrayList<Shape>());
            figuras.add(accionActual.getValue());
            accionActual.get().xProperty().bindBidirectional(selectionHandler.x);
            accionActual.get().yProperty().bindBidirectional(selectionHandler.y);
            accionActual.get().wProperty().bindBidirectional(selectionHandler.w);
            accionActual.get().hProperty().bindBidirectional(selectionHandler.h);
            selectionHandler.reiniciar();
            accionActual.get().reiniciar();
            contador.setValue(contador.get()+1);
        });
        render();
    }

    public void render(){
        context.setFill(Color.BLUE);
        if(accionActual.get()!=null) {
            accionActual.get().draw(context);
        }
    }

    public ObjectProperty<Shape> getAccionActual(){
        return accionActual;
    }

    private class SelectionHandler implements EventHandler<MouseEvent> {

        public DoubleProperty x = new SimpleDoubleProperty(-1);
        public DoubleProperty y = new SimpleDoubleProperty(-1);
        public DoubleProperty w = new SimpleDoubleProperty(-1);
        public DoubleProperty h = new SimpleDoubleProperty(-1);
        private boolean activo=false;

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_MOVED) {
                handleMouseMoved(evt);
            }
            else if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }
        }

        public void handleMouseMoved(MouseEvent evt){
            if(activo){
                w.set(evt.getX()- x.get());
                h.set(evt.getY()- y.get());
                render();
            }
        }
        public void handleMousePressed(MouseEvent evt){
            if(!activo){
                x.set(evt.getX());
                y.set(evt.getY());
                w.set(-1);
                h.set(-1);
                activo=true;
            }else if(activo&& w.get() !=-1&& h.get() !=-1){
                w.set(evt.getX()- x.get());
                h.set(evt.getY()- y.get());
                activo=false;
            }
            render();
        }

        public void reiniciar(){
            x.set(-1);
            y.set(-1);
            w.set(-1);
            h.set(-1);
            activo=false;
        }
    }

}
