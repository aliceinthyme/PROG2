import java.io.*;

public class CharCount {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        File output = new File("output.txt");
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            Writer write = new FileWriter(output);
            PrintWriter pwrite = new PrintWriter(write);
            //set temp variable
            
            for(int i = 122; i != 65; i--) {
                int temp = 0;
                int b = 0;
                /*
                 * TODO:
                 * figure out how to stuff b into a char array somehow
                 * second buffered reader
                 */
                while((b = read.read()) != -1) {
                    System.out.println(b+" "+i);
                    if(b == i) {
                        temp++;
                    }
                }
                if(temp == 1) {
                    String a = "The letter "+(char)i+" appears 1 time.";
                    System.out.println(a);
                    pwrite.println(a);

                } else if(temp > 1) {
                    String a = "The letter "+(char)i+" appears "+temp+" times.";
                    System.out.println(a);
                    pwrite.println(a);
                }
            }
            pwrite.flush();
            write.flush();
            pwrite.close();
            write.close();
            read.close();
        } catch(IOException e) {
            System.out.println("Something went wrong");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please actually input something!");
        }
    }
}
