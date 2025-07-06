import java.io.*;
import java.util.ArrayList;

public class CoffeeMachine {
    private int cofFill, watFill, watCap, cofCap, cleanCounter, lifetimeCups;
    File logs = new File("coffeelogs.txt");

    CoffeeMachine(int wat, int cof) {
        watCap = wat;
        cofCap = cof*10;
        cofFill = 0;
        watFill = 0;
        cleanCounter = 12;
        lifetimeCups = 0;
    }
    //getter
    public int getCleanCounter() {
        return(this.cleanCounter);
    }
    //methods
    public String[] printStats() {
        double dcofFill = (double)cofFill/10;
        String[] outp = new String[5];
        outp[0] = "Hi there caffeine fiend! Your current coffee stats are: ";
        outp[1] = "Your Machine is filled to "+dcofFill+"/"+cofCap/10+" with coffee!";
        outp[2] = "And to "+watFill+"/"+watCap+" with water!";
        outp[3] = "You can make another "+cleanCounter+" cups before the next mandatory cleaning cycle!";
        outp[4] = "Wow, arent you an avid coffee addict! You have brewed a total of "+lifetimeCups+" with this machine!";
        return(outp);
    }
    public void makeCup() throws InsufficientMaterialsException {
        if((this.cofFill >= 75) && (this.watFill >= 150)) {
            cleanCounter--;
            lifetimeCups++;
            cofFill -= 75;
            watFill -= 150;
        } else {
            try {
                logWriter("Water or Coffee low!! Water: "+watFill+" Coffee: "+cofFill);
            } catch (IOException e) {
                System.err.println("IOException @ makeCup in CoffeeMachine.java");
            }
            throw new InsufficientMaterialsException();
        }
    }
    public void fillWater(int refill) {
        int over = watCap - (watFill+refill);
        if(over < 0) {
            watFill = watCap;
            System.out.println("You refill the container completely, but refrain from pouring the remaining "+-over+"ml into the already full container!");
            try {
                logWriter("Refill successful, overfill of Water attempted of "+-over);
            } catch (IOException e) {
                System.err.println("IOException @ fillWater in CoffeeMachine.java");
            }
        } else {
            watFill += refill;
        }
    }
    public void fillCoffee(int refill) {
        int over = cofCap - (cofFill+(refill*10));
        if(over < 0) {
            cofFill = cofCap;
            System.out.println("You refill the container completely, but refrain from pouring the remaining "+(double)(-over/10)+"g into the already full container!");
            try {
                logWriter("Refill successful, overfill of Coffee attempted of "+-over);
            } catch (IOException e) {
                System.err.println("IOException @ fillCoffee in CoffeeMachine.java");
            }
        } else {
            cofFill += (refill*10);
        }
    }
    public void clean() {
        this.cleanCounter = 12;
    }

    private void logWriter(String input) throws IOException {
        FileWriter write = new FileWriter(logs, true);
        write.append(input+"\n");
        write.flush();
        write.close();
    }

    public ArrayList<String> logReader() throws IOException {
        FileReader inp = new FileReader(logs);
        BufferedReader read = new BufferedReader(inp);
        ArrayList<String> list = new ArrayList<String>();
        String temp = "";
        while ((temp = read.readLine()) != null) {
            list.add(temp);
        }
        read.close();
        inp.close();
        return list;
    }
}
