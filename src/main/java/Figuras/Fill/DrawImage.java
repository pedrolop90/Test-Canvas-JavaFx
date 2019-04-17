package Figuras.Fill;

import Figuras.Shape;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public class DrawImage extends Shape {

    private StringProperty url=new SimpleStringProperty("2.jpg");

    public DrawImage(){
        super();
    }

    public DrawImage(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    public DrawImage(List<Object> valores){
        super(valores);
        url.set(String.valueOf(valores.get(4)));
    }

    @Override
    public void draw(GraphicsContext g) {
        g.drawImage(new Image(url.get()),x.get(),y.get(),w.get(),h.get());
    }



}
