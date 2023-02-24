/*
    Implement the method areSibling that checks if the files have the same parent.

    It should take two files and return true if the files have the same parent and false otherwise.

*/

import java.io.File;
import java.util.Scanner;

public class Siblings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File f1 = new File(sc.next());
        File f2 = new File(sc.next());
        areSiblings(f1,f2);
    }
    public static void areSiblings(File f1, File f2) {
        boolean result = false;
        if(f1.getParent().toString().equals(f2.getParent().toString())) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);
    }
}
