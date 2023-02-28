public class SolutionSecond {
    public static void main(String[] args) {
        String a = "1010";
        String b = "11010" ;

            addBinary(a, b);
        }

    public static void addBinary(String a, String b) {

        int A10 = Integer.parseInt(a,2);
        int B10 = Integer.parseInt(b,2);
        int Sum = A10 + B10;
        String Answer = Integer.toBinaryString(Sum);

        System.out.println(Answer);
    }
}
