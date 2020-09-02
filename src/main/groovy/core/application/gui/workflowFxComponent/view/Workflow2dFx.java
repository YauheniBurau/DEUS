package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.VertexConnect;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import core.application.gui.workflowFxComponent.model.WorkflowModel;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import javafx.scene.layout.Pane;
import java.util.HashMap;
import java.util.HashSet;

public class Workflow2dFx extends Pane {
    private WorkflowModel model;
    private HashSet<WorkflowVertex2dFx> vertexes = new HashSet<>();
    private HashSet<WorkflowEdge2dFx> edges = new HashSet<>();

    public Workflow2dFx(WorkflowModel model) {
        this.model = model;
        this.updateFromModel();
        this.setOnContextMenuRequested(e->{
//            ContextMenu cm = WorkflowContextMenusFxFactory.workflowContextMenu(this);
//            cm.show(this.getScene().getWindow(), e.getX(), e.getY());
        });
    }

    public WorkflowModel getModel() {
        return model;
    }

    public void setModel(WorkflowModel model) {
        this.model = model;
        this.clear();
        this.updateFromModel();
    }

    public HashSet<WorkflowVertex2dFx> getVertexes() {
        return vertexes;
    }

    public WorkflowVertex2dFx getVertex(WorkflowVertex v) {
        for( WorkflowVertex2dFx v2dFx: this.getVertexes() ) {
            if(v2dFx.getModel()==v){
                return v2dFx;
            }
        }
        return null;
    }

    public HashSet<WorkflowEdge2dFx> getEdges() {
        return edges;
    }

    public WorkflowEdge2dFx getEdge(WorkflowEdge e) {
        for( WorkflowEdge2dFx e2dFx: this.getEdges() ) {
            if(e2dFx.getModel()==e){
                return e2dFx;
            }
        }
        return null;
    }

    public double getSizeX() {
        return this.getMinWidth();
    }

    public void setSizeX(double sizeX) {
        this.setMinWidth(sizeX);
        this.setMaxWidth(sizeX);
        this.model.setSizeX(sizeX);
    }

    public double getSizeY() {
        return this.getMinHeight();
    }

    public void setSizeY(double sizeY) {
        this.setMinHeight(sizeY);
        this.setMaxHeight(sizeY);
        this.model.setSizeY(sizeY);
    }

    public void addVertex(WorkflowVertex2dFx v){
        this.getChildren().add(v);
        this.vertexes.add(v);
    }

    public void addEdge(WorkflowEdge2dFx e){
        this.getChildren().add(e);
        this.edges.add(e);
    }

    public void removeVertex(WorkflowVertex2dFx v){
        this.getChildren().remove(v);
        this.vertexes.remove(v);
    }

    public void removeEdge(WorkflowEdge2dFx e){
        this.getChildren().remove(e);
        this.edges.remove(e);
    }

    /**
     * remove all WorkflowEdge2dFx and WorkflowVertex2dFx from scene and clear sets
     */
    public void clear(){
        this.getChildren().clear();
        this.edges.clear();
        this.vertexes.clear();
    }

    public void updateToModel(){
        throw new RuntimeException("Not implemented");
    }

    public void updateFromModel(){
        HashMap<VertexConnect, VertexConnect2dFx> connects = new HashMap<>();
        WorkflowVertex2dFx vFx;
        WorkflowEdge2dFx eFx;
        VertexConnect2dFx cFxFrom, cFxTo;
        // vertexes
        for (WorkflowVertex v: model.getVertexes()) {
            vFx = getVertex(v);
            if(vFx==null){
                vFx = new WorkflowVertex2dFx(v);
                this.addVertex(vFx);
            }
            for (VertexConnect2dFx cFx: vFx.getConnects2dFx()) {
                connects.put(cFx.getModel(), cFx);
            }
        }
        // edges
        for (WorkflowEdge e: model.getEdges()) {
            eFx = getEdge(e);
            if(eFx==null) {
                cFxFrom = connects.get(e.getFrom());
                cFxTo = connects.get(e.getTo());
                eFx = new WorkflowEdge2dFx(e, cFxFrom, cFxTo);
                this.addEdge(eFx);
            }
        }
    }

}


// TODO: clear and remove

//    public ArrayList<ConnectionFX> getConnectionsFX() {
//        ArrayList<ConnectionFX> list = new ArrayList<>();
//        for(javafx.scene.Node node: this.getChildren()){
//            if(node.getClass() == ConnectionFX.class){
//                list.add((ConnectionFX)node );
//            }
//        }
//        return list;
//    }

