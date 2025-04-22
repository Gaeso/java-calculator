package calculator03;

enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('x'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    // 사용자로부터 입력받은 연산자를
    public static OperatorType changeSymbol(char symbol) {
        for(OperatorType op : values()) {
            if(op.symbol == symbol)
                return op;
        }
        return null;
    }
}
