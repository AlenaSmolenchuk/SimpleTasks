import java.util.Scanner;

public class HalfIntervalMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите левую границу интервала (a): ");
        double a = readDouble(scanner);

        System.out.print("Введите правую границу интервала (b): ");
        double b = readDouble(scanner);

        System.out.print("Введите точность (epsilon): ");
        double epsilon = readDouble(scanner);

        double root = findRoot(a, b, epsilon);
        System.out.println("Корень: " + root);
        System.out.println("Значение функции: " + f(root));

        scanner.close();
    }

    public static double readDouble(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            System.out.println("Ошибка ввода. Пожалуйста, используйте запятую в качестве разделителя для десятичных чисел.");
            System.exit(1);
            return 0.0;
        }
    }

    // Функция 7.22x^5 - 4x^2 + 10.7x - 100.2
    public static double f(double x) {
        return 7.22 * Math.pow(x, 5) - 4 * Math.pow(x, 2) + 10.7 * x - 100.2;
    }

    // Метод половинного деления
    public static double findRoot(double a, double b, double epsilon) {
        int iteration = 0;
        while (Math.abs(f(b)) > epsilon) {
            double x = (a + b) / 2;
            double fa = f(a);
            double fx = f(x);

            if (fa * fx < 0) {
                b = x;
            } else {
                a = x;
            }

            iteration++;
            System.out.println("Итерация " + iteration + ": х = " + x + ", f(x) = " + fx);
        }
        return (a + b) / 2;
    }
}
