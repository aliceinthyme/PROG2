public class StringFaculty {
    public static void main(String[] args) throws Exception {
        String[][] hold = new String[fak(args.length)][args.length];
        for(int i = 0; i < hold.length; i++) {

        }
    }
    static public int fak(int a) {  //calculate factorial
        int result = 1;
        for(int i = 1; i < a; i++) {
            result *= i;
        }
        return(result);
    }
    static public void fill(String[][] a, String b, int from, int depth, int mod) {
        for(int i = from; i < fak(a.length-depth); i++) {
            a[i][mod] = b;
        }
    }
}