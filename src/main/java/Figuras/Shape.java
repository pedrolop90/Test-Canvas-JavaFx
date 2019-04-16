package Figuras;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {

    protected DoubleProperty x=new SimpleDoubleProperty();
    protected DoubleProperty y=new SimpleDoubleProperty();
    protected DoubleProperty w=new SimpleDoubleProperty();
    protected DoubleProperty h=new SimpleDoubleProperty();
    protected IntegerProperty z=new SimpleIntegerProperty();
    protected DoubleProperty maxW=new SimpleDoubleProperty();
    protected DoubleProperty maxH=new SimpleDoubleProperty();
    protected IntegerProperty id=new SimpleIntegerProperty();

    public Shape(){
        reiniciar();
    }

    public Shape(double x,double y,double width,double height){
        reiniciar();
        this.x.set(x);
        this.y.set(y);
        this.w.set(width);
        this.h.set(height);
    }

    protected void limpiar(GraphicsContext g){
        maxW.set(Math.max(maxW.get(),w.get()));
        maxH.set(Math.max(maxH.get(),h.get()));
        g.clearRect(x.get(),y.get(),maxW.get(),maxH.get());
    }

    public void reiniciar(){
        x.set(-1);
        y.set(-1);
        w.set(-1);
        h.set(-1);
        maxH.set(-1);
        maxW.set(-1);
    }


    public abstract void draw(GraphicsContext g);


    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public double getW() {
        return w.get();
    }

    public DoubleProperty wProperty() {
        return w;
    }

    public double getH() {
        return h.get();
    }

    public DoubleProperty hProperty() {
        return h;
    }

    public int getZ() {
        return z.get();
    }

    public IntegerProperty zProperty() {
        return z;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public void setW(double w) {
        this.w.set(w);
    }

    public void setH(double h) {
        this.h.set(h);
    }

    public void setZ(int z) {
        this.z.set(z);
    }

    public double getMaxW() {
        return maxW.get();
    }

    public DoubleProperty maxWProperty() {
        return maxW;
    }

    public void setMaxW(double maxW) {
        this.maxW.set(maxW);
    }

    public double getMaxH() {
        return maxH.get();
    }

    public DoubleProperty maxHProperty() {
        return maxH;
    }

    public void setMaxH(double maxH) {
        this.maxH.set(maxH);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

}
