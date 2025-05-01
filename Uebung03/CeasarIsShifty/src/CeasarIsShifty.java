import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

import Ceasar.*;

public class CeasarIsShifty {
    public static void main(String[] args) throws Exception {
        InputStream stdin = System.in;
        

        try {
            CeasarEncode a = new CeasarEncode(stdin);
            int b = 0;
            while((b = a.read()) != -1) {
                System.out.print((char)b);
            }
            stdin.close();
            System.out.println("1");
        } catch(IOException e) {

        }
    }
}


/*
 * 
 *   try (Reader reader = new BufferedReader(new InputStreamReader
      (inputStream, StandardCharsets.UTF_8))) {
        int c = 0;
        while ((c = reader.read()) != -1) {
            textBuilder.append((char) c);
        }
    }
 */