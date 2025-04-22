package calculator03;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T> {

    T type;

    private final List<Double> resultList = new ArrayList<>();

    public void calculate(String input1, String input2, char operationSymbol) throws ArithmeticException {

        OperatorType op = OperatorType.changeSymbol(operationSymbol);

        if(type instanceof Double) {
            double a = Double.parseDouble(input1);
            double b = Double.parseDouble(input2);

            if(op != null)
                switch (op) {
                    case PLUS:
                        setResultList(a + b);
                        break;
                    case MINUS:
                        setResultList(a - b);
                        break;
                    case MULTIPLY:
                        setResultList(a * b);
                        break;
                    case DIVIDE:
                        setResultList(a / b);
                        break;
                }
            else {
                throw new IllegalArgumentException();
            }
        }
    }

    public T getResultList() {
        return (T) resultList.get(resultList.size() - 1);
    }

    public void setResultList(double num) {
        resultList.add((Double) num);
    }

    public void removeResultList() {
        resultList.remove(resultList.size()-1);
    }
}
