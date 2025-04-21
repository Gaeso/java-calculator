package calculator02;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final List<Integer> resultList = new ArrayList<>();

    public Calculator () {

    }

    public void calculate(int input1, int input2, char operationSymbol) throws ArithmeticException {
        switch (operationSymbol) {
            case '+':
                setResultList(input1 + input2);
                break;
            case '-':
                setResultList(input1 - input2);
                break;
            case 'x':
                setResultList(input1 * input2);
                break;
            case '/':
                setResultList(input1 / input2);
                break;
            default:
                // 사칙연산 외의 값이 들어올시 처리
                System.out.println("사칙연산만 입력해주세요.");
                break;
        }
    }

    public int getResultList() {
            return resultList.get(resultList.size() - 1);
    }

    public void setResultList(int num) {
        resultList.add(num);
    }

    public void removeResultList() {
        resultList.remove(resultList.size()-1);
    }
}
