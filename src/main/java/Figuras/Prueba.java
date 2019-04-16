package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class Prueba extends Shape {

    public Prueba(){
        super();
    }

    public Prueba(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        double ang=50;
        g.fillRoundRect(x.get(),y.get(),w.get(),h.get(),ang,ang);
    }
}