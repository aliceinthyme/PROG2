public class NegativeNumberException extends Exception {
    String s;
    NegativeNumberException() {}
    NegativeNumberException(String s_) {
        s = s_;
    }
}
