package core.old;


/**
 * Created by anonymous on 08.10.2018.
 */
public class HelperFX {

//    public DataBuffImgFX(Data<BuffPicImg> data) {
//        super(data);
//        ImageView imageView = new ImageView();
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setPrefSize(640, 480);
//        scrollPane.setFitToWidth(true);
//        scrollPane.setFitToHeight(true);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        imageView.setPreserveRatio(true);
//        scrollPane.setContent(imageView);
//        this.getChildren().add(scrollPane);
////        this.getChildren().add(new ZoomableScrollPaneFX(imageView));
//        BufferedImage value = this.getData().getValue();
//        // TODO: repair
//        //        if(value !=null) {
////            Image image = SwingFXUtils.toFXImage(value, null);
////            imageView.setImage(image);
////        }
//    }


//    // TODO: make nodeFX draggable that way via dragboard
//    public static void makeNodeFxDraggable(WorkflowPaneFX workflowPaneFX, NodeFX nodeFX, javafx.scene.Node source) {
//
//        source.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                Dragboard db = nodeFX.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                //content.put(source.getText());
//                //db.setContent(content);
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragOver(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");

//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragDropped(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
////                /* if there is a string data on dragboard, read it and use it */
////                Dragboard db = event.getDragboard();
//                boolean success = true;
////                if (db.hasString()) {
////                    target.setText(db.getString());
////                    success = true;
////                }
////                /* let the source know whether the string was successfully
////                 * transferred and used */
//                event.setDropCompleted(success);
//                event.consume();
//            }
//        });

//        nodeFX.setOnDragDone(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                    //source.setText("");
//                }
//                event.consume();
//            }
//        });
//    }

}

