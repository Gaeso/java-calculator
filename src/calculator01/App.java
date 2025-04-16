package calculator01;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int input1, input2, result;
        String input3;
        String exitFlag = "";
        char operationSymbol;

        Scanner sc = new Scanner(System.in);

        // exit 입력을 받으면 반복 종료.
        while (!exitFlag.equals("exit")) {
            try {
                System.out.print("첫번째 양의 정수를 입력해주세요 : ");
                // 엔터입력이 다음 버퍼로 넘어가지 않도록 nextLine()으로 통일후에 형변환을 해줌.
                input1 = Integer.parseInt(sc.nextLine());

                System.out.print("두번째 양의 정수를 입력해주세요 : ");
                input2 = Integer.parseInt(sc.nextLine());

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
                System.out.println("정수를 입력해주세요");
                continue;
            }

            switch (operationSymbol) {
                case '+':
                    result = input1 + input2;
                    System.out.println(input1 + " + " + input2 + " = " + result);
                    break;
                case '-':
                    result = input1 - input2;
                    System.out.println(input1 + " - " + input2 + " = " + result);
                    break;
                case 'x':
                    result = input1 * input2;
                    System.out.println(input1 + " x " + input2 + " = " + result);
                    break;
                case '/':
                    try {
                        result = input1 / input2;
                        System.out.println(input1 + " / " + input2 + " = " + result);
                    } catch (ArithmeticException e) {
                        // 분모를 0으로 나눌때 예외처리
                        System.out.println("분모(두번째 입력값) 0으로 나눌 수 없습니다.");
                    }
                    break;
                default:
                    // 사칙연산 외의 값이 들어올시 처리
                    System.out.println("사칙연산만 입력해주세요.");
                    continue;
            }
            System.out.print("계산을 계속 하시겠습니까? (y or exit) :");
            exitFlag = sc.nextLine();
        }
    }
}
