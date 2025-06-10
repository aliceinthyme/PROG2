import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.*;
public class Run {
    public static int cachehits = 0;
    public static void main(String[] args) throws Exception {
        try {
            doTheThing(args[0]);
        } catch (IOException e) {
            System.err.println("IO Exception detected!");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("please input an actual string!");
        }

    }
    public static void doTheThing(String a) throws IOException {
        //please ensure txt file is in directory printed below:
        //Path currentRelativePath = Paths.get("");
        //String s = currentRelativePath.toAbsolutePath().toString();
        //System.out.println("Current absolute path is: " + s);
        File cache = new File("cache.txt");
        //FileInputStream inp = new FileInputStream(cache);
        Scanner read = new Scanner(cache);
        //FileOutputStream out = new FileOutputStream(cache);
        FileWriter write = new FileWriter(cache);
        ArrayList<String> clist = new ArrayList<String>();
        while(read.hasNextLine()){
            clist.add(read.nextLine());
        }
        System.out.println(clist);
        Iterator iter = clist.iterator();
        while(iter.hasNext()) {
            if(a.equals(iter.next().toString())) {
                System.out.println("Unique letters: "+iter.next().toString());
                cachehits++;
            }
        }
        write.append(a+System.lineSeparator());
        String number = Integer.toString(stuff(a));
        write.append(number+System.lineSeparator());
        write.flush();
        read.close();
        write.close();
    }
    public static int stuff(String str) {
        //writing a cache for this would be more time consuming overall, as here we basically just parse each char once, 
        //rather than cleaning the string and then tokenising it and then creating a cache and then saving the individual amounts
        //and then crosschecking for each individual token, etc.
        int[] a = new int[173];
        for(int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if((temp > 47 && temp < 58) || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)) {
                //temp > 47 && temp < 58  //numbers
                //temp > 64 && temp < 91  //capital Letters
                //temp > 96 && temp < 123 //lower case letters
                int n = (int)temp;
                a[n] = a[n]+1;
            }
        }
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                count++;
            }
        }
        System.out.println("Unique letters: "+count);
        return(count);
    }
}
/*
 * 
 */