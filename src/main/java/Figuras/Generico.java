package Figuras;

import Figuras.Fill.*;
import Figuras.Stroke.*;
import com.sun.istack.internal.Nullable;
import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Generico extends Shape{

    //Fill
    public static final Integer RECTANGULO_FILL = 1;
    public static final Integer CIRCULO_FILL = 2;
    public static final Integer RECTANGULO_ESQUINAS_REDONDEADAS_FILL = 3;
    public static final Integer SEMI_CIRCULO_FILL = 4;
    public static final Integer TRIANGULO_FILL = 5;
    public static final Integer CUADRILATERO_CONVEXO_FILL = 6;
    public static final Integer CUADRILATERO_CONCAVO_FILL = 7;
    //Stroke
    public static final Integer RECTANGULO_STROKE = 8;
    public static final Integer CIRCULO_STROKE = 9;
    public static final Integer RECTANGULO_ESQUINAS_REDONDEADAS_STROKE = 10;
    public static final Integer SEMI_CIRCULO_STROKE = 11;
    public static final Integer TRIANGULO_STROKE = 12;
    public static final Integer CUADRILATERO_CONVEXO_STROKE = 13;
    public static final Integer CUADRILATERO_CONCAVO_STROKE = 14;
    //DrawImage
    public static final Integer DRAWIMAGE = 15;

    private List<Shape> figuras=new ArrayList<>();
    private ObjectProperty<Shape> figuaSeleccionada=new SimpleObjectProperty<>();

    public Generico(){
        init();
    }

    public Generico(Integer f,List<Object> valores){
       figuras.add(buscarFigura(f,valores));
       init();
    }

    public Generico(List<Integer> figuras,List<List<Object>> posiciones){
        for (int i = 0; i < figuras.size(); i++) {
            this.figuras.add(buscarFigura(figuras.get(i), posiciones.get(i)));
        }
      init();
    }
    @Override
    public void draw(GraphicsContext g) {
        g.clearRect(0,0,800,600);
        if(estadoFiguraProperty().get()){
            figuaSeleccionada.get().figuraSeleccionada(g);
                accionFigura.set(esquinaSeleccionada(xi.get(), yi.get()));
        }
        for (int i = 0; i < figuras.size(); i++) {
            if(!estadoFiguraProperty().get()) {
                Shape a = figuras.get(i);
                double xW = a.getX() + a.getW();
                double yH = a.getY() + a.getH();
                if (xi.get() >= a.getX() && xi.get()<= xW && yi.get() >= a.getY() && yi.get()<= yH) {
                    a.figuraSeleccionada(g);
                    figuaSeleccionada.set(a);
                    accionFigura.set(TipoAccion.MOVE);
                    estadoFiguraProperty().set(true);
                }
            }
            figuras.get(i).draw(g);
        }

    }

    private void init(){
        estadoFiguraProperty().addListener(observable -> {
            if(figuaSeleccionada.get()!=null) {
                if (!estadoFiguraProperty().get()) {
                    x.unbindBidirectional(figuaSeleccionada.get().x);
                    y.unbindBidirectional(figuaSeleccionada.get().y);
                    w.unbindBidirectional(figuaSeleccionada.get().w);
                    h.unbindBidirectional(figuaSeleccionada.get().h);
                    figuaSeleccionada.set(null);
                } else{
                    x.bindBidirectional(figuaSeleccionada.get().x);
                    y.bindBidirectional(figuaSeleccionada.get().y);
                    w.bindBidirectional(figuaSeleccionada.get().w);
                    h.bindBidirectional(figuaSeleccionada.get().h);
                }
            }
        });
    }

    public static Shape buscarFigura(Integer f,@Nullable List<Object> valores){
        if(f == RECTANGULO_FILL){
            return new RectanguloFill(valores);
        }else if(f == CIRCULO_FILL){
            return new CirculoFill(valores);
        }else if(f == RECTANGULO_STROKE){
            return new RectanguloStroke(valores);
        }else if(f == CIRCULO_STROKE){
            return new CirculoStroke(valores);
        }else if(f == RECTANGULO_ESQUINAS_REDONDEADAS_FILL){
            return new RectanguloEsquinasRedondeadasFill(valores);
        }else if(f == SEMI_CIRCULO_FILL){
            return new SemiCirculoFill(valores);
        }else if(f == TRIANGULO_FILL){
            return new TrianguloFill(valores);
        }else if(f == CUADRILATERO_CONVEXO_FILL){
            return new CuadrilateroConvexoFill(valores);
        }else if(f == CUADRILATERO_CONCAVO_FILL){
            return new CuadrilateroConcavoFill(valores);
        }else if(f == RECTANGULO_ESQUINAS_REDONDEADAS_STROKE){
            return new RectanguloEsquinasRedondeadasStroke(valores);
        }else if(f == SEMI_CIRCULO_STROKE){
            return new SemiCirculoStroke(valores);
        }else if(f == TRIANGULO_STROKE){
            return new TrianguloStroke(valores);
        }else if(f == CUADRILATERO_CONVEXO_STROKE){
            return new CuadrilateroConvexoStroke(valores);
        }else if(f == CUADRILATERO_CONCAVO_STROKE){
            return new CuadrilateroConcavoStroke(valores);
        }else if(f == DRAWIMAGE){
            return new DrawImage(valores);
        }
        return null;
    }

    public List<Shape> getFiguras() {
        return figuras;
    }

    public void setFiguras(List<Shape> figuras) {
        this.figuras = figuras;
    }

    public Shape getFiguaSeleccionada() {
        return figuaSeleccionada.get();
    }

    public ObjectProperty<Shape> figuaSeleccionadaProperty() {
        return figuaSeleccionada;
    }

    public void setFiguaSeleccionada(Shape figuaSeleccionada) {
        this.figuaSeleccionada.set(figuaSeleccionada);
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


}
