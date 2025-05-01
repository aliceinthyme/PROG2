package Ceasar;
import java.io.*;

public class CeasarDecode extends FilterInputStream {
    CeasarDecode(InputStream in) {
        super(in);
    }
    public int read() throws IOException {
        int a = super.read();
        if(a < 0) {
            return a;
        }
        a-=7;
        return a;
    }
}
