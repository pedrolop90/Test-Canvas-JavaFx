package Figuras.Fill;

import Figuras.Shape;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class CuadrilateroConcavoFill extends Shape {

    private DoubleProperty porcentaje=new SimpleDoubleProperty(0.7);

    public CuadrilateroConcavoFill(){
        super();
    }

    public CuadrilateroConcavoFill(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public CuadrilateroConcavoFill(List<Object> valores){
        super(valores);
        porcentaje.set((double)valores.get(4));
    }

    @Override
    public void draw(GraphicsContext g) {
        double por=h.getValue()*porcentaje.get();
        double pointXF=x.get()+w.get();
        double pointYF=y.get()+h.get();
        double[] vectX={x.get(),x.get()+(w.get()/2),pointXF,x.get()+(w.get()/2)};
        double[] vectY={pointYF,y.get()+por,pointYF,y.get()};
        g.fillPolygon(vectX,vectY,4);
    }

    public double getPorcentaje() {
        return porcentaje.get();
    }

    public DoubleProperty porcentajeProperty() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje.set(porcentaje);
    }
}
