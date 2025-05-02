import java.io.*;

public class CharCount {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        File output = new File("output.txt");
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            BufferedReader count = new BufferedReader(new FileReader(file));
            Writer write = new FileWriter(output);
            PrintWriter pwrite = new PrintWriter(write);
            int max = 0;
            while(count.read() != -1) {
                max++;
            }
            int[] allChars = new int[max];
            int b = 0;
            max--;
            while((b = read.read()) != -1) {
                allChars[max] = b;
                max--;
            }
            int temp = 0;
            for(int i = 122; i != 65; i--) {
                for(int j = 0; j < allChars.length; j++) {
                    if(allChars[j] == i) {
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
                temp = 0;
            }
            pwrite.flush();
            write.flush();
            pwrite.close();
            write.close();
            read.close();
            count.close();
        } catch(IOException e) {
            System.out.println("Something went wrong");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please actually input something!");
            System.out.println(e.getCause());
        }
    }
}
