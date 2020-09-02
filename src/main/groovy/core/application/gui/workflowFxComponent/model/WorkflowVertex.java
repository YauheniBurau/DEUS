package core.application.gui.workflowFxComponent.model;

import core.application.gui.factoryFx.WritableImageFxFactory;
import core.application.gui.workflowFxComponent.bean.BeanFactory;
import core.application.gui.workflowFxComponent.bean.IBean;
import core.application.gui.workflowFxComponent.classLoader.ClassLoader;
import core.application.gui.workflowFxComponent.param.ImageSelect;
import core.application.gui.workflowFxComponent.param.MethodSelect;
import core.application.gui.workflowFxComponent.reflection.Reflection;
import core.application.serializable.SerializableColor;
import core.application.serializable.SerializableImage;
import core.application.serializable.SerializableMethod;
import javafx.scene.paint.Color;
import newWorkflowFx.ShapeSvgPathEnum;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class WorkflowVertex implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "";
    private double nameRelativeX = 0.0;
    private double nameRelativeY = 0.0;

    private String algorithmName = "";
    private String algorithmDescription = "";

    private transient MethodSelect staticMethod = null;
    private SerializableMethod sStaticMethod;

    private IBean vertexDataBean = null;
    private VertexDataBeanTypeEnum vertexDataBeanType = VertexDataBeanTypeEnum.EMPTY;

    private transient Color backgroundColor = Color.BLACK;
    private SerializableColor sBackgroundColor;
    private transient ImageSelect backgroundImage;
    private SerializableImage sBackgroundImage;
    private boolean isShownBackgroundImage = false;

    private ShapeSvgPathEnum shapeSvgPathEnum;
    private String shapeSvgPath = "";
    private double sizeX = 0;
    private double sizeY = 0;
    private double minSizeX = 0;
    private double minSizeY = 0;
    private double layoutX = 0;
    private double layoutY = 0;

    private HashSet<VertexConnect> connects = new HashSet<>();

    public WorkflowVertex() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNameRelativeX() {
        return nameRelativeX;
    }

    public void setNameRelativeX(double nameRelativeX) {
        this.nameRelativeX = nameRelativeX;
    }

    public double getNameRelativeY() {
        return nameRelativeY;
    }

    public void setNameRelativeY(double nameRelativeY) {
        this.nameRelativeY = nameRelativeY;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
    }

    public MethodSelect getStaticMethod() {
        if(this.staticMethod==null && this.sStaticMethod!=null){
            this.staticMethod = new MethodSelect(this.sStaticMethod.getMethod());
        }
        return this.staticMethod;
    }

    public void setStaticMethod(MethodSelect methodSelect) {
        this.sStaticMethod = new SerializableMethod(methodSelect.getValue());
        this.staticMethod = methodSelect;
        // also from List<VertexConnect> from method and add all input and output params of method
        this.updateStaticMethodConnects();
    }

    public void setStaticMethod(String fullClassName) {
        // also update StaticMethod
        if(ClassLoader.isFoundClass(fullClassName)) {
            Class<?> clazz = ClassLoader.loadClass(fullClassName);
            Collection<Method> sM = Reflection.getClassStaticMethods(clazz);
            if(sM.size()>0) {
                this.setStaticMethod(new MethodSelect(sM.iterator().next()));
            }
        }
    }

    public IBean getVertexDataBean() {
        return this.vertexDataBean;
    }

    public void setVertexDataBean(IBean vertexDataBean) {
        this.vertexDataBean = vertexDataBean;
        this.updateDataBeanConnect();
    }

    public VertexDataBeanTypeEnum getVertexDataBeanType() {
        return vertexDataBeanType;
    }

    public void setVertexDataBeanType(VertexDataBeanTypeEnum vertexDataBeanType) {
        this.vertexDataBeanType = vertexDataBeanType;
        this.updateDataBeanConnect();
    }

    public Color getBackgroundColor() {
        if(this.backgroundColor==null){ this.backgroundColor = this.sBackgroundColor.getColor();}
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.sBackgroundColor = new SerializableColor(backgroundColor);
    }

    public ImageSelect getBackgroundImage() {
        if(this.backgroundImage==null && this.sBackgroundImage!=null){
            this.backgroundImage = new ImageSelect(this.sBackgroundImage.getImage());
        }
        return backgroundImage;
    }

    public void setBackgroundImage(ImageSelect backgroundImage) {
        this.backgroundImage = backgroundImage;
        this.sBackgroundImage = new SerializableImage(backgroundImage.getValue());
    }

    public boolean isShownBackgroundImage() {
        return isShownBackgroundImage;
    }

    public void setShownBackgroundImage(boolean shownBackgroundImage) {
        isShownBackgroundImage = shownBackgroundImage;
    }

    public ShapeSvgPathEnum getShapeSvgPathEnum() {
        return shapeSvgPathEnum;
    }

    public void setShapeSvgPathEnum(ShapeSvgPathEnum shapeSvgPathEnum) {
        this.shapeSvgPathEnum = shapeSvgPathEnum;
        if(shapeSvgPathEnum!= ShapeSvgPathEnum.CUSTOM){
            this.setShapeSvgPath(shapeSvgPathEnum.value());
        }
    }

    public String getShapeSvgPath() {
        return shapeSvgPath;
    }

    public void setShapeSvgPath(String shapeSvgPath) {
        this.shapeSvgPath = shapeSvgPath;
    }

    public double getMinSizeX() {
        return minSizeX;
    }

    public void setMinSizeX(double minSizeX) {
        this.minSizeX = minSizeX;
    }

    public double getMinSizeY() {
        return minSizeY;
    }

    public void setMinSizeY(double minSizeY) {
        this.minSizeY = minSizeY;
    }

    public double getSizeX() {
        return sizeX;
    }

    public void setSizeX(double sizeX) {
        if(sizeX>=this.minSizeX) {
            this.sizeX = sizeX;
        }else{
            this.sizeX = this.minSizeX;
        }
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        if(sizeY>=this.minSizeY) {
            this.sizeY = sizeY;
        }else{
            this.sizeY = this.minSizeY;
        }
    }

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    public void setLayoutXY(double layoutX, double layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public HashSet<VertexConnect> selectVertexConnects() {
        return connects;
    }

    public VertexConnect[] selectVertexConnects(VertexContactTypeEnum type) {
        int size = this.countVertexConnects(type);
        VertexConnect[] connects = new VertexConnect[size];
        for (int i = 0; i<size; i++){
            connects[i] = this.selectVertexConnect(i, type);
        }
        return connects;
    }

    public void addVertexConnect(VertexConnect connect) {
        this.connects.add(connect);
        connect.setVertex(this);
    }

    /**
     * update all VertexConnects from vertex staticMethod
     */
    public void updateStaticMethodConnects() {
        this.connects = new HashSet<>();
        if(this.getStaticMethod()!=null) {
            Class<?>[] parameterTypes = this.getStaticMethod().getValue().getParameterTypes();
            int size = parameterTypes.length;
            int n = 0;
            for (Class<?> paramType : parameterTypes) {
                this.addVertexConnect(VertexConnect.newVertexConnect(
                        -1, -1 + (2 / (double) (size + 1)) * (n + 1),
                        VertexContactTypeEnum.METHOD_IN, n, BeanFactory.newFromValueClass(paramType)));
                n += 1;
            }
            // OUTPUT CONNECT
            Class<?> retType = this.staticMethod.getValue().getReturnType();
            if(retType != void.class) {
                this.addVertexConnect(VertexConnect.newVertexConnect(
                        +1, -0.5,
                        VertexContactTypeEnum.METHOD_OUT, 0, BeanFactory.newFromValueClass(retType)));
            }
        }
    }

    public void updateDataBeanConnect(){
        int n;
        if(this.vertexDataBean!=null) {
            switch(this.vertexDataBeanType){
                case EDIT:
                    n = this.countVertexConnects(VertexContactTypeEnum.METHOD_OUT);
                    this.deleteVertexConnects(VertexContactTypeEnum.PARAM_EDIT);
                    this.addVertexConnect(VertexConnect.newVertexConnect(+1, +0.5, VertexContactTypeEnum.PARAM_EDIT, n,
                        this.vertexDataBean));
                    break;
                case VIEW:
                    n = this.countVertexConnects(VertexContactTypeEnum.METHOD_IN);
                    this.deleteVertexConnects(VertexContactTypeEnum.PARAM_VIEW);
                    this.addVertexConnect(VertexConnect.newVertexConnect(-1, -0.9, VertexContactTypeEnum.PARAM_VIEW, n,
                        this.vertexDataBean));
                    break;
                case EMPTY: break;

            }
        }
    }

    public VertexConnect selectVertexConnect(int number, VertexContactTypeEnum type){
        VertexConnect vc = null;
        for (VertexConnect c: this.selectVertexConnects()) {
            if(c.getParamNumber()==number && c.getType()==type){
                vc = c;
                break;
            }
        }
        return vc;
    }

    public void deleteVertexConnects(VertexContactTypeEnum type){
        Collection<VertexConnect> toDelete = new ArrayList<>();
        for (VertexConnect c: this.selectVertexConnects()) {
            if(c.getType()==type){
                toDelete.add(c);
            }
        }
        this.connects.removeAll(toDelete);
    }

    private int countVertexConnects(VertexContactTypeEnum type){
        int n = 0;
        for (VertexConnect c: this.selectVertexConnects()) {
            if(c.getType()==type){
                n+=1;
            }
        }
        return n;
    }

    /**
     * static method for creating object WorkflowVertex
     * @param layoutX
     * @param layoutY
     * @param fullClassName
     * @param vertexDataBean
     * @return
     */
    public static WorkflowVertex newVertex(double layoutX, double layoutY, String fullClassName,
                                           IBean vertexDataBean, VertexDataBeanTypeEnum vertexDataBeanType){
        WorkflowVertex v = new WorkflowVertex();
        v.setName("Vertex");
        v.setNameRelativeX(-0.6);
        v.setNameRelativeY(-1.2);
        v.setAlgorithmName("no algorithm name");
        v.setAlgorithmDescription("no algorithm description");
        v.setShapeSvgPathEnum(ShapeSvgPathEnum.DIAGONAL_RECTANGLE);
        v.setBackgroundColor(Color.BLUE);
        v.setBackgroundImage(new ImageSelect(WritableImageFxFactory.create(128, 128, Color.BLACK)));
        v.setSizeX(290);
        v.setSizeY(75);
        v.setMinSizeX(150);
        v.setMinSizeY(75);
        v.setLayoutX(layoutX);
        v.setLayoutY(layoutY);
        v.setStaticMethod(fullClassName);
        v.setVertexDataBean(vertexDataBean);
        v.setVertexDataBeanType(vertexDataBeanType);
        return v;
    }
}

