package Figuras.Acciones;

import Figuras.SelectionModel;
import Figuras.Shape;

public class ResizeHandler implements ActionHandler {

    private SelectionModel selectionModel;

    public ResizeHandler(SelectionModel sm){
        this.selectionModel=sm;
    }

    @Override
    public void calcularCambio(double x, double y, double deltaX,double deltaY) {
        //TODO
        Shape f=selectionModel.getSelectedItems().get(0);
        resizeEsquinaInferiorDerecha(x,y,deltaX,deltaY,f);

    }

    private void resizecentroDerecha(double x,double y,double deltaX,double deltaY,Shape f){

    }

    private void resizeEsquinaInferiorDerecha(double x,double y,double deltaX,double deltaY,Shape f){
        selectionModel.getSelectedItems().get(0).setW(x-f.getX());
        selectionModel.getSelectedItems().get(0).setH(y-f.getY());
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
