import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", (x, y) -> x + y),
    SUB("-", (x, y) -> x - y),
    MUL("x", (x, y) -> x * y),
    MUL2("*", (x, y) -> x * y),
    DIV("/", (x, y) -> x / y),
    SQUARE("^", (x, y) -> Math.pow(x, y)); // x의 y제곱을 구하기 위해 Math.pow 사용

    private final BiFunction<Double, Double, Double> biFunction;
    private String operator;

    /**
     * ADD, SUB, MUL, MUL2, DIV를 생성 시 사용되는 생성자
     * 일반적인 클래스의 경우 new키워드를 통해 객체를 생성할 때 사용되는 것이 생성자이지만
     * enum의 생성자는 new 키워드를 사용하지 않고 미리 정의된 상수들을 초기화 하는 역할을 함
     */
    OperatorType(String operator, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    // Getter
    public String getOperator() {
        return operator;
    }

    /*
    BiFunction의 apply 메서드를 사용하여 연산 진행
    apply메서드는 인자 두 개를 받아서 하나의 값을 반환함
     */
    public Double calculate(double x, double y) {
        return biFunction.apply(x, y);
    }
}
