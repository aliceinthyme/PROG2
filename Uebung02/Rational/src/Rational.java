public class Rational {
    private int num, denom;
    //constructors
    Rational() {
        num = 0;
        denom = 1;
    }
    Rational(int n) {
        num = n;
        denom = 1;
    }
    Rational(int n, int d) {
        if(d < 0) {
            d = -d;
            n = -n;
            //System.out.println("HI! "+n+" "+d);   //proves that 1 - 6 = 1/x is outputted as -1/5 and not 1/-5
            assert d > 0;
        }
        if(d == 0) {
            new ArithmeticException();
        }
        num = n;
        denom = d;
        //System.out.println(num+" "+denom+" Hi!");    //proves that 1 - 6 = 1/x is outputted as -1/5 and not 1/-5
    }
    Rational(Rational r) {
        num = r.num;
        denom = r.denom;
    }
    //getters/setters
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getDenom() {
        return denom;
    }
    public void setDenom(int denom) {
        this.denom = denom;
    }
    //methods
    public String text() {
        if (getDenom() == 1)
        return "" + getNum();
        return getNum() + "/" + getDenom();
    }
    public Rational invert() {
            Rational a = new Rational(this.denom, this.num);
            return(a);
    }
    public Rational add(Rational r) {
        int top1 = r.denom*this.num;
        int top2 = r.num*this.denom;
        Rational a = new Rational((top1+top2), (r.denom*this.denom));
        return(a);
    }
    public Rational sub(Rational r) {
        int top1 = r.denom*this.num;
        int top2 = r.num*this.denom;
        Rational a = new Rational((top1-top2), (r.denom*this.denom));
        return(a);
    }
    public Rational mult(Rational r) {
        Rational a = new Rational((r.num*this.num), (r.denom*this.denom));
        return(a);
    }
    public Rational div(Rational r) {
        Rational a = r.invert();
        Rational b = new Rational((this.num*a.num), (this.denom*a.denom));
        return(b);
    }
    public Rational reduce() {
        int temp;
        int a = this.num;
        int b = this.denom;
        temp = a % b;
        while(temp != 0) {
            a = b;
            b = temp;
            temp = a % b;
        }
        this.setNum(this.num/b);
        this.setDenom(this.denom/b);
        return this;
    }
}
