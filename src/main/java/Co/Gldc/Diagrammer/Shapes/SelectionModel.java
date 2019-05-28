package Co.Gldc.Diagrammer.Shapes;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SelectionModel {

    private ObjectProperty<SelectionMode> selectionMode=new SimpleObjectProperty<>(SelectionMode.SINGLE);
    private ObservableList<Shape> selectedItems= FXCollections.observableArrayList();
    private boolean[] esquina=new boolean[8];


    public SelectionModel(){

    }

    public SelectionMode getSelectionMode() {
        return selectionMode.get();
    }

    public ObjectProperty<SelectionMode> selectionModeProperty() {
        return selectionMode;
    }

    public void setSelectionMode(SelectionMode selectionMode) {
        this.selectionMode.set(selectionMode);
    }

    public ObservableList<Shape> getSelectedItems() {
        return selectedItems;
    }

    public void selected(Shape s){
        selectedItems.add(s);
        s.setSelected(true);
    }

    public boolean[] getEsquina() {
        return esquina;
    }

    public void setEsquina(boolean[] esquina) {
        this.esquina = esquina;
    }
}
