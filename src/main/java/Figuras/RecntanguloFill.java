package Figuras;


import javafx.scene.canvas.GraphicsContext;

public class RecntanguloFill extends Shape{


    public RecntanguloFill(){
        super();
    }

    public RecntanguloFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }
}
