package core.application.gui.workflowFxComponent.bean;

import core.application.gui.workflowFxComponent.param.FileSelect;

public class BeanFileSelect implements IBean<FileSelect> {
    private FileSelect value;

    public BeanFileSelect() {
        this.value = FileSelect.fileEmpty();
    }

    @Override
    public FileSelect getValue() {
        return value;
    }

    @Override
    public void setValue(FileSelect value) {
        this.value = value;
    }
}
