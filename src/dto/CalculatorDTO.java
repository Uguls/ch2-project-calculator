package dto;

import enums.OperatorType;

public class CalculatorDTO {
    private OperatorType type;
    private double firstNumber;
    private double secondNumber;
    private String operator;

    public OperatorType getType() {
        return type;
    }

    public void setType(OperatorType type) {
        this.type = type;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