// TODO: remove later


//    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel
//    /**
//     * returb state of algo
//     * @return
//     */
//    public AlgorithmStateEnum getState() {
//        return state;
//    }
//
//    /**
//     * set state to algo node and for every output
//     * @param state
//     */
//    public void setState(AlgorithmStateEnum state) {
//        this.state = state;
//        for (Data output: this.getOutputs()) {
//            output.setState(state);
//        }
//    }
//
//    /**
//     * must be overriden, and have to contain main logic of processing inputs and what to send to outputs
//     * @return
//     */
//    public abstract Boolean onProcess();
//
//    /**
//     * check all inputs, and if at least one of them not has status "SUCCESS" - then result - false, algo is not ready
//     * @return
//     */
//    public boolean isReadyToProcess(){
//        boolean isReady = true;
//        for (Data input: this.getInputs()) {
//            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
//                isReady = false;
//                break;
//            }
//        }
//        return isReady;
//    }

//    public void signalCountPrevious(){
//        for (Data input: this.inputs) {
//            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
//                new RunProcess(input.getConnection(0).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void signalCountNext(){
//        for (Data output: this.outputs) {
//            ArrayList<IConnection> conns = output.getConnections();//. e.getEnd().getAlgorithm().runProcess();
//            for (int i = 0; i < conns.size() ; i++) {
//                new RunProcess(conns.get(i).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void runProcess(){
//        boolean result;
//        if( isReadyToProcess() == true ){
//            result = this.onProcess();
//            if(result == true){ // send to outputs signal that node is processed
//                this.setState(AlgorithmStateEnum.SUCCESS);
//                signalCountNext();
//            }
//        }else{ // send signals to all inputs connected nodes
//            signalCountPrevious();
//        }
//    }
