package core.application.gui.factoryFx;

import javafx.scene.control.ScrollPane;

public class ScrollPaneFxFactory {

    public static ScrollPane create(double prefWidth, double prefHeight) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(prefWidth, prefHeight);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        return scrollPane;
    }

}
