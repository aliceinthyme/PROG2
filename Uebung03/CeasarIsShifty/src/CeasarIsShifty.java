import java.io.*;

import Ceasar.*;

public class CeasarIsShifty {
    public static void main(String[] args) throws Exception {    
        try {
            //encryption
            InputStream stdin = System.in;
            CeasarEncode a = new CeasarEncode(stdin);
            OutputStream file = new FileOutputStream("encrypted.bin");
            Writer write = new OutputStreamWriter(file, "utf-16");
            PrintWriter writetofile = new PrintWriter(write);
            int b = 0;
            while((b = a.read()) != 17) {
                if(b != 20) {
                    System.out.print((char)b);
                    writetofile.print(b);
                }
            }
            stdin.close();
            //System.out.println("1");
        } catch(IOException e) {

        }
        try {
            InputStream file = new FileInputStream("encrypted.bin");
            CeasarDecode dec = new CeasarDecode(file);
            int c = 0;
            while((c = dec.read()) != -1) {
                System.out.println((char)c);
            }
        } catch(IOException e) {

        }
    }
}


/*
 * 
 * 
 * 
 * 
 * 
 * 
 *   try (Reader reader = new BufferedReader(new InputStreamReader
      (inputStream, StandardCharsets.UTF_8))) {
        int c = 0;
        while ((c = reader.read()) != -1) {
            textBuilder.append((char) c);
        }
    }
 */