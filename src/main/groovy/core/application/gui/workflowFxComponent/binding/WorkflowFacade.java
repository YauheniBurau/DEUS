package core.application.gui.workflowFxComponent.binding;

import newWorkflowFx.WorkflowIO;
import core.application.gui.workflowFxComponent.model.VertexConnect;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import core.application.gui.workflowFxComponent.model.WorkflowModel;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.workflowFxComponent.view.VertexConnect2dFx;
import core.application.gui.workflowFxComponent.view.Workflow2dFx;
import core.application.gui.workflowFxComponent.view.WorkflowEdge2dFx;
import core.application.gui.workflowFxComponent.view.WorkflowVertex2dFx;

import java.io.File;
import java.util.HashMap;

public class WorkflowFacade {
    private Workflow2dFx workflow2dFx;
    private WorkflowModel workflowModel;
    private WorkflowIO workflowIO;
    private HashMap<WorkflowVertex, WorkflowVertex2dFx> vertexMapping = new HashMap<>(); // workflowModel -> workflow2dFx mapping
    private HashMap<WorkflowEdge, WorkflowEdge2dFx> edgeMapping = new HashMap<>(); // workflowModel -> workflow2dFx mapping
    private HashMap<VertexConnect, VertexConnect2dFx> connectMapping = new HashMap<>(); // workflowModel -> workflow2dFx mapping

    private boolean isMappingFxOn = false;
    private boolean isMappingModelOn = false;
    private boolean isMappingIOOn = false;

    public WorkflowFacade(WorkflowIO workflowIO) {
        this.workflowIO = workflowIO;
        this.workflowModel = new WorkflowModel();
        this.workflow2dFx = new Workflow2dFx(this.workflowModel);
    }

    public Workflow2dFx getWorkflow2dFx() {
        return workflow2dFx;
    }

    public WorkflowModel getWorkflowModel() {
        return workflowModel;
    }

    public WorkflowIO getWorkflowIO() {
        return workflowIO;
    }

    public void addVertex(WorkflowVertex v){
        this.workflowModel.addVertex(v);
        WorkflowVertex2dFx vFx = new WorkflowVertex2dFx(v);
        this.workflow2dFx.addVertex(vFx);
        this.vertexMapping.put(v, vFx);
        for (VertexConnect2dFx vcFx: vFx.getConnects2dFx()) {
            this.connectMapping.put(vcFx.getModel(), vcFx);
        }
    }

    public void addEdge(WorkflowEdge e){
        this.workflowModel.addEdge(e);
        VertexConnect2dFx eFxFrom, eFxTo;
        eFxFrom = this.connectMapping.get(e.getFrom());
        eFxTo = this.connectMapping.get(e.getTo());
        WorkflowEdge2dFx eFx = new WorkflowEdge2dFx(e, eFxFrom, eFxTo);
        this.workflow2dFx.addEdge(eFx);
        this.edgeMapping.put(e, eFx);
    }

    /**
     * check if Vertex contains Edges, also delete all edges and only after that delete Vertex
     * @param v
     */
    public void deleteVertex(WorkflowVertex v){
        throw new RuntimeException("Not implemented");
    }

    public void deleteEdge(WorkflowEdge e){
        WorkflowEdge2dFx eFx = this.edgeMapping.get(e);
        this.workflow2dFx.removeEdge(eFx);
        this.workflowModel.removeEdge(e);
        this.edgeMapping.remove(e);
    }

    public void setCanvasSize(double sizeX, double sizeY){
        this.workflowModel.setSizeX(sizeX);
        this.workflowModel.setSizeY(sizeY);
        this.workflow2dFx.setSizeX(this.workflowModel.getSizeX());
        this.workflow2dFx.setSizeY(this.workflowModel.getSizeY());
    }

    public void load(File f){
        this.clearAll();
        this.workflow2dFx.clear();
        this.workflow2dFx.setModel(this.workflowModel);
        this.workflowIO.setFile(f);
    }

    public void save(){
    }

    public void saveAs(File f){
        this.workflowIO.setFile(f);
    }


    /**
     * clear WorkflowModel for working with new set of downloaded or new created Vertexes and Edges
     * don't make any push changes into IO File even WorkflowModel contains changes
     */
    public void clearModel() {
        this.workflowModel.getEdges().clear();
        this.workflowModel.getVertexes().clear();
        clearMapping();
    }

    /**
     * clear only Workflow2dFx for working with new set of downloaded or new created Vertexes and Edges
     * don't make any push changes into IO File even WorkflowModel contains changes
     */
    public void clearFx() {
        this.workflow2dFx.clear();
        clearMapping();
    }

    public void clearMapping() {
        this.connectMapping.clear();
        this.edgeMapping.clear();
        this.vertexMapping.clear();
    }

    public void clearAll(){
        this.clearMapping();
        this.clearFx();
        this.clearModel();
    }

}