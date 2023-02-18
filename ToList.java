//The array-form of an integer num is an array representing its digits in left to right order.
//For example, for num = 1321, the array form is [1,3,2,1].
//Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

import java.util.ArrayList;
import java.util.Collections;

class ToList {
     public List<Integer> addToArrayForm(int[] num, int k) {
            ArrayList<Integer> list = new ArrayList();
            for(int i = num.length - 1; i>= 0 || k>0; i-- ){
                if(i >= 0){
                    list.add((num[i] + k) % 10);
                    k = (num[i] + k) / 10;
                }else{
                    list.add(k % 10);
                    k = k/10;
                }
            }
            return Collections.reverse(list);
        }
}
