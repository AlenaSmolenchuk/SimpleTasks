// This solution is for big numbers
class SolutionFirst {
    public String addBinary(String a, String b) {
        BigInteger A = new BigInteger(a,2);
        BigInteger B = new BigInteger(b,2);
        BigInteger add = A.add(B);
        return add.toString(2);
    }
}
