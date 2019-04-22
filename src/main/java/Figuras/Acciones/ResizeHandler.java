package Figuras.Acciones;

import Figuras.SelectionModel;
import Figuras.Shape;

public class ResizeHandler implements ActionHandler {

    private SelectionModel selectionModel;

    public ResizeHandler(SelectionModel sm){
        this.selectionModel=sm;
    }

    @Override
    public void calcularCambio(double x, double y, double deltaX,double deltaY) {
        //TODO
        Shape f=selectionModel.getSelectedItems().get(0);
        if(selectionModel.getEsquina()[0]){
            resizeEsquinaSuperiorIzquierda(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[1]){
            resizeCentroNorte(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[2]){
            resizeEsquinaSuperiorDerecha(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[3]){
            resizeCentroDerecha(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[4]){
            resizeEsquinaInferiorDerecha(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[5]){
            resizeCentroSur(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[6]){
            resizeEsquinaInferiorIzquierda(x,y,deltaX,deltaY,f);
        }
        if(selectionModel.getEsquina()[7]){
            resizeCentroIzquierda(x,y,deltaX,deltaY,f);
        }
    }

    private void resizeEsquinaSuperiorIzquierda(double x,double y,double deltaX,double deltaY,Shape f){
        if(f.getW()<0){
            selectionModel.getEsquina()[2]=true;
            selectionModel.getEsquina()[0]=false;
            resizeEsquinaSuperiorDerecha(x,y,deltaX,deltaY,f);
            return;
        }
        if(f.getH()<0){
            selectionModel.getEsquina()[6]=true;
            selectionModel.getEsquina()[0]=false;
            resizeEsquinaInferiorIzquierda(x,y,deltaX,deltaY,f);
            return;
        }
        resizeCentroIzquierda(x,y,deltaX,deltaY,f);
        resizeCentroNorte(x,y,deltaX,deltaY,f);
    }


    private void resizeEsquinaSuperiorDerecha(double x,double y,double deltaX,double deltaY,Shape f){
        if(x<f.getX()){
            selectionModel.getEsquina()[0]=true;
            selectionModel.getEsquina()[2]=false;
            resizeEsquinaSuperiorIzquierda(x,y,deltaX,deltaY,f);
            return;
        }
        if(f.getH()<0){
            selectionModel.getEsquina()[4]=true;
            selectionModel.getEsquina()[2]=false;
            resizeEsquinaInferiorDerecha(x,y,deltaX,deltaY,f);
            return;
        }
        resizeCentroDerecha(x,y,deltaX,deltaY,f);
        resizeCentroNorte(x,y,deltaX,deltaY,f);
    }


    private void resizeEsquinaInferiorDerecha(double x,double y,double deltaX,double deltaY,Shape f){
        if(x<f.getX()){
            selectionModel.getEsquina()[6]=true;
            selectionModel.getEsquina()[4]=false;
            resizeEsquinaInferiorIzquierda(x,y,deltaX,deltaY,f);
            return;
        }
        if(y<f.getY()){
            selectionModel.getEsquina()[2]=true;
            selectionModel.getEsquina()[4]=false;
            resizeEsquinaSuperiorDerecha(x,y,deltaX,deltaY,f);
            return;
        }
        resizeCentroDerecha(x,y,deltaX,deltaY,f);
        resizeCentroSur(x,y,deltaX,deltaY,f);
    }

    private void resizeEsquinaInferiorIzquierda(double x,double y,double deltaX,double deltaY,Shape f){
        if(f.getW()<0){
            selectionModel.getEsquina()[4]=true;
            selectionModel.getEsquina()[6]=false;
            resizeEsquinaInferiorDerecha(x,y,deltaX,deltaY,f);
            return;
        }
        if(y<f.getY()){
            selectionModel.getEsquina()[0]=true;
            selectionModel.getEsquina()[6]=false;
            resizeEsquinaSuperiorIzquierda(x,y,deltaX,deltaY,f);
            return;
        }
        resizeCentroIzquierda(x,y,deltaX,deltaY,f);
        resizeCentroSur(x,y,deltaX,deltaY,f);
    }


    private void resizeCentroDerecha(double x,double y,double deltaX,double deltaY,Shape f){
        if(x<f.getX()){
            selectionModel.getEsquina()[7]=true;
            selectionModel.getEsquina()[3]=false;
            resizeCentroIzquierda(x,y,deltaX,deltaY,f);
            return;
        }
        f.setW(x-f.getX());
    }

    private void resizeCentroIzquierda(double x, double y, double deltaX, double deltaY, Shape f){
        if(f.getW()<0){
            selectionModel.getEsquina()[3]=true;
            selectionModel.getEsquina()[7]=false;
            resizeCentroDerecha(x,y,deltaX,deltaY,f);
            return;
        }
        f.setW(f.getW()+(f.getX()-x));
        f.setX(x);
    }

    private void resizeCentroSur(double x, double y, double deltaX, double deltaY, Shape f){
        if(y<f.getY()){
            selectionModel.getEsquina()[1]=true;
            selectionModel.getEsquina()[5]=false;
            resizeCentroNorte(x,y,deltaX,deltaY,f);
            return;
        }
        f.setH(y - f.getY());
    }

    private void resizeCentroNorte(double x, double y, double deltaX, double deltaY, Shape f){
        if(f.getH()<0){
            selectionModel.getEsquina()[5]=true;
            selectionModel.getEsquina()[1]=false;
            resizeCentroSur(x,y,deltaX,deltaY,f);
            return;
        }
        f.setH(f.getH()+(f.getY()-y));
        f.setY(y);
    }



    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
