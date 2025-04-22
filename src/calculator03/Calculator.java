package calculator03;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T> {
    
    private final List<T> resultList = new ArrayList<>();
    private final ArithmeticOperation<T> operations;

    public Calculator(ArithmeticOperation<T> operations) {
        this.operations = operations;
    }

    public void calculate(T input1, T input2, char operationSymbol) {

        OperatorType op = OperatorType.changeSymbol(operationSymbol);
        if (op == null) throw new IllegalArgumentException("잘못된 연산자입니다.");
        T result = null;
        switch (op) {
            case PLUS:
                result = operations.plus(input1, input2);
                break;
            case MINUS:
                result = operations.minus(input1, input2);
                break;
            case MULTIPLY:
                result = operations.multiply(input1, input2);
                break;
            case DIVIDE:
                try {
                    result = operations.divide(input1, input2);
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
        };

        setResult(result);
    }

    // 연산 기록 리스트에서 가장 최근값을 불러오는 getter 메소드
    public T getResult() {
        return resultList.get(resultList.size() - 1);
    }

    // 연산 기록을 모두 확인하기위해 리스트 자체를 반환하는 getter 메소드
    public List<T> getResultList() {
        return resultList;
    }

    public void setResult(T result) {
        resultList.add(result);
    }

    public void removeResult() {
        resultList.remove(resultList.size() - 1);
    }
}