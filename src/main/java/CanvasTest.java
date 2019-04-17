import Figuras.Generico;
import Figuras.Shape;
import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CanvasTest extends Canvas {

    private ObjectProperty<Shape> figuraSeleccionada =new SimpleObjectProperty<>();
    private GraphicsContext context=getGraphicsContext2D();
    private SelectionHandler selectionHandler=new SelectionHandler();

    public CanvasTest(double width,double height){
        super();
        setWidth(width);
        setHeight(height);
        figuraSeleccionada.set(new Generico());
        init();
        render();
    }

    public CanvasTest(double width, double height,Shape accion){
        super();
        setWidth(width);
        setHeight(height);
        figuraSeleccionada.set(accion);
        init();
        render();
    }

    public void render(){
        context.setFill(Color.BLUE);
        figuraSeleccionada.get().draw(context);
    }

    public ObjectProperty<Shape> getFiguraSeleccionada(){
        return figuraSeleccionada;
    }
    private class SelectionHandler implements EventHandler<MouseEvent> {

        public DoubleProperty x = new SimpleDoubleProperty(-1);
        public DoubleProperty y = new SimpleDoubleProperty(-1);
        public DoubleProperty w = new SimpleDoubleProperty(-1);
        public DoubleProperty h = new SimpleDoubleProperty(-1);
        public DoubleProperty xi=new SimpleDoubleProperty(-1);
        public DoubleProperty yi=new SimpleDoubleProperty(-1);
        public BooleanProperty estadoFigura=new SimpleBooleanProperty(false);
        public ObjectProperty<Shape.TipoAccion> accionFigura=new SimpleObjectProperty<>();
        private double wMax=-1;
        private double hMax=-1;

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_MOVED) {
                handleMouseMoved(evt);
            }else if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }else if (evt.getEventType() == MouseEvent.MOUSE_RELEASED) {
                handleMouseReleased(evt);
            }else if (evt.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                handleMouseDragged(evt);
            }
        }

        public void handleMouseMoved(MouseEvent evt){
        }

        public void handleMouseDragged(MouseEvent evt){
            if(estadoFigura.get()) {
                switch (accionFigura.get()) {
                    case MOVE:
                        x.set(evt.getX() - wMax);
                        y.set(evt.getY() - hMax);
                        break;
                    case RESIZE_EXTREME:
                        w.set(evt.getX()-x.get());
                        h.set(evt.getY()-y.get());
                        break;
                    case RESIZE_CENTRO_X:
                        w.set(evt.getX()-x.get());
                        break;
                    case RESIZE_CENTRO_Y:
                        h.set(evt.getY()-y.get());
                        break;
                    case CREATE:
                        break;
                }
                xi.set(evt.getX());
                yi.set(evt.getY());
                render();
            }
        }
        public void handleMousePressed(MouseEvent evt){
            xi.set(evt.getX());
            yi.set(evt.getY());
            render();
            if (estadoFigura.get()) {
                switch (accionFigura.get()) {
                    case MOVE:
                            wMax = evt.getX() - x.get();
                            hMax = evt.getY() - y.get();
                        break;
                    case RESIZE_EXTREME:
                        break;
                    case RESIZE_CENTRO_X:
                        break;
                    case RESIZE_CENTRO_Y:
                        break;
                    case CREATE:
                        break;
                }
            }
        }

        public void handleMouseReleased(MouseEvent evt){
            if(estadoFigura.get()) {
                switch (accionFigura.get()) {
                    case MOVE:
                        break;
                    case RESIZE_EXTREME:
                        break;
                    case RESIZE_CENTRO_X:
                        break;
                    case RESIZE_CENTRO_Y:
                        break;
                    case CREATE:
                        break;
                }
                estadoFigura.set(false);
            }
            render();
        }

    }

    private void init(){
        setOnMousePressed(selectionHandler);
        setOnMouseReleased(selectionHandler);
        setOnMouseMoved(selectionHandler);
        setOnMouseDragged(selectionHandler);
        figuraSeleccionada.get().xProperty().bindBidirectional(selectionHandler.x);
        figuraSeleccionada.get().yProperty().bindBidirectional(selectionHandler.y);
        figuraSeleccionada.get().xiProperty().bindBidirectional(selectionHandler.xi);
        figuraSeleccionada.get().yiProperty().bindBidirectional(selectionHandler.yi);
        figuraSeleccionada.get().wProperty().bindBidirectional(selectionHandler.w);
        figuraSeleccionada.get().hProperty().bindBidirectional(selectionHandler.h);
        figuraSeleccionada.get().estadoFiguraProperty().bindBidirectional(selectionHandler.estadoFigura);
        figuraSeleccionada.get().accionFigura.bindBidirectional(selectionHandler.accionFigura);
    }

}
