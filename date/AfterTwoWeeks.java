
/*
    Print the date two weeks from the date you entered
*/

import java.time.LocalDate;
import java.util.Scanner;

public class AfterTwoWeeks {
    public static void main(String[] args) {
      
        LocalDate date = LocalDate.parse(sc.next());
        LocalDate afterTwoWeek = date.plusDays(14);
        System.out.println(afterTwoWeek);
    }
}
