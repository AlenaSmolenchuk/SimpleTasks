import java.time.LocalDate;
import java.util.Scanner;

public class MinusThirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate date = LocalDate.parse(sc.next());
        System.out.println(date.minusYears(30));
        System.out.println(date.plusYears(30));
    }
}
