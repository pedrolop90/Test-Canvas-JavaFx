package Figuras.Acciones;

import Figuras.SelectionModel;

public class SelectionHanlder implements ActionHandler {

    private SelectionModel selectionModel;

    public SelectionHanlder(SelectionModel sm){
        this.selectionModel=sm;
    }

    @Override
    public void calcularCambio(double x, double y, double deltaX,double deltaY) {
        //TODO
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
