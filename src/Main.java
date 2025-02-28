import dto.CalculatorDTO;
import enums.OperatorType;
import service.ArithmeticCalculator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // TODO 인풋, 아웃풋 클래스로 묵어서 하기

            // TODO DTO로 묶어서 해보기
            CalculatorDTO calculatorDTO = new CalculatorDTO();

//            OperatorType type = null;
//            double firstNumber = 0;
//            double secondNumber = 0;
//            String operator = "";

            // 첫번째 정수 받기
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

            // 연사자 입력 받기
            boolean isOperatorWrong = true; // isOperatorWrong변수를 통해 while문 통제
            while (isOperatorWrong){
                System.out.print("연산 기호를 입력해 주세요(+,-,x(*),/, ^): ");
                String operator = sc.next();
                calculatorDTO.setOperator(operator);

                // enum OpertorType에서 관리하는 연산자들과 입력받은 symbol을 비교
                // TODO 스트림으로 변경하기

                for (OperatorType op : OperatorType.values()) {
                    if (op.getOperator().equals(operator)) { // symbol이 null일 가능성이 존재함으로 op와 비교
                        calculatorDTO.setType(op);
                        isOperatorWrong = false; // while문을 탈출하기 위해 isOperatorWrong을 false로 설정
                        break; // 입력받은 연산자가 enum으로 관리하는 연산자중에 있다면 탈출
                    } else {
                        System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
                        break;
                    }
                }
            }

            // 두번째 정수 받기
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

            // 연산자, 첫번째 숫자, 두번째 숫자를 계산하기 위해 calculate메서드 실행 후 result에 저장
            String result = cal.calculate(calculatorDTO.getType(), calculatorDTO.getFirstNumber(),  calculatorDTO.getSecondNumber());

            // 계산 결과 및 저장된 계산 기록 출력
            System.out.println("계산 결과는 " + result + "입니다.");
            System.out.println((int)cal.getCount() + "번 계산하셨습니다.");
            System.out.println("계산 기록 : " + cal.getResultList());

            // 사용자가 원하는 기능 실행하기
            System.out.println("1. 가장 오래된 기록 삭제\n" +
                    "2. 저장된 연산 결과들 중 입력받은 값보다 큰 결과값들 출력하기\n" +
                    "3. 종료하기\n" +
                    "(계속하기를 원하시면 아무거나 입력해주세요)");
            String lastInput = sc.next();
            switch (lastInput) {
                // 가장 오래된 기록 삭제
                case "1" -> {
                    cal.delResult();
                }
                // 저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기
                case "2" -> {
                    System.out.println("저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : ");
                    try {
                        double num = sc.nextDouble();
                        List<Double> biggerList = cal.getBiggerList(num);
                        System.out.println(biggerList);
                    } catch (InputMismatchException e) {
                        sc.nextLine();
                    }
                }

                case "3" -> {
                    // 계산기 종료
                    System.out.println("계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)");
                    String isExit = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
                    if ("yes".equals(isExit)) {
                        return;
                    }
                }

            }
            System.out.println("계산기가 종료되었습니다.");
        }
    }
}