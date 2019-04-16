package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class Generico extends Shape{

    public static final Integer RECTANGULO = 1;
    public static final Integer CIRCULO = 2;

    private Shape figura;

    public Generico(Integer f,double x,double y,double width,double heigth){
        if(f == RECTANGULO){
            figura=new Rectangle(x,y,width,heigth);
        }else if(f == CIRCULO){
            figura=new Circulo(x,y,width,heigth);
        }
    }

    @Override
    public void draw(GraphicsContext g) {
        figura.draw(g);
    }
}
