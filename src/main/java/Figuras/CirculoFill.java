package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class CirculoFill extends Shape {

    public CirculoFill(){
        super();
    }

    public CirculoFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillOval(x.get(),y.get(),w.get(),h.get());
    }



}