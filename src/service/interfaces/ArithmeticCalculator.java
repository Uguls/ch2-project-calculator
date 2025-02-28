package service.interfaces;

import enums.OperatorType;

import java.util.List;

public interface ArithmeticCalculator<T extends Number> {
    String calculate(OperatorType operatorType, T x, T y);

    void delResult();

    List<Double> getBiggerList(Number num);

    double getCount();

    List<Double> getResultList();

    Double getLastResult();
}
