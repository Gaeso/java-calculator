package calculator03;

public class DoubleArithmetic implements ArithmeticOperation<Double> {
    @Override
    public Double plus(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double minus(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double divide(Double a, Double b) throws ArithmeticException {
        if(b == 0)
            throw new ArithmeticException();
        else
            return a / b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }
}