//
//
//    public Thread getCurrentTaskThreadWorkflowFX() {
//        return currentTaskThreadWorkflowFX;
//    }
//
//    public void setCurrentTaskThreadWorkflowFX(Thread currentTaskThreadWorkflowFX) {
//        this.currentTaskThreadWorkflowFX = currentTaskThreadWorkflowFX;
//    }
//
//    /**
//     * handler for ConnectionFX dragging over WorkflowFX
//     */
//    private EventHandler<DragEvent> hOnDragOver = (e)->{
//        // for line
//        e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//        if(this.tempConnectionFX!=null && e.getTarget() instanceof WorkflowFX){
//            this.tempConnectionFX.getEnd1().setTranslateX(e.getX());
//            this.tempConnectionFX.getEnd1().setTranslateY(e.getY());
//        }
//        e.consume();
//    };

//    private ConnectionFX tempConnectionFX;
//    private Thread currentTaskThreadWorkflowFX = null;

//
//    public void setWorkflow(Workflow model) {
//        HashMap<Data, InputFX> inputsFX = new HashMap<>();
//        HashMap<Data, OutputFX> outputsFX = new HashMap<>();
//        this.getChildren().removeAll();
//        this.workflow = model;
//        this.tempConnectionFX = null;
//        this.currentTaskThreadWorkflowFX = null;
//        // init with new values from workflow model
//        this.workflow = model;
//        this.setMinSize(model.getSizeX(), model.getSizeY());
//        this.setMaxSize(model.getSizeX(), model.getSizeY());
//        LinkedList<Node> nodes = model.getNodes();
//        // create NodeFX
//        NodeFX nodeFX;
//        for(Node node: nodes){
//            nodeFX = new NodeFX(node);
//            this.addNodeFX(nodeFX);
//            nodeFX.getInputsFX().stream().forEach(e -> inputsFX.put(e.getValue(), e) );
//            nodeFX.getOutputsFX().stream().forEach(e -> outputsFX.put(e.getValue(), e) );
//        }
//        // create all connectionFX for NodeFX
//        LinkedList<IConnection> connections = model.getConnections();
//        OutputFX startFX;
//        InputFX endFX;
//        ConnectionFX connectionFX;
//        for(IConnection connection: connections) {
//            startFX = outputsFX.get(connection.getStart());
//            endFX = inputsFX.get(connection.getEnd());
//            connectionFX = new ConnectionFX().setStart(startFX).setEnd(endFX);
//            connectionFX.setConnection(connection);
//            this.addConnectionFX(connectionFX);
//        }
//        // Event for drag any new connectionFX in WorkflowFX
//        this.setOnDragOver(hOnDragOver);
//    }

//    protected ConnectionFX getTempConnectionFX() {
//        return tempConnectionFX;
//    }

//
//    public ConnectionFX createTempConnectionFX(OutputFX outputFX) {
//        CircleFX end1;
//        end1 = new CircleFX(5);
//        end1.setTranslateX( outputFX.getLocalToSceneTransform().getTx() );
//        end1.setTranslateY( outputFX.getLocalToSceneTransform().getTy() );
//        this.getChildren().add(end1);
//        this.tempConnectionFX = new ConnectionFX();
//        this.tempConnectionFX.setStart(outputFX);
//        this.tempConnectionFX.setEnd1(end1);
//        tempConnectionFX.setWorkflowFX(this);
//        this.getChildren().add(tempConnectionFX);
//        return this.tempConnectionFX;
//    }
//
//    /** +
//     * remove tempConnectionFX. it doesn't hae any representation in Model
//     */
//    public void removeTempConnectionFX() {
//        // delete form pane circle connector
//        this.getChildren().remove(tempConnectionFX.getEnd1());
//        // delete form pane ConnectionFX
//        this.getChildren().remove(tempConnectionFX);
//        // var = null, means at current moment no temp drag and drop ConnectionFX
//        this.tempConnectionFX = null;
//    }

//    public void removeNodeFX(NodeFX nodeFX){
//        // delete nodeFX and all connectionsFX from workflowFX and pane
//        LinkedList<InputFX> inputsFX = nodeFX.getInputsFX();
//        for(InputFX inputFX: inputsFX) {
//            this.removeConnectionFX(inputFX.getConnectionFX());
//        }
//        LinkedList<OutputFX> outputsFX = nodeFX.getOutputsFX();
//        for(OutputFX outputFX: outputsFX) {
//            this.removeConnectionsFX(outputFX.getConnectionsFX());
//        }
//        this.removeNodeFX(nodeFX);
//    }