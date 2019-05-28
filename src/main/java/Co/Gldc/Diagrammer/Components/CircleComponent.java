package Co.Gldc.Diagrammer.Components;

import Co.Gldc.Diagrammer.Shapes.Fill.CirculoFill;
import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.scene.image.Image;

public class CircleComponent extends Component{

    public CircleComponent(){
        super("Circle","Basics",new Image(Component.class.getResource("/Co/Gldc/Diagrammer/circle.png").toExternalForm()));

    }
    @Override
    public Shape createShapeDefault() {
        return new CirculoFill();
    }
}
