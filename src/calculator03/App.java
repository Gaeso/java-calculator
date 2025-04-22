package calculator03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // 원하는 입력값 타입에 따라 정해주자.
        Calculator<Double> calculator = new Calculator<>(new DoubleArithmetic());

        // 원하는 입력값 타입에 따라 변수타입을 정해주자.
        double input1, input2;

        // 사칙연산을 입력받을 스트링 클래스
        String input3;
        String exitFlag = "";

        char operationSymbol;

        // Calculator 클래스 선언
        Scanner sc = new Scanner(System.in);

        // exit 입력을 받으면 반복 종료.
        while (!exitFlag.equals("exit")) {
            try {
                System.out.print("첫번째 수를 입력해주세요 : ");

                // 엔터입력이 다음 버퍼로 넘어가지 않도록 nextLine()으로 통일후에 형변환을 해줌.
                // 원하는 입력값 타입에 따라 parse를 다르게 해주자.
                input1 = Double.parseDouble(sc.nextLine());

                System.out.print("두번째 수를 입력해주세요 : ");
                input2 = Double.parseDouble(sc.nextLine());

                System.out.print("연산기호를 입력해주세요 (+,-,x,/) : ");
                input3 = sc.nextLine();

                // 문자 하나만 입력하지않거나, 입력없이 엔터를 누를시 예외처리
                if(input3.length() == 1)
                {
                    operationSymbol = input3.charAt(0);
                }
                else {
                    System.out.println("올바른 연산기호를 입력해주세요.");
                    continue;
                }
            } catch (NumberFormatException e) {
                // 입력에 숫자가 아닌 값이 들어갔을때 예외처리
                System.out.println("실수를 입력해주세요");
                continue;
            }
            try {
                calculator.calculate(input1, input2, operationSymbol);
                if(calculator.getResult() != null)
                    System.out.println(input1 + " " + operationSymbol + " " + input2 + " = " + calculator.getResult());
            } catch (IllegalArgumentException e) { // 사칙연산 제외 문자가 들어갈때 예외 처리
                System.out.println("사칙 연산만 입력해주세요.");
            }

            // 연산 기록들을 확인하기 위한 람다 & 스트림을 이용한 로직.
            System.out.print("연산 기록을 확인하시겠습니까? (y -> 확인) :");
            String checkHistory = sc.nextLine();
            if(checkHistory.equals("y")){
                System.out.print("필터링할 숫자를 입력해주세요 (입력값 이상의 결과들만 출력함) : ");
                double filteringNumber = Double.parseDouble(sc.nextLine());
                try {
                    calculator.getResultList().stream().filter(result -> result >= filteringNumber).forEach(System.out::println);
                }
                catch (NullPointerException e) {
                    System.out.println("기록된 연산이 없습니다.");
                }
            }

            System.out.print("계산을 계속 하시겠습니까? (y or exit) :");
            exitFlag = sc.nextLine();
        }
        System.out.println("계산기를 종료합니다.");

        sc.close();
    }
}
