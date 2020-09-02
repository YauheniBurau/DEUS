package core.application.gui.workflowFxComponent.model;

import core.application.serializable.SerializableColor;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class WorkflowEdge implements Serializable {
    private static final long serialVersionUID = 1L;
    private VertexConnect from = null;
    private VertexConnect to = null;
    private String name = "data";
    private boolean isVisibleText = true;
    private boolean isVisibleArrow = true;
    private transient Color textColor = Color.BLACK;
    private SerializableColor sTextColor;
    private transient Color edgeColor = Color.BLACK;
    private SerializableColor sEdgeColor;

    public WorkflowEdge(VertexConnect from, VertexConnect to) {
        this.from = from;
        this.to = to;
    }

    public VertexConnect getFrom() {
        return from;
    }

    public void setFrom(VertexConnect from) {
        this.from = from;
    }

    public VertexConnect getTo() {
        return to;
    }

    public void setTo(VertexConnect to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisibleText() {
        return isVisibleText;
    }

    public void setVisibleText(boolean visibleText) {
        isVisibleText = visibleText;
    }

    public boolean isVisibleArrow() {
        return isVisibleArrow;
    }

    public void setVisibleArrow(boolean visibleArrow) {
        isVisibleArrow = visibleArrow;
    }

    public Color getTextColor() {
        if(this.textColor==null){ this.textColor = this.sTextColor.getColor();}
        return textColor;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
        this.sTextColor = new SerializableColor(color);
    }

    public Color getEdgeColor() {
        if(this.edgeColor==null){ this.edgeColor = this.sEdgeColor.getColor();}
        return edgeColor;
    }

    public void setEdgeColor(Color color) {
        this.edgeColor = color;
        this.sEdgeColor = new SerializableColor(color);
    }

    /**
     * create new object of WorkflowEdge
     * @param from
     * @param to
     * @return
     */
    public static WorkflowEdge newDefault(VertexConnect from, VertexConnect to){
        WorkflowEdge e = new WorkflowEdge(from, to);
        e.setEdgeColor(Color.BLACK);
        e.setTextColor(Color.BLACK);
        e.setVisibleArrow(true);
        e.setVisibleText(true);
        return e;
    }


}