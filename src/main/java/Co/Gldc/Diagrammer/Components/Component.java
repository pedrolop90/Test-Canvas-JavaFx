package Co.Gldc.Diagrammer.Components;

import Co.Gldc.Diagrammer.Shapes.Shape;
import com.sun.javafx.css.converters.SizeConverter;
import javafx.beans.property.DoubleProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableDoubleProperty;
import javafx.css.StyleableProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Component extends Control {

    public Component(){
        this(null,null,null);
    }

    public Component(String name,Image icon){
        this(name,null,icon);
    }

    public Component(String name, String category, Image icon){
        this.name=name;
        this.category=category;
        this.icon=icon;
        getStyleClass().add("component");
    }


    @Override
    public String getUserAgentStylesheet() {
        return Component.class.getResource("/Co/Gldc/Diagrammer/component.css").toExternalForm();
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return getClassCssMetaData();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new ComponentSkin(this);
    }

    /**
     *
     * @return
     */
    public final String getName() {
        return name;
    }

    private String name;

    public final void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public final String getCategory() {
        return category;
    }

    private String category;

    public final void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     */
    public final Image getIcon() {
        return icon;
    }

    private Image icon;

    public final void setIcon(Image icon) {
        this.icon = icon;
    }

    public abstract Shape createShapeDefault();

    /**
     *
     * @return
     */
    public final DoubleProperty sizeIconProperty() {
        if (sizeIcon == null) {
            sizeIcon = new StyleableDoubleProperty() {
                @Override
                public void invalidated() {
                    requestLayout();
                }

                @Override
                public Object getBean() {
                    return Component.this;
                }

                @Override
                public String getName() {
                    return "sizeIcon";
                }

                @Override
                public CssMetaData<Component, Number> getCssMetaData() {
                    return Component.StyleableProperties.SIZE_ICON;
                }
            };
        }
        return sizeIcon;
    }

    private DoubleProperty sizeIcon;

    public final double getsizeIcon() {
        return sizeIcon == null ? 100 : sizeIcon.get();
    }

    private static class StyleableProperties {
        private static final CssMetaData<Component, Number> SIZE_ICON = new CssMetaData<Component, Number>(
                "-fx-size-icon", SizeConverter.getInstance(),100d) {
            @Override
            public boolean isSettable(Component node) {
                return node.sizeIcon == null || !node.sizeIcon.isBound();
            }
            @Override
            public StyleableProperty<Number> getStyleableProperty(Component node) {
                return (StyleableProperty<Number>) node.sizeIconProperty();
            }
        };

        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(Control.getClassCssMetaData());
            styleables.add(SIZE_ICON);
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return Component.StyleableProperties.STYLEABLES;
    }


}
