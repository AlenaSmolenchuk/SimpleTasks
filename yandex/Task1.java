package yandex;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countOfSk = sc.nextInt();
        int kg = sc.nextInt();
        int min = sc.nextInt();

        int[] kgAll = new int[countOfSk];
        for (int i = 0; i<kgAll.length;i++){
            kgAll[i] = sc.nextInt();
        }

        metod(kg,kgAll,min);
    }

    static void metod(int kg,int[] kgAll,int min) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= kgAll.length - 1; i++) {

            if (Math.abs(kg - kgAll[i]) + Math.abs(kg - kgAll[i]) <= min) {
                count++;
               list.add(i+1);
            }
        }
        System.out.println(count);
        System.out.println(list.toString()
                .replaceAll("^\\[|\\]$","")
                .replaceAll(",",""));

    }
}
