package Figuras.Fill;

import Figuras.Polygon;
import Figuras.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class TrianguloFill extends Polygon {

    public TrianguloFill(){
        super();
    }

    public TrianguloFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public TrianguloFill(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        double[] vectX={x.get(),x.get()+w.get(),x.get()+(w.get()/2)};
        double[] vectY={y.get()+h.get(),y.get()+h.get(),y.get()};
        g.fillPolygon(vectX,vectY,3);
    }



}
