package calculator03;

public interface ArithmeticOperation<T> {
    T plus(T a, T b);
    T minus(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b) throws ArithmeticException;
}
