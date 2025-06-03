public interface Queue<T> {
    boolean enter(T o);
    T leave();
    void front();
    boolean isEmpty();
}
/*
    A Queue contains elements and can only be added to from the back and removed from from the front, unlike a stack that only has one entrance/exit
 */