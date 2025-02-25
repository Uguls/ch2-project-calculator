import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            OperatorType type = null;
            double result = 0;

            System.out.print("첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): ");
            int first = sc.nextInt();
            if (first < 0) {
                System.out.println("양의 정수를 입력해 주세요");
                continue;
            }
            System.out.print("두 번째 숫자를 입력해 주세요(양의 정수(0포함)): ");
            int second = sc.nextInt();
            if (second < 0) {
                System.out.println("양의 정수를 입력해 주세요");
                continue;
            }
            System.out.print("연산 기호를 입력해 주세요(+,-,x,/): ");
            String symbol = sc.next();
            if (symbol.equals("/") && second == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            switch (symbol) {
                case "+" :
                    type = OperatorType.ADD;
                    break;
                case "-" :
                    type = OperatorType.SUB;
                    break;
                case "x" :
                    type = OperatorType.MUL;
                    break;
                case "/" :
                    type = OperatorType.DIV;
                    break;
                default:
                    System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
                    continue;
            }

            result = cal.arithmeticCalculator(type, first, second);

            // 계산 결과 및 저장된 계산 기록 출력
            System.out.println("계산 결과는 " + result + "입니다.");
            System.out.println("계산 기록 : " + cal.getResultList());
            
            // 가장 오래된 기록 삭제
            System.out.println("가장 오래된 기록을 삭제하시겠습니까? (삭제를 원하시면 yes를 입력해주세요)");
            String delete = sc.next();
            if (delete.equals("yes")) {
                cal.delResult();
            }
            
            // 계산기 종료
            System.out.println("계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)");
            String off = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
            if (off.equals("yes")) {
                break;
            }

        }
        System.out.println("계산기가 종료되었습니다.");
    }
}