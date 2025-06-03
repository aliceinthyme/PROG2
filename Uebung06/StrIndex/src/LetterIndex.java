import java.util.*;

public class LetterIndex {
    public static void main(String[] args) throws Exception {
        TreeSet<String> result = new TreeSet<String>();
        String input = "";
        for(int i = 0; i < args.length; i++) {
            input = input+args[i];
        }
        for(int j = 48; j < 173; j++) {
            if((j > 47 && j < 58) || (j > 64 && j < 91) || (j > 96 && j < 123)) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                for(int i = 0; i < input.length(); i++) {
                    if((int)input.charAt(i) == j) {
                        set.add(i);
                    }
                }
                if(!set.isEmpty()) {
                    String temp = (char)j+"="+set;
                    result.add(temp);
                }
            }
        }
        System.out.print(result);
    }
}
