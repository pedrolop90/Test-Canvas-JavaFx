package Co.Gldc.Diagrammer.Shapes.Acciones;

import Co.Gldc.Diagrammer.Shapes.SelectionModel;

public class MoveHanlder implements ActionHandler {

    private SelectionModel selectionModel;

    public MoveHanlder(SelectionModel sm){
        this.selectionModel=sm;
    }

    @Override
    public void calcularCambio(double x, double y, double deltaX,double deltaY) {
        //TODO
        for (int i = 0; i < selectionModel.getSelectedItems().size(); i++) {
            selectionModel.getSelectedItems().get(i).setX(x-deltaX);
            selectionModel.getSelectedItems().get(i).setY(y-deltaY);
        }
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
