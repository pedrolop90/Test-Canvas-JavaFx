package Figuras.Stroke;

import Figuras.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class CirculoStroke extends Shape {

    public CirculoStroke(){
        super();
    }

    public CirculoStroke(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public CirculoStroke(List<Object> valores){
        super(valores);
    }


    @Override
    public void draw(GraphicsContext g) {
        g.strokeOval(x.get(),y.get(),w.get(),h.get());
    }
}