package Co.Gldc.Diagrammer.Shapes.Stroke;

import Co.Gldc.Diagrammer.Shapes.Polygon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class CuadrilateroConvexoStroke extends Polygon {

    private DoubleProperty porcentaje=new SimpleDoubleProperty(0.2);

    public CuadrilateroConvexoStroke(){
        super();
    }

    public CuadrilateroConvexoStroke(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public CuadrilateroConvexoStroke(List<Object> valores){
        super(valores);
        porcentaje.set((double)valores.get(4));
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFill(color);
        double por=w.getValue()*porcentaje.get();
        double pointXF=x.get()+w.get();
        double pointYF=y.get()+h.get();
        double[] vectX={x.get(),x.get()+ por,(pointXF)- por,pointXF};
        double[] vectY={pointYF,y.get(),y.get(),pointYF};
        g.strokePolygon(vectX,vectY,4);
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
