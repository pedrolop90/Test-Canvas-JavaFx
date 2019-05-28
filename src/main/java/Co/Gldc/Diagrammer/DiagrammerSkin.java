package Co.Gldc.Diagrammer;

import Co.Gldc.Diagrammer.Components.CircleComponent;
import Co.Gldc.Diagrammer.Components.RectangleComponent;
import Co.Gldc.Diagrammer.Components.RectangleCurveComponent;
import Co.Gldc.Diagrammer.Components.TriangleComponent;
import Co.Gldc.Diagrammer.Palette.Palette;
import Co.Gldc.Diagrammer.Toolbar.Toolbar;
import Co.Gldc.Diagrammer.Workspace.Workspace;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Pane;

class DiagrammerSkin extends SkinBase<Diagrammer> {

    private Pane container;
    private Palette palette;
    private Workspace workspace;
    private Toolbar toolbar;

    public DiagrammerSkin(Diagrammer control){
        super(control);
        container=new Pane();
        workspace=new Workspace();
        palette=new Palette();
        toolbar=new Toolbar();
        palette.selectedProperty().addListener(observable -> workspace.getFiguras().add(palette.getSelected()));
        getChildren().setAll(container);
        buildView();
    }

    private void buildView(){
        palette.getComponents().add(new CircleComponent());
        palette.getComponents().add(new TriangleComponent());
        palette.getComponents().add(new RectangleComponent());
        palette.getComponents().add(new RectangleCurveComponent());
    }


    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        container.resizeRelocate(contentX,contentY,contentWidth,contentHeight);
        container.getChildren().setAll(palette,workspace,toolbar);
        palette.setPrefWidth(contentWidth*0.2);
        palette.setPrefHeight(contentHeight);
        toolbar.setPrefWidth(contentWidth*0.8-10);
        toolbar.setPrefHeight(contentHeight*0.05);
        toolbar.setLayoutX(contentWidth*0.2+5);
        toolbar.setLayoutY(5);
        workspace.setPrefWidth(toolbar.getPrefWidth());
        workspace.setPrefHeight(contentHeight-toolbar.getPrefHeight()-10);
        workspace.setLayoutX(palette.getPrefWidth()+5);
        workspace.setLayoutY(toolbar.getPrefHeight()+5);

    }
}
