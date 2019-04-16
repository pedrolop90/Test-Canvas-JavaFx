package Figuras;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Generico extends Shape{

    public static final Integer RECTANGULO_FILL = 1;
    public static final Integer CIRCULO_FILL = 2;
    public static final Integer RECTANGULO_STROKE = 3;
    public static final Integer CIRCULO_STROKE = 4;
    public static final Integer RECTANGULO_ESQUINAS_REDONDEADAS_FILL = 5;
    public static final Integer SEMI_CIRCULO = 6;

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
            return new RecntanguloFill(valores);
        }else if(f == CIRCULO_FILL){
            return new CirculoFill(valores);
        }else if(f == RECTANGULO_STROKE){
            return new RectanguloStroke(valores);
        }else if(f == CIRCULO_STROKE){
            return new CirculoStroke(valores);
        }else if(f == RECTANGULO_ESQUINAS_REDONDEADAS_FILL){
            return new RectanguloEsquinasRedondeadasFill(valores);
        }else if(f == SEMI_CIRCULO){
            return new SemiCirculo(valores);
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
