package Co.Gldc.Diagrammer;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;

import java.util.List;

public class Diagrammer extends Control {


    public Diagrammer(){
        getStyleClass().add("diagramer");
    }


    @Override
    public String getUserAgentStylesheet() {
        return Diagrammer.class.getResource("diagrammer.css").toExternalForm();
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return getClassCssMetaData();
    }


    @Override
    protected Skin<?> createDefaultSkin() {
        return new DiagrammerSkin(this);
    }

}
