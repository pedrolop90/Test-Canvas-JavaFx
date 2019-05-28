package Co.Gldc.Diagrammer.Shapes;

import java.util.ArrayList;
import java.util.List;

public abstract class Polygon extends Shape {

    private ArrayList<Shape> conectados=new ArrayList<>();

    public Polygon(){super();}
    public Polygon(double x,double y,double w,double h){ super(x,y,w,h); }
    public Polygon(List<Object> valores){ super(valores); }

    public void add(Shape figura){ conectados.add(figura); }
}
