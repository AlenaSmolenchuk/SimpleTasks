package yandex;

import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countLetters = sc.nextInt();

        int[] letters = new int[countLetters];
        for (int i = 0; i<letters.length;i++){
            letters[i] = sc.nextInt();
        }

        int[] value = new int[letters.length];
        for (int i = 0; i<value.length;i++){
            value[i] = sc.nextInt();
        }
        int countLettersInLine = sc.nextInt();

        int[] line = new int[countLettersInLine];
        for (int i = 0; i<line.length;i++){
            line[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> map = new HashMap<>(countLetters);
        for (int i = 0 ; i < letters.length; i++){
            map.put(letters[i],value[i]);
        }


        result(line,map);
    }

    static void result(int[] line,HashMap<Integer,Integer> map){
       int count = 0;
        for (int i = line.length - 1 ; i > 0 ; i--){
            if (map.get(line[i]) != (map.get(line[i-1]))){
                count++;
            }
        }

        System.out.println(count);
    }

}
