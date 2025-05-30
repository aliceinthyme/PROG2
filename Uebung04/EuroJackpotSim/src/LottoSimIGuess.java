import java.util.ArrayList;
import java.util.Collections;

public class LottoSimIGuess {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> fiftyBalls = new ArrayList<Integer>();
        ArrayList<Integer> tenBalls = new ArrayList<Integer>();
        ArrayList<Integer> resultA = new ArrayList<Integer>();
        ArrayList<Integer> resultB = new ArrayList<Integer>();
        //fill array lists
        for(int i = 1; i <= 50; i++) {
            fiftyBalls.add(i);
        }
        for(int i = 1; i <= 10; i++) {
            tenBalls.add(i);
        }
        //pick out numbers
        for(int i = 0; i < 5; i++) {
            int location = (int)(Math.random()*1000) % fiftyBalls.size();
            resultA.add(fiftyBalls.get(location));
            fiftyBalls.remove(location);
        }
        //sort numbers
        Collections.sort(resultA);
        //pick out more numbers
        for(int i = 0; i < 2; i++) {
            int location = (int)(Math.random()*1000) % tenBalls.size();
            resultB.add(tenBalls.get(location));
            tenBalls.remove(location);
        }
        //sort more numbers
        Collections.sort(resultB);
        //output sorted array lists
        resultA.forEach(System.out::println);
        resultB.forEach(System.out::println);
    }
}
