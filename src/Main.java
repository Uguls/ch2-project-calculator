import dto.CalculatorDTO;
import service.impl.ArithmeticCalculatorImpl;
import service.impl.CalculatorFuncImpl;
import service.impl.InputHandlerImpl;
import service.impl.OutputHandlerImpl;
import service.interfaces.ArithmeticCalculator;
import service.interfaces.CalculatorFunc;
import service.interfaces.InputHandler;
import service.interfaces.OutputHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 계산을 하는 객체
        ArithmeticCalculator<Double> cal = new ArithmeticCalculatorImpl();
        // 입력을 담당하는 객체
        InputHandler inputHandler = new InputHandlerImpl((ArithmeticCalculatorImpl) cal);
        // 출력을 담당하는 객체
        OutputHandler outputHandler = new OutputHandlerImpl();
        // 변수를 담당하는 객체
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        // 계산기 기능을 담당하는 객체
        CalculatorFunc calculatorFunc = new CalculatorFuncImpl(cal);
        // 스캐너
        Scanner sc = new Scanner(System.in);

        while (true) {
            inputHandler.getFirstNumber(calculatorDTO);
            inputHandler.getOperator(calculatorDTO);
            inputHandler.getSecondNumber(calculatorDTO);

            // 연산자, 첫번째 숫자, 두번째 숫자를 계산하기 위해 calculate메서드 실행 후 result에 저장
            String result = cal.calculate(calculatorDTO.getType(), calculatorDTO.getFirstNumber(),  calculatorDTO.getSecondNumber());

            outputHandler.printResult(result, cal.getCount(), cal.getResultList());
            // 사용자가 원하는 기능 실행하기
            String userChoice = outputHandler.getUserChoice();

            switch (userChoice) {
                // 가장 오래된 기록 삭제
                case "1" : calculatorFunc.delResult();
                    break;
                // 저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기
                case "2" : calculatorFunc.getBiggerList();
                    break;
                // 계산기 종료
                case "3" : calculatorFunc.exitCalculator();
                    break;
            }
        }
    }
}