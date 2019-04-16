package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class Circulo extends Shape {

    public Circulo(){
        super();
    }

    public Circulo(double x,double y,double width,double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillOval(x.get(),y.get(),w.get(),h.get());
    }



}
