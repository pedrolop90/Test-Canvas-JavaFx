package Figuras;


import java.util.List;

public abstract class Polygon extends Shape {

    public Polygon(){
        super();
    }

    public Polygon(double x,double y,double w,double h){
        super(x,y,w,h);
    }
    public Polygon(List<Object> valores){
        super(valores);
    }


}
