package Figuras;


import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class RecntanguloFill extends Shape{


    public RecntanguloFill(){
        super();
    }

    public RecntanguloFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public RecntanguloFill(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }
}
