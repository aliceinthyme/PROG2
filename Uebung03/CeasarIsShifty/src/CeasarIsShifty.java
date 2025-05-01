import java.io.*;

import Ceasar.*;

public class CeasarIsShifty {
    public static void main(String[] args) throws Exception {    
        File file = new File("encrypted.bin");
        try {
            //encryption
            InputStream stdin = System.in;
            CeasarEncode a = new CeasarEncode(stdin);
            //OutputStream file = new FileOutputStream();
            Writer write = new FileWriter(file);
            StringBuilder build = new StringBuilder();
            int b = 0;
            while((b = a.read()) != 17) {
                if(b != 20) {
                    System.out.print((char)b);
                    build.append((char)b);
                }
            }
            System.out.print("\n");
            write.write(build.toString());
            stdin.close();
            write.flush();
            write.close();
            //System.out.println("1");
        } catch(IOException e) {

        }
        try {
            InputStream output = new FileInputStream(file);
            BufferedInputStream reading = new BufferedInputStream(output);
            CeasarDecode dec = new CeasarDecode(reading);
            int c = 0;
            while((c = dec.read()) != -1) {
                System.out.print((char)c);
            }
            dec.close();
            reading.close();
            output.close();
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