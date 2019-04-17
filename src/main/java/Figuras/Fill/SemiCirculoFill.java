package Figuras.Fill;

import Figuras.Shape;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

import java.util.List;

public class SemiCirculoFill extends Shape {

    private DoubleProperty startAngulo=new SimpleDoubleProperty();
    private DoubleProperty arcExtent=new SimpleDoubleProperty();
    private ObjectProperty<ArcType> arcType=new SimpleObjectProperty<ArcType>();


    public SemiCirculoFill(){
        super();
    }

    public SemiCirculoFill(double x, double y, double width, double height){
        super(x,y,width,height);
        startAngulo.set(0);
        arcExtent.set(180);
        arcType.set(ArcType.OPEN);
    }

    public SemiCirculoFill(List<Object> valores){
        super(valores);
        startAngulo.set((Double)valores.get(4));
        arcExtent.set((Double)valores.get(5));
        arcType.set((ArcType) valores.get(6));
    }


    @Override
    public void draw(GraphicsContext g) {
        g.fillArc(x.get(),y.get(),w.get(),h.get(),startAngulo.getValue(),arcExtent.getValue(), arcType.get());
    }

    public double getStartAngulo() {
        return startAngulo.get();
    }

    public DoubleProperty startAnguloProperty() {
        return startAngulo;
    }

    public void setStartAngulo(double startAngulo) {
        this.startAngulo.set(startAngulo);
    }

    public double getArcExtent() {
        return arcExtent.get();
    }

    public DoubleProperty arcExtentProperty() {
        return arcExtent;
    }

    public void setArcExtent(double arcExtent) {
        this.arcExtent.set(arcExtent);
    }

    public ArcType getArcType() {
        return arcType.get();
    }

    public ObjectProperty<ArcType> arcTypeProperty() {
        return arcType;
    }

    public void setArcType(ArcType arcType) {
        this.arcType.set(arcType);
    }
}
