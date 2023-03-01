/*
    Describe a method for sorting words in a string. String str = "Strings are constant; their values cannot be changed after they are created."
    
    Sort order:
    1) in alphabetical order
    2) increasing the number of characters in words
*/

import java.util.Arrays;

public class Sort  {
    public static void main(String[] args) {
        String str =  "Strings are constant; their values cannot be changed after they are created."
                .replace(";"," ")
                .replace("."," ")
                .toLowerCase();
        String[] str1 = str.split(" ");
        sortWords(str1);


    }

    public static String sortWords(String[] str1) {
        Arrays.sort(str1);
        for (int i = 0; i < str1.length; i++)
           System.out.print(str1[i] + " ");

        System.out.println();

        Arrays.stream(str1)
                .sorted((i1,i2) -> Integer.compare(i1.length(),i2.length()))
                .forEach(System.out::println);


        return String.join(" ",str1);
            }
        }






