import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = Integer.parseInt(sc.next());
        int day1 = Integer.parseInt(sc.next());
        int day2 = Integer.parseInt(sc.next());
        int day3 = Integer.parseInt(sc.next());
        LocalDate day1inyear = LocalDate.ofYearDay(year, day1);
        LocalDate day2inyear = LocalDate.ofYearDay(year, day2);
        LocalDate day3inyear = LocalDate.ofYearDay(year, day3);
        System.out.println(day1inyear);
        System.out.println(day2inyear);
        System.out.println(day3inyear);
    }
}
