package Co.Gldc.Diagrammer.Toolbar;

import javafx.scene.control.SkinBase;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

class ToolbarSkin extends SkinBase<Toolbar> {

    private HBox container;

    public ToolbarSkin(Toolbar control){
        super(control);
        container=new HBox();
        getChildren().setAll(container);
        buildView();
    }

    private void buildView(){

    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        container.resizeRelocate(contentX,contentY,contentWidth,contentHeight);
    }
}
