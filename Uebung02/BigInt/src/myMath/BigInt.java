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
    //these are useful for use with the fibonacci calculation
    public String getNumber() {
        return(this.number);
    }
    public void setNumber(String n) {
        this.number = n;
    }
    //method block
    //this method prints the String containing the number
    public void print() {
        System.out.println("The final result is: "+number);
    }
    //method to check if one BigInt is less than another
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
        //String to return as a result
        String result = ""; 
        //local variables as part of the calculation
        int overflow = 0;
        int storage = 0;
        //variables to decrement in the while loop and serve as individual indeces in order to allow numbers to have different lengths
        int here = this.number.length();
        int there = b.number.length();
        while (here != 0 || there != 0) {
            //pulls rightmost digit from the input string of this object and adds it to storage
            if(here != 0) {
                int temp = this.number.charAt(here-1) - '0';
                storage += temp;
                here--;
                assert here >= 0;
            }
            //pulls rightmost digit from the input string of the parameter object and adds it to storage
            if(there != 0) {
                int temp = b.number.charAt(there-1) - '0';
                //System.out.println("temp2: "+temp);
                storage += temp;
                there--;
                assert there >= 0;
            }
            //adds overflow to storage and then creates new overflow value!
            storage += overflow;  
            //storage+overflow may not be higher than 19 or something is very wrong  
            assert storage < 20;
            overflow = storage;
            //reduces storage down to single digit
            storage = storage % 10;
            //single digit storage cannot be higher than 9
            assert storage < 10;
            //overflow becomes either 10 or 0
            overflow -= storage;
            //if overflow is 10, 1 needs to be carried over
            if(overflow == 10) {
                overflow = 1;
            }
            //overflow should be either 0 or 1
            assert overflow >= 0;
            assert overflow <= 1;
            //adds single digit to the left side of the String
            result = storage+result;
            //for any overflow left that wont be carried forward into another calculation, to be added to the front of the String
            if(here == 0 && there == 0) {
                result = overflow+result;
            }
            storage = 0;
        }
        //returns the resulting String as part of a new BigInt as required by specification
        //try catch is necessary if the constructor is to check user input
        //error handling happens in the try catch in the main method
        try {
            BigInt a = new BigInt(result);
            return(a);
        } catch(InvalidInputException e) {
            BigInt a = null;
            return(a);
        }
    }
}
