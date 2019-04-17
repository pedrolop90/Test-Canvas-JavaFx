package Figuras;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class Shape {

    public enum TipoAccion{
        MOVE,
        RESIZE_EXTREME,
        RESIZE_CENTRO_X,
        RESIZE_CENTRO_Y,
        CREATE
    }

    protected DoubleProperty x=new SimpleDoubleProperty();
    protected DoubleProperty y=new SimpleDoubleProperty();
    protected DoubleProperty w=new SimpleDoubleProperty();
    protected DoubleProperty h=new SimpleDoubleProperty();
    protected DoubleProperty xi=new SimpleDoubleProperty();
    protected DoubleProperty yi=new SimpleDoubleProperty();
    protected IntegerProperty z=new SimpleIntegerProperty();
    protected IntegerProperty id=new SimpleIntegerProperty();
    private BooleanProperty estadoFigura=new SimpleBooleanProperty(false);
    private DoubleProperty tamañoCuadroEsquina=new SimpleDoubleProperty(5);
    public ObjectProperty<TipoAccion> accionFigura=new SimpleObjectProperty<>();

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

    public void figuraSeleccionada(GraphicsContext g){
        g.setFill(Color.RED);
        double tamX=tamañoCuadroEsquina.doubleValue();
        double tamY=tamañoCuadroEsquina.doubleValue();
        //Esquinas
        g.fillRect(x.get(),y.get(),tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get(),tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get()+h.get(),tamX,tamY);
        g.fillRect(x.get(),y.get()+h.get(),tamX,tamY);
        //Mitad
        g.fillRect(x.get()+(w.get()/2),y.get(),tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get()+h.get()/2,tamX,tamY);
        g.fillRect(x.get()+(w.get()/2),y.get()+h.get(),tamX,tamY);
        g.fillRect(x.get(),y.get()+h.get()/2,tamX,tamY);
        g.setFill(Color.BLUE);
    }

    public TipoAccion esquinaSeleccionada(double xi,double yi){
        if(xi>=x.get()+w.get()&&xi<=x.get()+w.get()+tamañoCuadroEsquina.get()&&
                yi>=y.get()+h.get()&&yi<=y.get()+h.get()+tamañoCuadroEsquina.get()){
            return TipoAccion.RESIZE_EXTREME;
        }else if(xi>=x.get()+w.get()-20 && xi<=x.get()+w.get()+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()+(h.get()/2)-20 && yi<=y.get()+(h.get()/2)+tamañoCuadroEsquina.get()+10){
            return TipoAccion.RESIZE_CENTRO_X;
        }else if(xi>=x.get()+(w.get()/2)-20 && xi<=x.get()+(w.get()/2)+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()+h.get()-20 && yi<=y.get()+h.get()+tamañoCuadroEsquina.get()+10){
            return TipoAccion.RESIZE_CENTRO_Y;
        }
        return TipoAccion.MOVE;
    }


    public void reiniciar(){
        x.set(-1);
        y.set(-1);
        w.set(-1);
        h.set(-1);
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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public boolean isEstadoFigura() {
        return estadoFigura.get();
    }

    public BooleanProperty estadoFiguraProperty() {
        return estadoFigura;
    }

    public void setEstadoFigura(boolean estadoFigura) {
        this.estadoFigura.set(estadoFigura);
    }

    public double getXi() {
        return xi.get();
    }

    public DoubleProperty xiProperty() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi.set(xi);
    }

    public double getYi() {
        return yi.get();
    }

    public DoubleProperty yiProperty() {
        return yi;
    }

    public void setYi(double yi) {
        this.yi.set(yi);
    }

    public TipoAccion getAccionFigura() {
        return accionFigura.get();
    }

    public ObjectProperty<TipoAccion> accionFiguraProperty() {
        return accionFigura;
    }

    public void setAccionFigura(TipoAccion accionFigura) {
        this.accionFigura.set(accionFigura);
    }
}
