import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
public class FindDupe {
    public static void main(String[] args) throws Exception {
        try {
            File startFolder = new File(args[0]);
            File compareTo = new File(args[1]);
            lookup(startFolder, compareTo);
        } catch(IOException e) {
            System.out.println("Something went wrong");
        }
    }
    public static void lookup (File start, File comp) throws IOException {
        String[] directories = start.list();    //list of directories in folder
        File[] files = start.listFiles();   //list of files in folder
        for (String i : directories) {
            File temp = new File(i);
            lookup(temp, comp);
        }
        for (File i : files) {
            if(Objects.equals(i.getName(), comp.getName())) {
                if (i.length() == comp.length()) {
                    long mis = Files.mismatch(i.toPath(), comp.toPath());
                    if(mis == -1) {
                        System.out.println("Duplicate: "+i.getAbsolutePath());
                    }
                }
            }
        }
    }
}


