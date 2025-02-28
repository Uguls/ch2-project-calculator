import dto.CalculatorDTO;
import service.impl.ArithmeticCalculatorImpl;
import service.impl.InputHandlerImpl;
import service.impl.OutputHandlerImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculatorImpl<Double> cal = new ArithmeticCalculatorImpl();
        InputHandlerImpl inputHandlerImpl = new InputHandlerImpl(cal);
        OutputHandlerImpl outputHandlerImpl = new OutputHandlerImpl();
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            inputHandlerImpl.getFirstNumber(calculatorDTO);
            inputHandlerImpl.getOperator(calculatorDTO);
            inputHandlerImpl.getSecondNumber(calculatorDTO);

            // 연산자, 첫번째 숫자, 두번째 숫자를 계산하기 위해 calculate메서드 실행 후 result에 저장
            String result = cal.calculate(calculatorDTO.getType(), calculatorDTO.getFirstNumber(),  calculatorDTO.getSecondNumber());

            outputHandlerImpl.printResult(result, cal.getCount(), cal.getResultList());
            // 사용자가 원하는 기능 실행하기
            String userChoice = outputHandlerImpl.getUserChoice();

            switch (userChoice) {

                // 가장 오래된 기록 삭제
                case "1" -> {
                    cal.delResult();
                    break;
                }

                // 저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기
                case "2" -> {
                    System.out.println("저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : ");
                    try {
                        double num = sc.nextDouble();
                        List<Double> biggerList = cal.getBiggerList(num);
                        System.out.println(biggerList);
                        break;
                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        break;
                    }
                }

                case "3" -> {
                    // 계산기 종료
                    System.out.println("계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)");
                    String isExit = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
                    if ("yes".equals(isExit)) {
                        System.out.println("계산기가 종료되었습니다.");
                        return;
                    }
                }

            }
        }
    }
}