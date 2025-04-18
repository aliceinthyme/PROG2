public class Equation {
    private int a, b, c;
    public Equation(int a_, int b_, int c_) {
        a = a_;
        b = b_;
        c = c_;
    }
    public Solution solve() throws UnsolvableException, NoQuadraticException {
        double d, w, x1, x2;
        if(a == 0) {
            throw new NoQuadraticException();
        }
        d = (b * b) - (4 * a * c);
        if(d < 0) {
            throw new UnsolvableException();
        }
        w = Math.sqrt(d);
        x1 = (-b+w)/(2*a);
        x2 = (-b-w)/(2*a);
        Solution Solved = new Solution(x1, x2);
        return(Solved);
    }
}
