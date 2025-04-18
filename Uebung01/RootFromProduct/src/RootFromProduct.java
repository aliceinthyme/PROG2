public class RootFromProduct {
    public static void main(String[] args) throws Exception {
        double[] numbers = new double[args.length];
        if(args.length == 0) {
            System.err.println("Please enter parameters before proceeding!");
            return;
        }
        try {
            for(int i = 0; i < args.length; i++) {
                numbers[i] = Double.parseDouble(args[i]);
            }
            System.out.println("Result: "+calculate(numbers));
        } catch(IllegalArgumentException e) {
            System.err.println("One of your parameters wasnt a number, sorry!");
            return;
        } catch(NegativeNumberException e) {
            System.err.println("At least one of your inputs was a negative number, please try again with ammended input!");
        }
    }
    public static double calculate(double[] a) throws NegativeNumberException{
        double result = 1;
        for(int i = 0; i < a.length; i++) {
            if(a[i] < 0) {
                throw new NegativeNumberException();
            }
            result *= a[i];
        }
        result = Math.sqrt(result);
        return(result);
    }
}
