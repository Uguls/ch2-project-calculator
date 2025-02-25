import java.util.ArrayList;
import java.util.List;

enum OperatorType {
    ADD,
    SUB,
    MUL,
    DIV;
}

public class ArithmeticCalculator  {
    private double result;

    private List<Double> resultList = new ArrayList<>();

    public double arithmeticCalculator(OperatorType operatorType, double x, double y) {
        switch (operatorType) {
            case ADD:
                result = x + y;
                break;
            case SUB:
                result = x - y;
                break;
            case MUL:
                result = x * y;
                break;
            case DIV:
                result = x / y;
                break;
        }
        resultList.add(result);
        return result;
    }

    public void delResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(resultList.size() - 1);
        } else {
            System.out.println("계산 결과가 저장되어 있지 않습니다.");
        }
    }

    // Getter, Setter
    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }

}
