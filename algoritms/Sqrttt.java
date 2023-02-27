/*
  
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    The returned integer should be non-negative as well.

    You must not use any built-in exponent function or operator.

*/

class Sqrttt {
    public int mySqrt(int x) {
       if (x < 2) return x;
        int i=1;
        while (i*i<=x){
            if(i*i<=0) break;
            i++;
        }
        return --i;
    }
}
