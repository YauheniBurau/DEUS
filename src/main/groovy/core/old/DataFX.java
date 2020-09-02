package core.old;

import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 20.03.2019.
 */
public class DataFX extends Pane {
//    private DataDefault value = null;
//    private ScatterChart<Number, Number> chart = null;
//
//    public DataFX(DataDefault value) {
//        // 1. init
//        this.value = value;
//        int columns = this.value.getColumns();
//        int rows = this.value.getRows();
//        NumberAxis xAxis = new NumberAxis(0, columns, 1);
//        NumberAxis yAxis = new NumberAxis(-128, 127, 1);
//        this.chart = new ScatterChart<>(xAxis, yAxis);
//        xAxis.setLabel("cluster");
//        yAxis.setLabel("values");
//        this.chart.setTitle(this.value.getName());
//
//        // 2. create series for chart
//        HashMap<Integer, XYChart.Series> series = new HashMap<>();
//        HashMap<Integer, String> rowNames = this.value.getDataType().rowNames();
//        XYChart.Series serie;
//        int n=0;
//        for (String name: rowNames.values()) {
//            serie = new XYChart.Series();
//            serie.setName(name);
//            series.put(n, serie);
//            n+=1;
//        }
//        // 3. fill series with data for chart
//        for(int i=0; i<columns; i++) {
//            for(int j=0; j<rows; j++) {
//                series.get(j).getData().add( new XYChart.Data(i, this.value.getData(j,i)) );
//            }
//        }
//        // 4. add series data to Chart
//        for (XYChart.Series s: series.values()) {
//            this.chart.getData().add(s);
//        }
//
//        this.getChildren().add(this.chart);
//    }
}
