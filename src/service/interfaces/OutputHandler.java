package service.interfaces;

import java.util.List;

public interface OutputHandler {

    void printResult(String result, double count, List<Double> resultList);

    String getUserChoice();
}
