package calculator03;

public class IntegerArithmetic implements ArithmeticOperation<Integer>{
    @Override
    public Integer plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer divide(Integer a, Integer b) throws ArithmeticException{
        return a / b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }
}
