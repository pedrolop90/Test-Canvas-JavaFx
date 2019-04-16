import Figuras.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaneControl extends GridPane {

    private List<ToggleButton> botones=new ArrayList<>();
    private Map<Integer, Shape> figuras=new TreeMap<>();
    private StringProperty accionActual=new SimpleStringProperty();
    private EventHandler accionClick = evt -> {
        ToggleButton btn=(ToggleButton) evt.getTarget();
        this.getProperties().put("figura",(Shape)(figuras.get(Integer.parseInt(btn.getId()))));
    };

    public PaneControl(){
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        getColumnConstraints().add(col1);
        getColumnConstraints().add(col2);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(10));
        botones.add(crearBoton("Cuadrado",null,0,0,new Rectangle(),0));
        botones.add(crearBoton("Circulo",null,1,0,new Circulo(),1));

    }

    public ToggleButton crearBoton(String nombre, String icon,int x, int y,Shape figura,int num){
        ToggleButton boton=new ToggleButton();
        if(icon==null){
            boton.setText(nombre);
        }else{
            boton.setStyle("-fx-background-image: url("+icon+")");
        }
        boton.setOnAction(accionClick);
        this.add(boton,x,y);
        figuras.put(num,figura);
        boton.setId(""+num);
        return boton;
    }

    public StringProperty getAccionActual(){
        return accionActual;
    }

}
