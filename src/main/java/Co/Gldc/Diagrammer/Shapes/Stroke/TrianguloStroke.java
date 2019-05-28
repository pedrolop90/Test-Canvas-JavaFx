package Co.Gldc.Diagrammer.Shapes.Stroke;

import Co.Gldc.Diagrammer.Shapes.Polygon;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class TrianguloStroke extends Polygon {

    public TrianguloStroke(){
        super();
    }

    public TrianguloStroke(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public TrianguloStroke(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFill(color);
        double[] vectX={x.get(),x.get()+w.get(),(x.get()+w.get())/2};
        double[] vectY={y.get()+h.get(),y.get()+h.get(),y.get()};
        g.strokePolygon(vectX,vectY,3);
    }



}
