
public class App {
    public static void main(String[] args) throws Exception {
        stuff("One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them");
    }
    public static void stuff(String str) {
        //writing a cache for this would be more time consuming overall, as here we basically just parse each char once, 
        //rather than cleaning the string and then tokenising it and then creating a cache and then saving the individual amounts
        //and then crosschecking for each individual token, etc.
        int[] a = new int[173];
        for(int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if((temp > 47 && temp < 58) || (temp > 64 && temp < 91) || (temp > 96 && temp < 123)) {
                //temp > 47 && temp < 58  //numbers
                //temp > 64 && temp < 91  //capital Letters
                //temp > 96 && temp < 123 //lower case letters
                int n = (int)temp;
                a[n] = a[n]+1;
            }
        }
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                count++;
            }
        }
        System.out.println("Unique letters: "+count);
    }
}

