package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class RectanguloStroke extends Shape{


    public RectanguloStroke(){
        super();
    }

    public RectanguloStroke(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.strokeRect(x.get(),y.get(),w.get(),h.get());
    }
}