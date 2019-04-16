package Figuras.Fill;


import Figuras.Shape;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class RectanguloFill extends Shape {


    public RectanguloFill(){
        super();
    }

    public RectanguloFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public RectanguloFill(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }
}
