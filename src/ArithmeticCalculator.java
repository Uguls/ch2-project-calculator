import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArithmeticCalculator<T extends Number>  {
    private String result;

    private List<Double> resultList = new ArrayList<>();

    public String calculate(OperatorType operatorType, T x, T y) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        result = decimalFormat.format(operatorType.calculate(x.doubleValue(), y.doubleValue())); // Double타입으로 반환되는 결과값을 String으로 변환 및 소수점 제한
        resultList.add(Double.parseDouble(result)); // String타입으로 된 reulst를 Double타입으로 변환하여 리스트에 저장
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

    // 마지막 계산 결과 가져오기
    public Double getLastResult() {
        return Double.valueOf(result);
    }

    public void setResultList(List<Double> resultList) {
        this.resultList = resultList;
    }
}
