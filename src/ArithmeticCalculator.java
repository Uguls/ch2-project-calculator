import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator  {
    private int result;
    private double result2;

    private List<String> resultList = new ArrayList<>();

    public int add(int x, int y) {
        result = x + y;
        resultList.add(Integer.toString(result));
        return result;
    }

    public int sub (int x, int y) {
        result = x - y;
        resultList.add(Integer.toString(result));
        return result;
    }

    public int mul(int x, int y) {
        result = x * y;
        resultList.add(Integer.toString(result));
        return result;
    }

    public double div(int x, int y) {
        result2 = (double) x / y;
        resultList.add(Double.toString(result2));
        return result2;
    }

    public void delResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
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
