package Figuras.Connector;

import Figuras.Polygon;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Default extends Polygon {
    public Default(){
        super();
    }

    public Default(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public Default(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        double[] vectX={x.get(),w.getValue()};
        double[] vectY={y.get(),h.getValue()};
        g.fillPolygon(vectX,vectY,2);
    }
}
