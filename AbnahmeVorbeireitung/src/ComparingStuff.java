import java.util.Comparator;

public class ComparingStuff implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if(a.intValue() < b.intValue()) {
            return(1);
        } else if (b.intValue() < a.intValue()) {
            return(-1);
        } else {
            return(0);
        }
    }
}
