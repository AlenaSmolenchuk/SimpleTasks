 import java.time.LocalTime;
import java.util.Scanner;

public class DifferenceInSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime time1 = LocalTime.parse(sc.next());
        LocalTime time2 = LocalTime.parse(sc.next());
        int time = time1.toSecondOfDay() - time2.toSecondOfDay();
        System.out.println(Math.abs(time));
    }
}
