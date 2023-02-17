//You are climbing a staircase. It takes n steps to reach the top.

//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

/* example:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

public class Climbing{
    public static void main(String[] args) {
        int n = 4;
        climbStairs(n);
    }
    public static void climbStairs(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for(int i = 0; i < n; i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        System.out.println(n3);
    }

}
