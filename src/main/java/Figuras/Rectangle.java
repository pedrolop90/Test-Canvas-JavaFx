package Figuras;


import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape{


    public Rectangle(){
        super();
    }

    public Rectangle(double x,double y,double width,double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }
}
