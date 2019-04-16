package Figuras;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.FillRule;

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
        //g.strokeRoundRect();
    }
}