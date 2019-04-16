package Figuras;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

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
        double[] vectX={1,100,50};
        double[] vectY={100,100,25};
        g.fillPolygon(vectX,vectY,3);
    }
}