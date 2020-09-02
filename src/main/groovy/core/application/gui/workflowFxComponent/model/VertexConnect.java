package core.application.gui.workflowFxComponent.model;

import core.application.gui.workflowFxComponent.bean.IBean;
import core.application.serializable.SerializableColor;
import javafx.scene.paint.Color;
import newWorkflowFx.ShapeSvgPathEnum;

import java.io.Serializable;

/**
 * x -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 * y -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 */
public class VertexConnect implements Serializable {
    private static final long serialVersionUID = 1L;
    private WorkflowVertex vertex;
    private ShapeSvgPathEnum shapeSvgPathEnum;
    private String shapeSvgPath = "";
    private transient Color backgroundColor = Color.YELLOW;
    private SerializableColor sBackgroundColor;
    private double size = 0;
    private String label = "";
    private transient Color labelColor = Color.BLACK;
    private SerializableColor sLabelColor;
    private double x = 0;
    private double y = 0;

    private int paramNumber;
    private VertexContactTypeEnum type;
    private transient IBean value;

    public VertexConnect() {

    }

    public WorkflowVertex getVertex() {
        return vertex;
    }

    public void setVertex(WorkflowVertex vertex) {
        this.vertex = vertex;
    }

    public String getShapeSvgPath() {
        return shapeSvgPath;
    }

    public void setShapeSvgPath(String shapeSvgPath) {
        this.shapeSvgPath = shapeSvgPath;
    }

    public ShapeSvgPathEnum getShapeSvgPathEnum() {
        return shapeSvgPathEnum;
    }

    public void setShapeSvgPathEnum(ShapeSvgPathEnum shapeSvgPathEnum) {
        this.shapeSvgPathEnum = shapeSvgPathEnum;
        if(shapeSvgPathEnum!=ShapeSvgPathEnum.CUSTOM){
            this.setShapeSvgPath(shapeSvgPathEnum.value());
        }
    }

    public Color getBackgroundColor() {
        if(this.backgroundColor==null){ this.backgroundColor = this.sBackgroundColor.getColor();}
        return backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        this.sBackgroundColor = new SerializableColor(color);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Color getLabelColor() {
        if(this.labelColor==null){ this.labelColor = this.sLabelColor.getColor();}
        return labelColor;
    }

    public void setLabelColor(Color color) {
        this.labelColor = color;
        this.sLabelColor = new SerializableColor(color);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //==================================================================================================================
    public int getParamNumber() {
        return paramNumber;
    }

    public void _setParamNumber(int paramNumber) {
        this.paramNumber = paramNumber;
    }

    public VertexContactTypeEnum getType() {
        return type;
    }

    public void _setType(VertexContactTypeEnum type) {
        this.type = type;
    }

    public IBean getValue() {
        return value;
    }

    public void setValue(IBean value) {
        this.value = value;
    }

    /**
     * static method for creating VertexConnect object
     * @param posX
     * @param posY
     * @param type
     * @param number
     * @param value
     * @return
     */
    public static VertexConnect newVertexConnect(double posX, double posY, VertexContactTypeEnum type,
                                                 int number, IBean value){
        VertexConnect c = new VertexConnect();
        c.setSize(10);
        c.setLabel( type.name() + number +":"+value.getValue().getClass().getSimpleName() );
        c.setBackgroundColor(Color.YELLOW);
        c.setLabelColor(Color.BLACK);
        c.setShapeSvgPathEnum(ShapeSvgPathEnum.OVAL);
        c.setX(posX);
        c.setY(posY);
        c._setType(type);
        c._setParamNumber(number);
        c.setValue(value);
        return c;
    }
}