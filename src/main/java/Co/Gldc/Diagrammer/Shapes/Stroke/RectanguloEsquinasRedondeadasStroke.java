package Co.Gldc.Diagrammer.Shapes.Stroke;

import Co.Gldc.Diagrammer.Shapes.Polygon;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class RectanguloEsquinasRedondeadasStroke extends Polygon {

    private DoubleProperty porcentaje=new SimpleDoubleProperty();

    public RectanguloEsquinasRedondeadasStroke(){
        super();
    }

    public RectanguloEsquinasRedondeadasStroke(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.porcentaje.set(10);
    }


    public RectanguloEsquinasRedondeadasStroke(List<Object> valores){
        super(valores);
        this.porcentaje.set((Double)valores.get(4));
    }


    @Override
    public void draw(GraphicsContext g) {
        g.setFill(color);
        double ang=(porcentaje.getValue()*w.get())/100;
        g.strokeRoundRect(x.get(),y.get(),w.get(),h.get(),ang,ang);
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