package core.application.gui.workflowFxComponent.binding;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class BindingFx {
    /**
     * this type of binding child Node into Parent Node in expression of relative coordinates,
     * where (0, 0) - is center of Parent node
     * @param x -1..+1
     * @param y -1..+1
     */
    public static void bind(Pane parent, Region child, double x, double y){
        if(!parent.getChildren().contains(child) ){
            parent.getChildren().add(child);
        }
        child.layoutXProperty().unbind();
        child.layoutXProperty().bind(parent.widthProperty()
                .divide(2)
                .subtract(child.widthProperty().divide(2))
                .add(parent.widthProperty().divide(2).multiply(x))
        );
        child.layoutYProperty().unbind();
        child.layoutYProperty().bind(parent.heightProperty()
                .divide(2)
                .subtract(child.heightProperty().divide(2))
                .add(parent.heightProperty().divide(2).multiply(y))
        );
    }

}
