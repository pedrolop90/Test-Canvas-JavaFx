package Co.Gldc.Diagrammer.Shapes;

import Co.Gldc.Diagrammer.Shapes.Acciones.Action;
import Co.Gldc.Diagrammer.Shapes.Acciones.ActionHandler;
import Co.Gldc.Diagrammer.Shapes.Acciones.MoveHanlder;
import Co.Gldc.Diagrammer.Shapes.Acciones.ResizeHandler;
import Co.Gldc.Diagrammer.Shapes.Acciones.SelectionHanlder;

import java.util.Map;
import java.util.TreeMap;

public class SelectionAction {

    private Map<Action, ActionHandler> actions=new TreeMap<>();
    private Action context=null;

    public SelectionAction(SelectionModel selectionModel){
        actions.put(Action.SELECTION,new SelectionHanlder(selectionModel));
        actions.put(Action.MOVE,new MoveHanlder(selectionModel));
        actions.put(Action.RESIZE,new ResizeHandler(selectionModel));
        actions.put(Action.GROUP,new ResizeHandler(selectionModel));
    }

    public Map<Action, ActionHandler> getActions() {
        return actions;
    }

    public void setActions(Map<Action, ActionHandler> actions) {
        this.actions = actions;
    }

    public Action getContext() {
        return context;
    }

    public void setContext(Action context) {
        this.context = context;
    }
}
