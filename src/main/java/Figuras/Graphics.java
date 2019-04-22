package Figuras;

import Figuras.Acciones.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private ObservableList<Shape> figuras= FXCollections.observableArrayList();
    private SelectionModel selectionModel=new SelectionModel();
    private SelectionAction selectionAction=new SelectionAction(selectionModel);
    private GraphicsContext context=this.getGraphicsContext2D();

    public Graphics(){
        this(800,600);
    }

    public Graphics(double width,double height){
        this.setWidth(width);
        this.setHeight(height);
        PressedHandler pressedHandler=new PressedHandler();
        setOnMousePressed(pressedHandler);
        setOnMouseReleased(new ReleasedHandler());
        setOnMouseDragged(new DraggedHandler(pressedHandler));
        figuras.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                reDraw();
            }
        });
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

        private DoubleProperty initX=new SimpleDoubleProperty();
        private DoubleProperty initY=new SimpleDoubleProperty();

        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }
        }
        public void handleMousePressed(MouseEvent evt) {
            for (int i = 0; i < figuras.size(); i++) {
                int prov=figuras.get(i).selectedResize(evt.getX(),evt.getY());
                if (evt.getX() >= figuras.get(i).getX() &&
                        evt.getX() <= figuras.get(i).getX()+figuras.get(i).getW() &&
                        evt.getY() >= figuras.get(i).getY() &&
                        evt.getY() <= figuras.get(i).getY()+figuras.get(i).getH()) {
                    selectionModel.selected(figuras.get(i));
                    selectionAction.setContext(Action.SELECTION);
                    initX.set(evt.getX());
                    initY.set(evt.getY());
                    break;
                }else if(prov!=-1){
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
                handleMouseDragged(evt);
            }
        }
        public void handleMouseDragged(MouseEvent evt) {
            reDraw();
            selectionModel.getSelectedItems().forEach(shape -> {
                shape.selectedProperty().set(false);
            });
            for (int i = 0; i < selectionModel.getEsquina().length; i++) {
                selectionModel.getEsquina()[i]=false;
            }
            selectionModel.getSelectedItems().clear();
            selectionAction.setContext(null);
        }
    }


    public ObservableList<Shape> getFiguras() {
        return figuras;
    }

    public void setFiguras(ObservableList<Shape> figuras) {
        this.figuras = figuras;
    }
}
