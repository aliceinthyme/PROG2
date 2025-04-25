import myMath.*;
public class Run {
    public static void main(String[] args) throws Exception {
        try {
            iterative(Integer.parseInt(args[0]));
        } catch(InvalidInputException e) {
            System.out.println("Something went wrong!");
        } catch(NumberFormatException e) {
            System.out.println("Please input a number!");
        }
    }
    public static void iterative (int a) throws InvalidInputException {
        //int prev1 = 0;
        myMath.BigInt prev1 = new myMath.BigInt(0); //0
        //int prev2 = 1;
        myMath.BigInt prev2 = new myMath.BigInt(1); //1
        //int result = 2;
        myMath.BigInt result = null; //2
        switch (a) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            default:
                for(int i = 2; i <= a; i++) {
                    result = prev1.add(prev2);  //prev1 + prev2;
                    prev1.setNumber(prev2.getNumber());
                    prev2.setNumber(result.getNumber());
                }
                System.out.println(result.getNumber());
                result.print();
        }
    }
}
