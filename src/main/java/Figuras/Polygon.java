package Figuras;


import javafx.collections.ObservableList;

import java.util.List;
import java.util.Observable;

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
