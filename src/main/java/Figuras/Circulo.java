package Figuras;

import javafx.scene.canvas.GraphicsContext;

public class Circulo extends Shape {

    public Circulo(Circulo circulo){
        super(circulo);
    }

    public Circulo(){
        super();
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillOval(x.get(),y.get(),w.get(),h.get());
    }



}
