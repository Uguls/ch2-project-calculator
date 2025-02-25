import java.util.ArrayList;
import java.util.List;

enum OperatorType {
    ADD,
    SUB,
    MUL,
    DIV
}

public class ArithmeticCalculator  {
    private double result;

    private List<String> resultList = new ArrayList<>();

    public double add(int x, int y) {
        result = x + y;
        return result;
    }

    public double sub (int x, int y) {
        result = x - y;
        return result;
    }

    public double mul(int x, int y) {
        result = x * y;
        return result;
    }

    public double div(int x, int y) {
        result = (double) x / y;
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
    public List<String> getResultList() {
        return resultList;
    }

    public void setResultList(List<String> resultList) {
        this.resultList = resultList;
    }

}
