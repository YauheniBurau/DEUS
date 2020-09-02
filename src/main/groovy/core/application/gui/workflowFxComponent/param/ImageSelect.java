package core.application.gui.workflowFxComponent.param;

import javafx.scene.image.Image;

public class ImageSelect{
    private Image value;

    public ImageSelect(Image value) {
        this.value = value;
    }

    public Image getValue() {
        return value;
    }

    public void setValue(Image value) {
        this.value = value;
    }
}
