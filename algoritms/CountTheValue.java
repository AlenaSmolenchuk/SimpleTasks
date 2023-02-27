/*

    Implement a method that takes an integer value and two lists of numbers. 
    It must check if the value occurs the same number of times in both sequences.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elem = sc.nextInt();
        List<Integer> list1 = new ArrayList<>(7);
        for (int i = 0; i < list1.size();i++){
            list1.add(sc.nextInt());
        }
        
        List<Integer> list2 = new ArrayList<>(6);
        for (int i = 0; i < list2.size();i++){
            list2.add(sc.nextInt());
        }
        checkTheSameNumberOfTimes(elem,list1,list2);
    }
     static boolean checkTheSameNumberOfTimes(int elem,
                                           List<Integer> list1,
                                           List<Integer> list2) {
        int count1 = 0;
        int count2 = 0;
      for (int i = 0; i < list1.size(); i++){
          if (elem == list1.get(i)){
              count1++;
          }
      }
         for (int i = 0; i < list2.size(); i++){
             if (elem == list2.get(i)){
                 count2++;
             }
         }

         if (count1 == count2) return true;
         else return false;
    }
}
