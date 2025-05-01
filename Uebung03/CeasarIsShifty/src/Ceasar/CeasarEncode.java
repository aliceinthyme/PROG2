package Ceasar;
import java.io.*;

public class CeasarEncode extends FilterInputStream {
    public CeasarEncode(InputStream in) {
        super(in);
    }
    public int read() throws IOException {
        int a = super.read();
        if(a < 0) {
            return a;
        }
        a+=7;
        return a;
    }
}
