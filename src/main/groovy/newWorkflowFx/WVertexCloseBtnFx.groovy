package newWorkflowFx


import javafx.scene.control.Button
import javafx.scene.layout.Border
import javafx.scene.layout.BorderStroke
import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.layout.BorderWidths
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.shape.SVGPath

class WVertexCloseBtnFx extends Button{

    WVertexCloseBtnFx(){
        this.setText("X")
        this.setOnAction(e->{})
        SVGPath path = new SVGPath()
        path.setContent(ShapeSvgPathEnum.OVAL.value())
        this.setShape(path)
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) )
    }

}
