import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            OperatorType type = null;
            double first = 0;
            double second = 0;
            String symbol = "";

            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): ");
                    first = sc.nextDouble();
                    if (first < 0) {
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
                System.out.print("연산 기호를 입력해 주세요(+,-,x,/): ");
                symbol = sc.next();

                // enum OpertorType에서 관리하는 연산자들과 입력받은 symbol을 비교
                for (OperatorType op : OperatorType.values()) {
                    if (op.getOperator().equals(symbol)) { // symbol이 null일 가능성이 존재함으로 op와 비교
                        type = op;
                        isOperatorWrong = false; // while문을 탈출하기 위해 isOperatorWrong을 false로 설정
                        break; // 입력받은 연산자가 enum으로 관리하는 연산자중에 있다면 탈출
                    } else {
                        System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
                        break;
                    }
                }
            }

            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력해 주세요(양의 정수(0포함), 나눗셈의 경우 0 입력 불가): ");
                    second = sc.nextDouble();

                    if (second < 0) {
                        System.out.println("양의 정수를 입력해 주세요");
                        continue; // 다시 입력 받도록 continue
                    } else if ("/".equals(symbol) && second == 0) {
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

            // 소숫점 3자리까지 제한
            DecimalFormat decimalFormat = new DecimalFormat("#.###");
            String result = decimalFormat.format(cal.calculate(type, first, second));

            // 계산 결과 및 저장된 계산 기록 출력
            System.out.println("계산 결과는 " + result + "입니다.");
            System.out.println((int)cal.getCount() + "번 계산하셨습니다.");
            System.out.println("계산 기록 : " + cal.getResultList());
            
            // 가장 오래된 기록 삭제
            System.out.println("가장 오래된 기록을 삭제하시겠습니까? (삭제를 원하시면 yes를 입력해주세요)");
            String delete = sc.next();
            if (delete.equals("yes")) {
                cal.delResult();
            }

            System.out.println("저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : ");
            try {
                double num = sc.nextDouble();
                List<Double> biggerList = cal.getBiggerList(num);
                System.out.println(biggerList);
            } catch (InputMismatchException e) {
                sc.nextLine();
            }

            // 계산기 종료
            System.out.println("계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)");
            String off = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
            if ("yes".equals(off)) {
                break;
            }

        }
        System.out.println("계산기가 종료되었습니다.");
    }
}