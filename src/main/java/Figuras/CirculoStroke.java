package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class CirculoStroke extends Shape {

    public CirculoStroke(){
        super();
    }

    public CirculoStroke(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.strokeOval(x.get(),y.get(),w.get(),h.get());
    }
}