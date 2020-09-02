package core.application.gui.graphFxComponent.view;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Arrow2dFx extends Path {

    public Arrow2dFx() {
        /* Create this arrow shape */
        getElements().add(new MoveTo(0, 0));
        getElements().add(new LineTo(-6, 3));
        getElements().add(new MoveTo(0, 0));
        getElements().add(new LineTo(-6, -3));
    }

}
