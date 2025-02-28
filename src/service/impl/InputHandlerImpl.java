package service.impl;

import dto.CalculatorDTO;
import enums.OperatorType;
import service.interfaces.InputHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandlerImpl implements InputHandler {
    private final Scanner sc = new Scanner(System.in);
    private final ArithmeticCalculatorImpl cal; // 내부에서 직접 cal객체를 생성하면 매번 다른 객체가 생성되기 떄문에 main에서 생성하여 주입

    public InputHandlerImpl(ArithmeticCalculatorImpl calculator) {
        this.cal = calculator;
    }

    @Override
    public void getFirstNumber(CalculatorDTO calculatorDTO) {

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력해 주세요(양의 정수(0포함), 만약 마지막 계산에서 이어서 하고싶다면 Ans를 입력해주세요): ");
                String firstInput = sc.next();

                if (cal.getCount() > 0 && "ans".equals(firstInput.toLowerCase())) {
                    calculatorDTO.setFirstNumber(cal.getLastResult());
                    System.out.println("이전 계산 결과 : " + calculatorDTO.getFirstNumber());
                    break;
                }

                calculatorDTO.setFirstNumber(Double.valueOf(firstInput));

                if (calculatorDTO.getFirstNumber() < 0) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
                sc.nextLine();
            }
        }
    }

    @Override
    public void getSecondNumber(CalculatorDTO calculatorDTO) {
        while (true) {
            try {
                System.out.print("두 번째 숫자를 입력해 주세요(양의 정수(0포함), 나눗셈의 경우 0 입력 불가): ");
                Double secondNumber = sc.nextDouble();
                calculatorDTO.setSecondNumber(secondNumber);

                // 제대로 된 값을 받았는지 확인
                if (secondNumber < 0) {
                    System.out.println("양의 정수를 입력해 주세요");
                    continue; // 다시 입력 받도록 continue
                } else if ("/".equals(calculatorDTO.getOperator()) && secondNumber == 0) {
                    System.out.println("나눗셈의 경우 0은 입력할 수 없습니다.");
                    continue;
                } else {
                    break; // 정상적으로 입력 받았다면 break를 사용하여 while 탈출
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
                sc.nextLine();
            }
        }

    }

    @Override
    public void getOperator(CalculatorDTO calculatorDTO) {
        // 연사자 입력 받기
        boolean isOperatorWrong = true; // isOperatorWrong변수를 통해 while문 통제
        while (isOperatorWrong){
            System.out.print("연산 기호를 입력해 주세요(+,-,x(*),/, ^): ");
            String operator = sc.next();
            calculatorDTO.setOperator(operator);

            // TODO 스트림으로 변경하기
            for (OperatorType op : OperatorType.values()) {

                // ENUM 클래스에 저장된 연산자들과 입력받은 연산자 비교
                if (op.getOperator().equals(calculatorDTO.getOperator())) { // symbol이 null일 가능성이 존재함으로 op와 비교
                    calculatorDTO.setType(op);
                    isOperatorWrong = false; // while문을 탈출하기 위해 isOperatorWrong을 false로 설정
                    return; // 입력받은 연산자가 enum으로 관리하는 연산자중에 있다면 탈출
                }
            }
            
            // for문을 돌며 ENUM 클래스에 저장된 연산자들 중 입력받은 연산자가 있는지 확인 후 없다면 다시입력요청문구 출력
            if (isOperatorWrong = true) {
                System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
            }

        }
    }

}
