package Figuras;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Box;
import javafx.scene.shape.FillRule;
import sun.java2d.pipe.DrawImage;

public class Prueba extends Shape {

    public Prueba(){
        super();
    }

    public Prueba(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(GraphicsContext g) {
        Box box=new Box();
    }
}