package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class Generico extends Shape{

    public static final Integer RECTANGULO_FILL = 1;
    public static final Integer CIRCULO_FILL = 2;
    public static final Integer RECTANGULO_STROKE = 3;
    public static final Integer CIRCULO_STROKE = 4;

    private Shape figura;

    public Generico(Integer f,double x,double y,double width,double heigth){
        this.figura=buscarFigura(f,x,y,width,heigth);
    }

    @Override
    public void draw(GraphicsContext g) {
        figura.draw(g);
    }

    public static Shape buscarFigura(Integer f,double x,double y,double width,double heigth){
        if(f == RECTANGULO_FILL){
            return new RecntanguloFill(x,y,width,heigth);
        }else if(f == CIRCULO_FILL){
            return new CirculoFill(x,y,width,heigth);
        }else if(f == RECTANGULO_STROKE){
            return new RectanguloStroke(x,y,width,heigth);
        }else if(f == CIRCULO_STROKE){
            return new CirculoStroke(x,y,width,heigth);
        }
        return null;
    }

}
