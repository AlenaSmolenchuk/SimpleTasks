public class Fibonachi {
    public static void main(String[] args) {
        int n = 100;
        int t1 = 1;
        int t2 = 2;
        for(int i = 1; i <= n;++i ){
            System.out.println(t1 + " + ");
            int sum = t1 + t2; t1 = t2;
            t2 = sum;
        }
    }
}
