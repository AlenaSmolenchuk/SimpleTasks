import java.util.Scanner;

public class Main {

    public static int comb(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return  comb(n-1,k) + comb(n-1,k-1);
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        System.out.println(comb(n, k));

    }


}
