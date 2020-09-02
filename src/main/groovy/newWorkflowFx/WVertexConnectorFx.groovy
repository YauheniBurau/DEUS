package newWorkflowFx

import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.CubicCurve

class WVertexConnectorFx extends CubicCurve{
    WVertexContactFx from = null
    WVertexContactFx to = null

    WVertexConnectorFx(double x, double y) {
        this.setCurveFill(Color.LIGHTGREEN)
        this.setStartXY(x, y)
        this.setEndXY(x, y)
        this.attachControlXY1AndXY2()
    }

    WVertexConnectorFx(WVertexContactFx c1, WVertexContactFx c2) {
        this.from = c1
        this.to = c2
        this.setCurveFill(Color.LIGHTGREEN)
        this.attachStartXY(c1)
        this.attachEndXY(c2)
        this.attachControlXY1AndXY2()
    }

    void setCurveFill(Paint paint) {
        this.setFill(paint)
        this.setStroke(paint)
        this.setFill(paint)
        this.setStroke(paint)
        this.setStrokeWidth(4)
    }

    void setStartXY(double posX, double posY){
        this.setStartX(posX)
        this.setStartY(posY)
    }

    void attachControlXY1AndXY2(){
        this.controlX1Property().bind(this.endXProperty())
        this.controlY1Property().bind(this.startYProperty())
        this.controlX2Property().bind(this.startXProperty())
        this.controlY2Property().bind(this.endYProperty())
    }

    void setEndXY(double posX, double posY){
        this.setEndX(posX)
        this.setEndY(posY)
    }

    void attachStartXY(WVertexContactFx c){
        this.setFrom(c)
        Pane cFx = c.getContactFx()
        this.startXProperty().bind(cFx.layoutXProperty()
                .add(cFx.widthProperty().divide(2))
        )
        this.startYProperty().bind(cFx.layoutXProperty()
                .add(cFx.heightProperty().divide(2))
        )
    }

    void attachEndXY(WVertexContactFx c){
        this.setTo(c)
        Pane cFx = c.getContactFx()
        this.endXProperty().bind(cFx.layoutXProperty()
                .add(cFx.widthProperty().divide(2))
        )
        this.endYProperty().bind(cFx.layoutXProperty()
                .add(cFx.heightProperty().divide(2))
        )
    }
}