package Figuras;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

import java.util.List;

public abstract class Shape {
    protected DoubleProperty x=new SimpleDoubleProperty();
    protected DoubleProperty y=new SimpleDoubleProperty();
    protected DoubleProperty w=new SimpleDoubleProperty();
    protected DoubleProperty h=new SimpleDoubleProperty();
    protected BooleanProperty selected=new SimpleBooleanProperty(false);
    protected DoubleProperty tamañoCuadroEsquina=new SimpleDoubleProperty(5);

    public Shape(){
        reiniciar();
    }

    public Shape(double x, double y, double width, double height){
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
        g.setStroke(Color.RED);
        g.setLineDashes(5);
        g.setLineJoin(StrokeLineJoin.ROUND);
        g.strokeRect(x.get()-tamX/2,y.get()-tamY/2,w.get()+tamX,h.get()+tamY);
        //Esquinas
        g.fillRect(x.get()-tamX,y.get()-tamY,tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get()-tamY,tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get()+h.get(),tamX,tamY);
        g.fillRect(x.get()-tamX,y.get()+h.get(),tamX,tamY);
        //Mitad
        g.fillRect(x.get()+(w.get()/2),y.get()-tamY,tamX,tamY);
        g.fillRect(x.get()+w.get(),y.get()+h.get()/2,tamX,tamY);
        g.fillRect(x.get()+(w.get()/2),y.get()+h.get(),tamX,tamY);
        g.fillRect(x.get()-tamX,y.get()+h.get()/2,tamX,tamY);
    }


    public Integer selectedResize(double xi, double yi){
        //esquina superior izquierda
        if(xi>=x.get()-20 && xi<=x.get()+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()-20 && yi<=y.get()+tamañoCuadroEsquina.get()+10){
            return 0;
        }
        //centro norte
        else if(xi>=x.get()+(w.get()/2)-20 && xi<=x.get()+(w.get()/2)+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()-20 && yi<=y.get()+tamañoCuadroEsquina.get()+10){
            return 1;
        }
        //esquina superior derecha
        else if(xi>=x.get()+w.get()-20 && xi<=x.get()+w.get()+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()-20 && yi<=y.get()+tamañoCuadroEsquina.get()+10){
            return 2;
        }
        //centro derecha
        else if(xi>=x.get()+w.get()-20 && xi<=x.get()+w.get()+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()+(h.get()/2)-20 && yi<=y.get()+(h.get()/2)+tamañoCuadroEsquina.get()+10){
            return 3;
        }
        //esquina inferior derecha
        else if(xi>=x.get()+w.get()&&xi<=x.get()+w.get()+tamañoCuadroEsquina.get()&&
                yi>=y.get()+h.get()&&yi<=y.get()+h.get()+tamañoCuadroEsquina.get()){
            return 4;
        }
        //centro sur
        else if(xi>=x.get()+(w.get()/2)-20 && xi<=x.get()+(w.get()/2)+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()+h.get()-20 && yi<=y.get()+h.get()+tamañoCuadroEsquina.get()+10){
            return 5;
        }
        //esquina inferior izquierda
        else if(xi>=x.get()-tamañoCuadroEsquina.get()-20&&xi<=x.get()+tamañoCuadroEsquina.get()&&
                yi>=y.get()+h.get()&&yi<=y.get()+h.get()+tamañoCuadroEsquina.get()){
            return 6;
        }
        //centro izquierda
        else if(xi>=x.get()-20 && xi<=x.get()+tamañoCuadroEsquina.get()+10&&
                yi>=y.get()+(h.get()/2)-20 && yi<=y.get()+(h.get()/2)+tamañoCuadroEsquina.get()+10){
            return 7;
        }
        return -1;
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

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getW() {
        return w.get();
    }

    public DoubleProperty wProperty() {
        return w;
    }

    public void setW(double w) {
        this.w.set(w);
    }

    public double getH() {
        return h.get();
    }

    public DoubleProperty hProperty() {
        return h;
    }

    public void setH(double h) {
        this.h.set(h);
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

    public double getTamañoCuadroEsquina() {
        return tamañoCuadroEsquina.get();
    }

    public DoubleProperty tamañoCuadroEsquinaProperty() {
        return tamañoCuadroEsquina;
    }

    public void setTamañoCuadroEsquina(double tamañoCuadroEsquina) {
        this.tamañoCuadroEsquina.set(tamañoCuadroEsquina);
    }

}
