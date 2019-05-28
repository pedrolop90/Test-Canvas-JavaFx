package Co.Gldc.Diagrammer.Components;

import Co.Gldc.Diagrammer.Shapes.Fill.RectanguloFill;
import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.scene.image.Image;

public class RectangleComponent extends Component{

    public RectangleComponent(){
        super("Rectangle","Basics",new Image(RectangleComponent.class.getResource("/Co/Gldc/Diagrammer/rectangle.png").toExternalForm()));
    }
    @Override
    public Shape createShapeDefault() {
        return new RectanguloFill();
    }
}
