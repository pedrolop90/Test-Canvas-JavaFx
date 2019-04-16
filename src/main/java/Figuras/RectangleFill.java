package Figuras;


import javafx.scene.canvas.GraphicsContext;

public class RectangleFill extends Shape{


    public RectangleFill(){
        super();
    }

    public RectangleFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }
}
