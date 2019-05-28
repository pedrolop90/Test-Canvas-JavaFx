package Co.Gldc.Diagrammer.Palette;

import Co.Gldc.Diagrammer.Components.Component;
import javafx.event.EventHandler;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class PaletteSkin extends SkinBase<Palette> {

    private Accordion accordion;

    public PaletteSkin(Palette control){
        super(control);
        accordion =new Accordion();
        getChildren().setAll(accordion);
        builview();
    }

    private void builview(){
        Map<String, List<Component>> mapa=new TreeMap<>();
        for (int i = 0; i < getSkinnable().getComponents().size(); i++) {
            if((getSkinnable().getComponents().get(i).getCategory()==null)||
            (getSkinnable().getComponents().get(i).getCategory()!=null&&
                    getSkinnable().getComponents().get(i).getCategory().isEmpty())){
                getSkinnable().getComponents().get(i).setCategory("General");
            }
            List<Component> prov=null;
            if(mapa.containsKey(getSkinnable().getComponents().get(i).getCategory())){
                prov=mapa.get(getSkinnable().getComponents().get(i).getCategory());
                prov.add(getSkinnable().getComponents().get(i));
                mapa.replace(getSkinnable().getComponents().get(i).getCategory(),prov);
            }else{
                prov=new ArrayList<>();
                prov.add(getSkinnable().getComponents().get(i));
                mapa.put(getSkinnable().getComponents().get(i).getCategory(),prov);
            }
        }
        int cantColumns=(int)(getSkinnable().getPrefWidth()/getSkinnable().getComponents().get(0).getsizeIcon());
        for (List<Component> values:mapa.values()){
            TitledPane tps=new TitledPane();
            tps.setText(values.get(0).getCategory());
            TilePane container=new TilePane();
             container.setPrefColumns(cantColumns);
            int cantRows=values.size()/cantColumns;
            container.setPrefRows(cantRows);
            for (Component component:values) {
                container.getChildren().add(component);
                component.setPrefWidth(getSkinnable().getPrefWidth()/(double)cantColumns);
                component.setOnMousePressed(new PressedHandler());
            }
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(container);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            tps.setContent(scrollPane);
            accordion.getPanes().add(tps);
        }
        if(accordion.getPanes().size()>0){
            accordion.setExpandedPane(accordion.getPanes().get(0));
        }
    }

    private class PressedHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent evt) {
            if (evt.getEventType() == MouseEvent.MOUSE_PRESSED) {
                handleMousePressed(evt);
            }
        }
        public void handleMousePressed(MouseEvent evt){
            if(evt.getSource() instanceof Component){
                getSkinnable().setSelected(((Component)evt.getSource()).createShapeDefault());
            }
        }
    }


    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);
        accordion.resizeRelocate(contentX,contentY,contentWidth,contentHeight);
    }
}
