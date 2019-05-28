package Co.Gldc.Diagrammer.Components;

import Co.Gldc.Diagrammer.Shapes.Fill.TrianguloFill;
import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.scene.image.Image;

public class TriangleComponent extends Component{

    public TriangleComponent(){
        super("Triangle","Basics",new Image(TriangleComponent.class.getResource("/Co/Gldc/Diagrammer/triangle.png").toExternalForm()));
    }
    @Override
    public Shape createShapeDefault() {
        return new TrianguloFill();
    }
}
