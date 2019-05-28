package Co.Gldc.Diagrammer.Workspace;

import Co.Gldc.Diagrammer.Components.Component;

import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import java.util.List;

public class Workspace extends Control {

    public Workspace(){
        getStyleClass().add("workspace");
    }


    @Override
    public String getUserAgentStylesheet() {
        return Component.class.getResource("/Co/Gldc/Diagrammer/workspace.css").toExternalForm();
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return getClassCssMetaData();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new WorkspaceSkin(this);
    }

    public ObservableList<Shape> getFiguras() {
        return figuras;
    }

    private ObservableList<Shape> figuras= FXCollections.observableArrayList();

    public void setFiguras(ObservableList<Shape> figuras) {
        this.figuras = figuras;
    }


}
