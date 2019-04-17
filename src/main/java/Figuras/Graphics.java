package Figuras;

import Figuras.Acciones.Action;
import Figuras.Acciones.ActionHandler;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graphics extends Canvas {

    private List<Shape> figuras=new ArrayList<>();
    private SelectionModel selectionModel=new SelectionModel();
    private Map<Action, ActionHandler> actions=new TreeMap<>();
    private GraphicsContext context=this.getGraphicsContext2D();

    public Graphics(double width,double height){
        this.setWidth(width);
        this.setHeight(height);
        PressedHandler pressedHandler=new PressedHandler();
        ReleasedHandler releasedHandler=new ReleasedHandler();
        DraggedHandler draggedHandler=new DraggedHandler();
        setOnMousePressed(pressedHandler);
        setOnMouseReleased(releasedHandler);
        setOnMouseDragged(draggedHandler);
    }

    public void reDraw(){
        context.clearRect(0,0,getWidth(),getHeight());
        for (int i = 0; i < figuras.size() ; i++) {
            context.setFill(Color.AQUA);
            figuras.get(i).draw(context);
            if(figuras.get(i).selectedProperty().get()){
                figuras.get(i).figuraSeleccionada(context);
            }
        }
    }

    private class PressedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }
        }
        public void handleMousePressed(MouseEvent evt) {
            for (int i = 0; i < figuras.size(); i++) {
                if (evt.getX() >= figuras.get(i).getX() &&
                        evt.getX() <= figuras.get(i).getX()+figuras.get(i).getW() &&
                        evt.getY() >= figuras.get(i).getY() &&
                        evt.getY() <= figuras.get(i).getY()+figuras.get(i).getH()) {
                    selectionModel.getSelectedItems().add(figuras.get(i));
                    figuras.get(i).selectedProperty().set(true);
                    Action.SELECTION.getActionHandler().setSelectionModel(selectionModel);
                    actions.put(Action.SELECTION,Action.SELECTION.getActionHandler());
                    break;
                }
                if(figuras.get(i).selectedResize(evt.getX(),evt.getY())){
                    selectionModel.getSelectedItems().add(figuras.get(i));
                    figuras.get(i).selectedProperty().set(true);
                    Action.SELECTION.getActionHandler().setSelectionModel(selectionModel);
                    actions.put(Action.SELECTION,Action.SELECTION.getActionHandler());
                    Action.RESIZE.getActionHandler().setSelectionModel(selectionModel);
                    actions.put(Action.RESIZE,Action.RESIZE.getActionHandler());
                    break;
                }
            }
            reDraw();
        }
    }

    private class DraggedHandler implements EventHandler<MouseEvent> {

        private double deltaX=0;
        private double deltaY=0;

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                handleMouseDragged(evt);
            }
        }
        public void handleMouseDragged(MouseEvent evt) {
            if(selectionModel.getSelectedItems().size()>0){
                if(actions.containsKey(Action.SELECTION)){
                    if(actions.containsKey(Action.RESIZE)){
                        actions.get(Action.RESIZE).calcularCambio(evt.getX(),evt.getY(),0,0);
                    }else{
                       if(!actions.containsKey(Action.MOVE)){
                            Action.MOVE.getActionHandler().setSelectionModel(selectionModel);
                            actions.put(Action.MOVE,Action.MOVE.getActionHandler());
                           for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
                               deltaX=evt.getX()-selectionModel.getSelectedItems().get(i).getX();
                               deltaY=evt.getY()-selectionModel.getSelectedItems().get(i).getY();
                           }
                       }
                       actions.get(Action.MOVE).calcularCambio(evt.getX(),evt.getY(),deltaX,deltaY);
                    }
                }
                reDraw();
            }
        }
    }

    private class ReleasedHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_RELEASED) {
                handleMouseDragged(evt);
            }
        }
        public void handleMouseDragged(MouseEvent evt) {
            reDraw();
            selectionModel.getSelectedItems().forEach(shape -> {
                shape.selectedProperty().set(false);
            });
            selectionModel.getSelectedItems().clear();
            actions.clear();
        }
    }

    public void agregarFigura(Shape f){
        figuras.add(f);
        reDraw();
    }

}
