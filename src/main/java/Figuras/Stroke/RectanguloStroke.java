package Figuras.Stroke;

import Figuras.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class RectanguloStroke extends Shape {


    public RectanguloStroke(){
        super();
    }

    public RectanguloStroke(double x, double y, double width, double height){
        super(x,y,width,height);
    }


    public RectanguloStroke(List<Object> valores){
        super(valores);
    }


    @Override
    public void draw(GraphicsContext g) {
        g.strokeRect(x.get(),y.get(),w.get(),h.get());
    }
}