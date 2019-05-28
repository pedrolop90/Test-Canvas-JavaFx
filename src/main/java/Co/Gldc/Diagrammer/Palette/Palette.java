package Co.Gldc.Diagrammer.Palette;

import Co.Gldc.Diagrammer.Components.Component;
import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

public class Palette extends Control {

    public Palette(){
        getStyleClass().add("palette");
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new PaletteSkin(this);
    }

    public final ObservableList<Component> getComponents() {
        return components;
    }

    private ObservableList<Component> components= FXCollections.observableArrayList();

    public final void setComponents(ObservableList<Component> components) {
        this.components = components;
    }

    /**
     *
     * @return
     */
    public ObjectProperty<Shape> selectedProperty() {
        return this.selected;
    }

    private ObjectProperty<Shape> selected=new SimpleObjectProperty<>(this,"selectedPalette",null);

    public Shape getSelected() {
        return this.selectedProperty().get();
    }

    public void setSelected(Shape selected) {
        this.selectedProperty().set(selected);
    }
}
