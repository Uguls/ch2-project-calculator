import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum OperatorType {
    ADD("+", (x, y) -> x + y),
    SUB("-", (x, y) -> x - y),
    MUL("x", (x, y) -> x * y),
    DIV("/", (x, y) -> x / y);

    private final BiFunction<Double, Double, Double> biFunction;
    private String operator;

    OperatorType(String operator, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public Double calculate(double x, double y) {
        return biFunction.apply(x, y);
    }

    public String getOperator() {
        return operator;
    }

}

public class ArithmeticCalculator<T extends Number>  {
    private Double result;

    private List<Double> resultList = new ArrayList<>();

    public Double calculate(OperatorType operatorType, T x, T y) {
        switch (operatorType) {
            case ADD:
                result = x.doubleValue() + y.doubleValue();
                break;
            case SUB:
                result = x.doubleValue() - y.doubleValue();
                break;
            case MUL:
                result = x.doubleValue() * y.doubleValue();
                break;
            case DIV:
                result = x.doubleValue() / y.doubleValue();
                break;
        }
        resultList.add(result);
        return result;
    }

    public void delResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        } else {
            System.out.println("계산 결과가 저장되어 있지 않습니다.");
        }
    }

    // 스트림을 사용하여 입력받은 수보다 큰 숫자목록 뽑기
    // .filter를 통해 num보다 큰 수를 뽑은 후
    // .toList를 통해 List로 뽑기
    public List<Double> getBiggerList(Number num) {
        return resultList.stream()
                .filter(v -> v > num.doubleValue())
                .toList();
    }

    // 계산횟수 구하기
    public double getCount() {
        return resultList.stream()
                .count();
    }

    // Getter, Setter
    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

}
