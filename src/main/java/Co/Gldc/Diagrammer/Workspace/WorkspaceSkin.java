package Co.Gldc.Diagrammer.Workspace;

import Co.Gldc.Diagrammer.Shapes.Graphics;
import javafx.scene.control.SkinBase;

class WorkspaceSkin extends SkinBase<Workspace> {

    private Graphics graphics;

    public WorkspaceSkin(Workspace control){
        super(control);
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        graphics=new Graphics(getSkinnable().getFiguras());
        graphics.setWidth(contentWidth);
        graphics.setHeight(contentHeight);
        graphics.reDraw();
        getChildren().setAll(graphics);
    }
}
