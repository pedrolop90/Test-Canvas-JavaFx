package Figuras;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;

public class SelectionModel {

    private ObjectProperty<SelectionMode> selectionMode=new SimpleObjectProperty<>(SelectionMode.SINGLE);
    private List<Shape> selectedItems=new ArrayList<>();

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

    public List<Shape> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Shape> selectedItems) {
        this.selectedItems = selectedItems;
    }
}
