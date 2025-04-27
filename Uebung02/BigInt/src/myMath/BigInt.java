package myMath;
public class BigInt {
    //variable block
    private String number;
    //constructor block
    public BigInt(String d) throws InvalidInputException {
        boolean numStart = false;
        String temp = "";
        for(int i = 0; i < d.length(); i++) {
            int test = d.charAt(i) - '0';
            if((test < 0) || (test > 9)) {
                throw new InvalidInputException();
            }
            //trims leading 0s
            if (test != 0 || d.length() == 1) {
                numStart = true;
            }
            if(numStart) {
                temp = temp + test;
            }
        }
        number = temp;
    }
    public BigInt(int i) throws InvalidInputException {
        if(i < 0) {
            throw new InvalidInputException();
        }
        number = Integer.toString(i);
    }
    //getters and setters
    public String getNumber() {
        return(this.number);
    }
    public void setNumber(String n) {
        this.number = n;
    }
    //method block
    public void print() {
        System.out.println("The final result is: "+number);
    }
    boolean less(BigInt b) {
        if(this.number.length() < b.number.length()) {
            return(true);
        } else if(this.number.length() > b.number.length()) {
            return(false);
        } else {
            for(int i = 0; i < this.number.length(); i++) {
                int here = this.number.charAt(i) - '0';
                int there = b.number.charAt(i) - '0';
                if (here < there) {
                    return(true);
                } else if (here > there) {
                    return(false);
                }
            }
            return(false); //returns false if both numbers are equal, since other returns would have triggered by now if not
        }
        
    }
    public BigInt add(BigInt b) {
        String result = ""; 
        int overflow = 0;
        int storage = 0;
        int here = this.number.length();
        //System.out.println("here"+here);    
        int there = b.number.length();
        //System.out.println("there"+there);
        while (here != 0 || there != 0) {
            if(here != 0) {
                int temp = this.number.charAt(here-1) - '0';
                //System.out.println("temp1: "+temp);
                storage += temp;
                here--;
                assert here >= 0;
            }
            if(there != 0) {
                int temp = b.number.charAt(there-1) - '0';
                //System.out.println("temp2: "+temp);
                storage += temp;
                there--;
                assert there >= 0;
            }
            //adds overflow to storage and then creates new overflow value!
            storage += overflow;    
            assert storage < 20;
            overflow = storage;
            storage = storage % 10;
            assert storage < 10;
            overflow -= storage;
            if(overflow == 10) {
                overflow = 1;
            }
            //System.out.println(overflow + " Storage: "+storage);
            assert overflow >= 0;
            assert overflow <= 1;
            //System.out.println("This "+result);
            result = storage+result;
            if(here == 0 && there == 0) {
                result = overflow+result;
            }
            storage = 0;
        }
        //System.out.println(result+" Hi!");
        try {
            BigInt a = new BigInt(result);
            return(a);
        } catch(InvalidInputException e) {
            BigInt a = null;
            return(a);
        }
    }
}
