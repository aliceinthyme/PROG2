import java.io.*;

import Ceasar.*;

public class CeasarIsShifty {
    public static void main(String[] args) throws Exception {    
        File file = new File("encrypted.bin");
        try {
            //encryption
            InputStream stdin = System.in;
            CeasarEncode a = new CeasarEncode(stdin);
            Writer write = new FileWriter(file);
            StringBuilder build = new StringBuilder();
            //set temp variable
            int b = 0;
            //encrypt input
            while((b = a.read()) != 17) {   //checks for linefeed value + 7 since it will be encoded by read and somehow -1 isnt really playing nice
                if(b != 20) {   //for windows users (the poor things) since they also have to deal with carriage return (what is the the middle ages?? can I pet the horse at least?)
                    System.out.print((char)b);
                    build.append((char)b);  //throws the chars into a string
                }
                assert b > 0;
            }
            System.out.print("\n"); //this is just an aesthetics thing for stdout
            write.write(build.toString());  //writes the string to file
            //close writers and such
            a.close();
            stdin.close();
            write.flush();
            write.close();
            //System.out.println("1");
        } catch(IOException e) {
            System.out.println("something went wrong");
        }
        try {
            //decryption
            //open reader stuff
            InputStream output = new FileInputStream(file);
            BufferedInputStream reading = new BufferedInputStream(output);
            CeasarDecode dec = new CeasarDecode(reading);
            //set temp variable
            int c = 0;
            //decrypt input
            while((c = dec.read()) != -1) {
                System.out.print((char)c);
            }
            //close writer stuff
            dec.close();
            reading.close();
            output.close();
        } catch(IOException e) {
            System.out.println("something went wrong");
        }
    }
}

