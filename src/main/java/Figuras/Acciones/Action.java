package Figuras.Acciones;

public enum Action {

    MOVE(new MoveHanlder(null)),
    RESIZE(new ResizeHandler(null)),
    RESIZE_X(new MoveHanlder(null)),
    RESIZE_y(new MoveHanlder(null)),
    SELECTION(new SelectionHanlder(null));

    private ActionHandler actionHandler;

    Action(ActionHandler actionHandler){
        this.actionHandler=actionHandler;
    }

    public ActionHandler getActionHandler() {
        return actionHandler;
    }

    public void setActionHandler(ActionHandler actionHandler) {
        this.actionHandler = actionHandler;
    }
}
