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
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Please actually input something!");
        }
    }
    public static void lookup (File start, File comp) throws IOException {
        String[] directories = start.list();    //list of directories in folder
        int totalDupes = 0;
        if(directories != null) {
            for (String i : directories) {
                String concat = start.getPath()+"/"+i;
                File temp = new File(concat);
                if(temp.isDirectory()) {
                    lookup(temp, comp);
                } else {
                    if(Objects.equals(temp.getName(), comp.getName())) {
                            long mis = Files.mismatch(temp.toPath(), comp.toPath());
                            if(mis == -1) {
                                System.out.println("Duplicate: "+temp.getCanonicalPath());
                                totalDupes++;
                            }
                    }
                }
            }
        }
        System.out.println(totalDupes);
    }
}


/*
 * if(files != null) {
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
 */