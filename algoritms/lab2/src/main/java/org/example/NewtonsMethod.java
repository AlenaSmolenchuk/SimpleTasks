package org.example;

import java.util.Scanner;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularMatrixException;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;

public class NewtonsMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальные значения:");

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double z = Double.parseDouble(scanner.nextLine());

        System.out.print("Введите eps: ");
        double eps = Double.parseDouble(scanner.nextLine());

        double dx = 1.0;
        double dy = 1.0;
        double dz = 1.0;
        int i = 1;

        while (Math.max(Math.abs(dx), Math.max(Math.abs(dy), Math.abs(dz))) > eps) {
            RealMatrix m1 = new Array2DRowRealMatrix(new double[][]{
                    {f1x(x, y, z), f1y(x, y, z), f1z(x, y, z)},
                    {f2x(x, y, z), f2y(x, y, z), f2z(x, y, z)},
                    {f3x(x, y, z), f3y(x, y, z), f3z(x, y, z)}
            });

            RealVector v1 = new ArrayRealVector(new double[]{
                    -f1(x, y, z), -f2(x, y, z), -f3(x, y, z)
            });

            RealVector a;

            try {
                LUDecomposition lu = new LUDecomposition(m1);
                a = lu.getSolver().solve(v1);
            } catch (SingularMatrixException | MathArithmeticException |
                     MaxCountExceededException | NullArgumentException e) {
                System.out.println("Ошибка: матрица сингулярна или невозможно решить систему уравнений.");
                return;
            }

            dx = a.getEntry(0);
            dy = a.getEntry(1);
            dz = a.getEntry(2);

            x += dx;
            y += dy;
            z += dz;

            System.out.println("Итерация №" + i);
            System.out.println("x = " + x + "; y = " + y + "; z = " + z);
            System.out.println("-----");
            i++;
        }

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        System.out.println("f1(x, y, z) = " + f1(x, y, z));
        System.out.println("f2(x, y, z) = " + f2(x, y, z));
        System.out.println("f3(x, y, z) = " + f3(x, y, z));
    }

    public static double f1(double x, double y, double z) {
        return (x * x) - 3.7 * (y * y) + 0.502;
    }

    public static double f2(double x, double y, double z) {
        return -2.1 * x * y + 0.5 * (z * z) - (x * x) - 0.287;
    }

    public static double f3(double x, double y, double z) {
        return 0.33 * (y * y * y) + z * (x * x) - 0.02388;
    }

    public static double f1x(double x, double y, double z) {
        return 2 * x;
    }

    public static double f1y(double x, double y, double z) {
        return -7.4 * y;
    }

    public static double f1z(double x, double y, double z) {
        return 0;
    }

    public static double f2x(double x, double y, double z) {
        return -2.1 * y - 2 * x;
    }

    public static double f2y(double x, double y, double z) {
        return -2.1 * x;
    }

    public static double f2z(double x, double y, double z) {
        return z;
    }

    public static double f3x(double x, double y, double z) {
        return 2 * x * z;
    }

    public static double f3y(double x, double y, double z) {
        return 0.99 * (y * y);
    }

    public static double f3z(double x, double y, double z) {
        return (x * x);
    }
}
