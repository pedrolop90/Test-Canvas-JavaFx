package Co.Gldc.Diagrammer.Toolbar;

import Co.Gldc.Diagrammer.Components.Component;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import java.util.List;

public class Toolbar extends Control {

    public Toolbar(){
        getStyleClass().add("toolbar");
    }

    @Override
    public String getUserAgentStylesheet() {
        return Component.class.getResource("/Co/Gldc/Diagrammer/toolbar.css").toExternalForm();
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return getClassCssMetaData();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ToolbarSkin(this);
    }


}
