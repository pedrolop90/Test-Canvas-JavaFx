package Co.Gldc.Diagrammer.Components;

import Co.Gldc.Diagrammer.Shapes.Fill.RectanguloEsquinasRedondeadasFill;
import Co.Gldc.Diagrammer.Shapes.Fill.TrianguloFill;
import Co.Gldc.Diagrammer.Shapes.Shape;
import javafx.scene.image.Image;

public class RectangleCurveComponent extends Component{

    public RectangleCurveComponent(){
        super("Rectangle Curve","",new Image(RectangleCurveComponent.class.getResource("/Co/Gldc/Diagrammer/rectangle-curve.png").toExternalForm()));
    }
    @Override
    public Shape createShapeDefault() {
        return new RectanguloEsquinasRedondeadasFill();
    }
}
