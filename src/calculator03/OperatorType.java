package calculator03;

// 연산자 타입을 정의하는 열거형
enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('x'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // 입력받은 연산자에 해당하는 OperatorType을 반환하는 메소드.
    public static OperatorType changeSymbol(char symbol) {
        // 입력받은 연산자의 값이 있으면 OperatorType 상수를 반환한다.
        for(OperatorType op : values()) {
            if(op.symbol == symbol)
                return op;
        }
        return null;
    }
}
