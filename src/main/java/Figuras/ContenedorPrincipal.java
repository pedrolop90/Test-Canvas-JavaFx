package Figuras;

import Figuras.Fill.*;
import javafx.scene.control.SplitPane;

import java.util.List;

public class ContenedorPrincipal extends SplitPane {

    public  enum figuraPredeterminada{
        RECTANGULO_FILL,
        SEMICIRCULO_FILL,
    }

    private Graphics canvas;
    private panelFiguras control;

    public ContenedorPrincipal(double width, double height, boolean ponerPanelControl){
        canvas=new Graphics(width,height);
        control=new panelFiguras();
        if(ponerPanelControl){
            getItems().addAll(control,canvas);
        }else{
            getItems().addAll(canvas);
        }
    }

    public void agregarFigura(figuraPredeterminada f, List<Object> valores){
        switch(f){
            case RECTANGULO_FILL:
                canvas.getFiguras().add(new RectanguloFill(valores));
                break;
            case SEMICIRCULO_FILL:
                canvas.getFiguras().add(new SemiCirculoFill(valores));
                break;
        }
    }

}
