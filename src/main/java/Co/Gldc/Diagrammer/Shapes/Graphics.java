package Co.Gldc.Diagrammer.Shapes;

import Co.Gldc.Diagrammer.Shapes.Acciones.Action;
import com.sun.istack.internal.NotNull;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Graphics extends Canvas {

    private ObservableList<Shape> figuras;
    private SelectionModel selectionModel=new SelectionModel();
    private SelectionAction selectionAction=new SelectionAction(selectionModel);
    private GraphicsContext context=this.getGraphicsContext2D();

    public Graphics(){
        this(null);
    }

    public Graphics(@NotNull ObservableList<Shape> figuras){
        PressedHandler pressedHandler=new PressedHandler();
        setOnMousePressed(pressedHandler);
        setOnMouseMoved(pressedHandler);
        setOnMouseReleased(new ReleasedHandler());
        setOnMouseDragged(new DraggedHandler(pressedHandler));
        if(figuras==null){
            figuras=FXCollections.observableArrayList();
        }
        this.figuras=figuras;
        this.figuras.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                reDraw();
            }
        });
    }

    public void reDraw(){
        context.setFill(Color.WHITE);
        context.fillRect(0,0,getWidth(),getHeight());
        for (int i = 0; i < figuras.size() ; i++) {
            figuras.get(i).draw(context);
            if(figuras.get(i).selectedProperty().get()){
                figuras.get(i).figuraSeleccionada(context);
            }
        }
    }

    private class PressedHandler implements EventHandler<MouseEvent> {

        private DoubleProperty initX=new SimpleDoubleProperty();
        private DoubleProperty initY=new SimpleDoubleProperty();

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }else if (evt.getEventType() == MouseEvent.MOUSE_MOVED) {
                handleMouseMoved(evt);
            }
        }
        public void handleMousePressed(MouseEvent evt) {
            selectionModel.getSelectedItems().clear();
            for (int i = 0; i < figuras.size(); i++) {
                int prov=-1;
                if (evt.getX() >= figuras.get(i).getX() &&
                        evt.getX() <= figuras.get(i).getX()+figuras.get(i).getW() &&
                        evt.getY() >= figuras.get(i).getY() &&
                        evt.getY() <= figuras.get(i).getY()+figuras.get(i).getH()) {
                    getScene().setCursor(Cursor.MOVE);
                    selectionModel.selected(figuras.get(i));
                    selectionAction.setContext(Action.SELECTION);
                    initX.set(evt.getX());
                    initY.set(evt.getY());
                    break;
                }else if((prov=figuras.get(i).selectedResize(evt.getX(),evt.getY(),getScene()))!=-1){
                    selectionModel.getEsquina()[prov]=true;
                    selectionModel.selected(figuras.get(i));
                    selectionAction.setContext(Action.RESIZE);
                    initX.set(evt.getX());
                    initY.set(evt.getY());
                    break;
                }
            }
            reDraw();
        }
        private void handleMouseMoved(MouseEvent evt){
            getScene().setCursor(Cursor.DEFAULT);
            if(selectionModel.getSelectedItems().size()>0){
                for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
                    if (evt.getX() >= selectionModel.getSelectedItems().get(i).getX() &&
                            evt.getX() <= selectionModel.getSelectedItems().get(i).getX()+
                                    selectionModel.getSelectedItems().get(i).getW() &&
                            evt.getY() >= selectionModel.getSelectedItems().get(i).getY() &&
                            evt.getY() <= selectionModel.getSelectedItems().get(i).getY()+
                                    selectionModel.getSelectedItems().get(i).getH()) {
                        getScene().setCursor(Cursor.MOVE);
                    }
                        selectionModel.getSelectedItems().get(i).selectedResize(evt.getX(), evt.getY(), getScene());
                }
            }
        }
    }

    private class DraggedHandler implements EventHandler<MouseEvent> {
        private double deltaX=0;
        private double deltaY=0;
        private PressedHandler pressedHandler;
        public DraggedHandler(PressedHandler pressedHandler){
            this.pressedHandler=pressedHandler;
            pressedHandler.initX.addListener(observable -> {
                for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
                    deltaX=pressedHandler.initX.get()-selectionModel.getSelectedItems().get(i).getX();
                }
            });
            pressedHandler.initY.addListener(observable -> {
                for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
                    deltaY=pressedHandler.initY.get()-selectionModel.getSelectedItems().get(i).getY();
                }
            });

        }

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                handleMouseDragged(evt);
            }
        }

        public void handleMouseDragged(MouseEvent evt) {
            if(selectionModel.getSelectedItems().size()>0){
                if(selectionAction.getContext()== Action.RESIZE){
                    selectionAction.getActions().get(Action.RESIZE).calcularCambio(evt.getX(),evt.getY(),0,0);
                    }else{
                    selectionAction.getActions().get(Action.MOVE).calcularCambio(evt.getX(),evt.getY(),deltaX,deltaY);
                }
                reDraw();
            }
        }
    }

    private class ReleasedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_RELEASED) {
                handleMouseReleased(evt);
            }
        }
        public void handleMouseReleased(MouseEvent evt) {
            reDraw();
            selectionModel.getSelectedItems().forEach(shape -> {
                shape.selectedProperty().set(false);
            });
            for (int i = 0; i < selectionModel.getEsquina().length; i++) {
                selectionModel.getEsquina()[i]=false;
            }
            //selectionAction.setContext(null);
        }
    }

    public ObservableList<Shape> getFiguras() {
        return figuras;
    }

    public void setFiguras(ObservableList<Shape> figuras) {
        this.figuras = figuras;
    }



}
