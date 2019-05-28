package Co.Gldc.Diagrammer.Shapes.Fill;


import Co.Gldc.Diagrammer.Shapes.Polygon;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class RectanguloFill extends Polygon {


    public RectanguloFill(){
        super();
    }

    public RectanguloFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public RectanguloFill(List<Object> valores){
        super(valores);
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFill(color);
        g.fillRect(x.get(),y.get(),w.get(),h.get());
    }

}
