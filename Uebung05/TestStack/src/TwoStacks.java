public class TwoStacks {
    private int s1Pointer;
    private int s2Pointer;
    private Object[] casing;
    TwoStacks(int size) {
        casing = new Object[size];
        s1Pointer = 0;
        s2Pointer = casing.length-1;
    }
    public void s1Push(Object a) throws StackCollisionException {
        if(checkCollision()) { throw new StackCollisionException();}
        casing[s1Pointer] = a;
        s1Pointer++;
    }
    public void s2Push(Object a) throws StackCollisionException {
        if(checkCollision()) { throw new StackCollisionException();}
        casing[s2Pointer] = a;
        s2Pointer--;
    }
    public Object s1Pop() throws EmptyStackException, StackCollisionException {
        if(s1Pointer == 0) {throw new EmptyStackException(); }
        if(checkCollision()) { throw new StackCollisionException();}
        s1Pointer--;
        return(casing[s1Pointer+1]);
    }
    public Object s2Pop() throws EmptyStackException, StackCollisionException {
        if(s2Pointer == casing.length-1) {throw new EmptyStackException(); }
        if(checkCollision()) { throw new StackCollisionException();}
        s2Pointer++;
        return(casing[s2Pointer-1]);
    }
    public boolean checkCollision() {
        if(s1Pointer == s2Pointer) {
            return(true);
        } else {
            return(false);
        }
    }
    public boolean s1IsEmpty() {
        if(s1Pointer == 0) { return(true); }
        else { return(false); }
    }
    public boolean s2IsEmpty() {
        if(s2Pointer == casing.length-1) { return(true); }
        else { return(false); }
    }
    //added for this excercise 
    public java.util.Iterator forwardIterator() {
        return new ForwardIterator();
    }
    public java.util.Iterator backwardIterator() {
        return new BackwardIterator();
    }
    class ForwardIterator implements java.util.Iterator {   //s1
        private Object current = null; // saves the current element
        private int location;
        public ForwardIterator () {  
            this.current = casing[0];
            this.location = 0;
        }
        public boolean hasNext() { 
            if(this.location < s1Pointer) {
                return true;
            }
            return false;
        }
        public Object next() {  
            if(hasNext()) {
                this.location++;
                this.current = casing[location];
                return current;
            }
            return null;
        }
        public void remove() throws UnsupportedOperationException { // doesn’t make sense for a stack, so
            throw new UnsupportedOperationException();
        }
    }
    class BackwardIterator implements java.util.Iterator {   //s2
        private Object current = null; // saves the current element
        private int location;
        public BackwardIterator () {  
            this.current = casing[casing.length-1];
            this.location = casing.length-1;
        }
        public boolean hasNext() { 
            if(this.location > s1Pointer) {
                return true;
            }
            return false;
        }
        public Object next() {  
            if(hasNext()) {
                this.location--;
                this.current = casing[location];
                return current;
            }
            return null;
        }
        public void remove() throws UnsupportedOperationException { // doesn’t make sense for a stack, so
            throw new UnsupportedOperationException();
        }
    }
}
