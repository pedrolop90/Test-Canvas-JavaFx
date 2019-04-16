package Figuras;

import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class PolygonFill extends Shape {

    private List<Double> posicionesX;

    public PolygonFill(){
        super();
    }

    public PolygonFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public PolygonFill(List<Object> valores){
        super(valores);
    }

    public PolygonFill(List<Double> x,List<Double> y){
        super();
    }

    @Override
    public void draw(GraphicsContext g) {
        limpiar(g);
        g.fillOval(x.get(),y.get(),w.get(),h.get());
    }



}
