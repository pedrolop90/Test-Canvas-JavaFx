package Figuras;


import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape{

    public Rectangle(Rectangle rectangle){
        super(rectangle);
    }

    public Rectangle(){
        super();
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillRect(x.get(),y.get(),w.get(),h.get());

    }
}
