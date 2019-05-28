package Figuras.Shapes;

import Figuras.Polygon;
import Figuras.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class CirculoFill extends Polygon {

    public CirculoFill(){
        super();
    }

    public CirculoFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public CirculoFill(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        g.fillOval(x.get(),y.get(),w.get(),h.get());
    }



}
