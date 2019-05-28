package Co.Gldc.Diagrammer.Components;

import javafx.geometry.Pos;
import javafx.scene.control.SkinBase;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


class ComponentSkin extends SkinBase<Component> {

    private StackPane container;

    public ComponentSkin(Component control){
        super(control);
        container=new StackPane();
        ImageView containerImage =new ImageView(control.getIcon());
        containerImage.setPreserveRatio(false);
        containerImage.setSmooth(true);
        containerImage.setFitWidth(control.getsizeIcon());
        containerImage.setFitHeight(control.getsizeIcon());
        container.getChildren().addAll(containerImage);
        StackPane.setAlignment(containerImage, Pos.CENTER);
        getChildren().setAll(container);
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        container.resizeRelocate(contentX,contentY,contentWidth,contentHeight);
    }
}
