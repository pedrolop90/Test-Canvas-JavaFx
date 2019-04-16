package Figuras;

import Figuras.Fill.*;
import Figuras.Stroke.CirculoStroke;
import Figuras.Stroke.RectanguloEsquinasRedondeadasStroke;
import Figuras.Stroke.RectanguloStroke;
import Figuras.Stroke.SemiCirculoStroke;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Generico extends Shape{

    //Fill
    public static final Integer RECTANGULO_FILL = 1;
    public static final Integer CIRCULO_FILL = 2;
    public static final Integer RECTANGULO_ESQUINAS_REDONDEADAS_FILL = 5;
    public static final Integer SEMI_CIRCULO_FILL = 6;
    public static final Integer TRIANGULO_FILL = 7;
    public static final Integer CUADRILATERO_CONVEXO = 8;
    public static final Integer CUADRILATERO_CONCAVO = 9;
    //Stroke
    public static final Integer RECTANGULO_STROKE = 3;
    public static final Integer CIRCULO_STROKE = 4;
    public static final Integer RECTANGULO_ESQUINAS_REDONDEADAS_STROKE = 10;
    public static final Integer SEMI_CIRCULO_STROKE = 11;

    private List<Shape> figuras=new ArrayList<>();

    public Generico(Integer f,List<Object> valores){
       figuras.add(buscarFigura(f,valores));
    }

    public Generico(List<Integer> figuras,List<List<Object>> posiciones){
        for (int i = 0; i < figuras.size(); i++) {
            this.figuras.add(buscarFigura(figuras.get(i), posiciones.get(i)));
        }
    }
    @Override
    public void draw(GraphicsContext g) {
        for (int i = 0; i < figuras.size(); i++) {
            figuras.get(i).draw(g);
        }
    }

    public static Shape buscarFigura(Integer f,List<Object> valores){
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
        }else if(f == CUADRILATERO_CONVEXO){
            return new CuadrilateroConvexoFill(valores);
        }else if(f == CUADRILATERO_CONCAVO){
            return new CuadrilateroConcavoFill(valores);
        }else if(f == RECTANGULO_ESQUINAS_REDONDEADAS_STROKE){
            return new RectanguloEsquinasRedondeadasStroke(valores);
        }else if(f == SEMI_CIRCULO_STROKE){
            return new SemiCirculoStroke(valores);
        }
        return null;
    }

    public List<Shape> getFiguras() {
        return figuras;
    }

    public void setFiguras(List<Shape> figuras) {
        this.figuras = figuras;
    }
}
