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
        s1Pointer++;
        return(casing[s1Pointer-1]);
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
}
