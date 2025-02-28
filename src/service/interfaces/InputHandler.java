package service.interfaces;

import dto.CalculatorDTO;

public interface InputHandler {

    void getFirstNumber(CalculatorDTO calculatorDTO);

    void getSecondNumber(CalculatorDTO calculatorDTO);

    void getOperator(CalculatorDTO calculatorDTO);
}
