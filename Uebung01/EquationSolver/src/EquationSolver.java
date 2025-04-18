public class EquationSolver {
    public static void main(String[] args) throws Exception {
        if(args.length != 3) {  //checks for arg length
            System.out.println("Call: java EquationSolver a b c");
        } else {
            int a, b, c;
            Solution Result = null;
            try {   //variable assignment block, checks for valid args
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
                c = Integer.parseInt(args[2]);
            } catch (IllegalArgumentException e) {
                System.err.println("Illegal Argument: a, b or c illegal double value!");    //prints reason for exit to err then exits program
                return;
            }
            try {
                Equation Current = new Equation(a, b, c);
                Result = Current.solve();
                System.out.println("Solution x1: "+Result.getX1()+" Solution x2: "+Result.getX2());
            } catch (NoQuadraticException e) {
                System.err.println("Not quadratic: a = 0 not allowed"); //prints reason for exit to err then exits program
            } catch (UnsolvableException e) {
                System.out.println("Unsolvable: b*b-4*a*c < 0");    //sysout since its technically also a "result" to the equation
            }

        }
    }
}
