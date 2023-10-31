import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class InterpolationPlot extends Application {

    public static double[] x = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
    };
    public static double[] y = {
            5, 6, 8, 10, 12, 13, 12, 10, 8, 10, 8, 11, 7, 9, 11, 10, 9, 12, 11, 6
    };

    public static double diff1(int ind1, int ind2) {
        return (y[ind2] - y[ind1]) / (x[ind2] - x[ind1]);
    }

    public static double diff2(int ind1, int ind2, int ind3) {
        return (diff1(ind1, ind2) - diff1(ind1, ind3)) / (x[ind2] - x[ind3]);
    }

    public static double f(double z, int ind1) {
        if (ind1 >= 0 && ind1 < x.length - 2) {
            return y[ind1] +
                    (z - x[ind1]) * (diff1(ind1 + 1, ind1) +
                            (z - x[ind1 + 1]) * (diff2(ind1 + 2, ind1 + 1, ind1)));
        } else {
            return 0.0;
        }
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Plot Example");

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("x");
        yAxis.setLabel("y");

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Function Plot");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        List<Double> p = new ArrayList<>();
        double z = 1;

        while (z <= 20) {
            p.add(f(z, (int) z - 2));
            series.getData().add(new XYChart.Data<>(z, p.get(p.size() - 1)));
            z += 0.25;
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
