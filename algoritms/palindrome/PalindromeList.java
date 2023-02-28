import java.util.ArrayList;
import java.util.List;

public class PalindromeList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
       // list.add(1);

        isPalindrome(list);
    }
    public static void isPalindrome(List<Integer> list) {
        boolean result = true;
        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(list.get(list.size() - i - 1))){
               result = false;
            }
        }
        System.out.println(result);
    }
}
