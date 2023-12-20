import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class TrigonometricSeries extends Application {
    public static void main(String[] args) {
        launch(args); 
    }

    @Override
    public void start(Stage stage) {

        List<Integer> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        List<Double> X = new ArrayList<>();
        List<Double> Y = new ArrayList<>();

        int[] xValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        double[] yValues = {5, 6, 8, 10, 12, 13, 12, 10, 8, 10, 8, 11, 7, 9, 11, 10, 9, 12, 11, 6};

        for (int i = 0; i < 20; i++) {
            x.add(xValues[i]);
            y.add(yValues[i]);
            X.add(2 * Math.PI * (i + 1) / 21);
        }

        double alpha0 = 0;
        for (int i = 0; i < 20; i++) {
            alpha0 += 1.0 / 21 * y.get(i);
        }

        double[] alpha = new double[7];
        double[] beta = new double[7];

        for (int k = 1; k <= 6; k++) {
            alpha[k] = 0;
            beta[k] = 0;

            for (int i = 0; i < 20; i++) {
                alpha[k] += 2.0 / 21 * y.get(i) * Math.cos(k * X.get(i));
                beta[k] += 2.0 / 21 * y.get(i) * Math.sin(k * X.get(i));
            }
        }

        for (int i = 0; i < 20; i++) {
            double yi = alpha0;

            for (int k = 1; k <= 6; k++) {
                yi += alpha[k] * Math.cos(k * X.get(i)) + beta[k] * Math.sin(k * X.get(i));
            }

            Y.add(yi);
        }

        double sumOfSquares = 0;
        for (int i = 0; i < 20; i++) {
            sumOfSquares += Math.pow(y.get(i) - Y.get(i), 2);
        }

        System.out.println("Сумма квадратов отклонений = " + sumOfSquares);

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("y");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Тригонометрический ряд");

        XYChart.Series<Number, Number> originalSeries = new XYChart.Series<>();
        originalSeries.setName("Original Data");

        XYChart.Series<Number, Number> fittedSeries = new XYChart.Series<>();
        fittedSeries.setName("Fitted Data");

        for (int i = 0; i < x.size(); i++) {
            originalSeries.getData().add(new XYChart.Data<>(x.get(i), y.get(i)));
            fittedSeries.getData().add(new XYChart.Data<>(x.get(i), Y.get(i)));
        }

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(originalSeries, fittedSeries);

        stage.setScene(scene);
        stage.show();
    }
}
