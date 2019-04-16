package Figuras;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class Shape {

    protected DoubleProperty x=new SimpleDoubleProperty();
    protected DoubleProperty y=new SimpleDoubleProperty();
    protected DoubleProperty w=new SimpleDoubleProperty();
    protected DoubleProperty h=new SimpleDoubleProperty();
    protected IntegerProperty z=new SimpleIntegerProperty();
    protected DoubleProperty maxW=new SimpleDoubleProperty();
    protected DoubleProperty maxH=new SimpleDoubleProperty();
    protected IntegerProperty id=new SimpleIntegerProperty();
    protected BooleanProperty selected=new SimpleBooleanProperty();

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

    public Shape(List<Object> valores){
        reiniciar();
        this.x.set((Double)valores.get(0));
        this.y.set((Double)valores.get(1));
        this.w.set((Double)valores.get(2));
        this.h.set((Double)valores.get(3));
    }

    protected void limpiar(GraphicsContext g){
        maxW.set(Math.max(maxW.get(),w.get()));
        maxH.set(Math.max(maxH.get(),h.get()));
        g.clearRect(x.get(),y.get(),maxW.get(),maxH.get());
    }

    public void figuraSeleccionada(GraphicsContext g){
        g.setFill(Color.RED);
        double tamX=10;
        double tamY=10;
        g.fillRect((x.get()+w.get())/2,y.get(),tamX,tamY);
        g.fillRect((x.get()+w.get())/2,y.get()+h.get(),tamX,tamY);
        g.fillRect(x.get(),(y.get()+h.get())/2,tamX,tamY);
        g.fillRect(x.get()+w.get(),(y.get()+h.get())/2,tamX,tamY);
        g.setFill(Color.BLUE);
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

    public boolean isSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }
}
