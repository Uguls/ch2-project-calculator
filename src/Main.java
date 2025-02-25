import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);

        while (true) {
            double result = 0; // 나눗셈을 할 때 소숫점 까지 나타내기 위해 double 사용
            
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

            // 입력한 연산기호에 따라 Calculator의 메서드 사용
            if (symbol.equals("+")) {
                result = cal.add(first, second);
            } else if (symbol.equals("-")) {
                result = cal.sub(first, second);
            } else if (symbol.equals("x")) {
                result = cal.mul(first, second);
            } else if (symbol.equals("/")) {
                result = cal.div(first, second);
            } else {
                System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
                continue;
            }

            System.out.println("계산 결과는 " + result + "입니다.");
            List<String> resultList = new ArrayList<>();
            resultList = cal.getResultList();
            System.out.println("계산 기록 : " + resultList);

            System.out.println("가장 먼저 계산한 결과를 삭제하시겠습니까? (yes 입력 시 삭제)");
            String delete = sc.next().toLowerCase(); // toLowerCase를 사용하여 대문자가 들어가더라도 정상적으로 작동하도록 사용
            if (delete.equals("yes")) {
                cal.delResult();
            }

            System.out.println("계산기를 종료하시겠습니까?(종료하시기를 원하시면 \"exit\"를 입력해주세요");
            String off = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
            if (off.equals("exit")) {
                break;
            }

        }
        System.out.println("계산기가 종료되었습니다.");
    }
}