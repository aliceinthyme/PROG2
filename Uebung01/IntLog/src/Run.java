public class Run {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println(log(Long.parseLong(args[0])));
        } catch(IllegalArgumentException e) {
            System.err.println("Your input either exceeds a 64 bit long integer, is not compatible with  an integer or is <= 0");
        } catch(IndexOutOfBoundsException e) {
            System.err.println("No input provided");
        }
    }
    public static long log(long n) throws IllegalArgumentException {
        if(n <= 0) {
            throw new IllegalArgumentException();
        }
        long result = 0;
        while (n != 0) {
            n = n >>> 1;
            result++;
        }
        assert n == 0;
        assert result >= 0;
        return(result);
    }
}
