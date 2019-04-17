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
        for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
            Shape f=selectionModel.getSelectedItems().get(i);
            selectionModel.getSelectedItems().get(i).setW(x-f.getX());
            selectionModel.getSelectedItems().get(i).setH(y-f.getY());
        }
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
