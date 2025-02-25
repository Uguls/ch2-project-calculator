import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
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

            if (symbol.equals("+")) {
                result = first + second;
            } else if (symbol.equals("-")) {
                result = first - second;
            } else if (symbol.equals("*")) {
                result = first * second;
            } else if (symbol.equals("/")) {
                result = (double) first / second; // double형으로 하지 않으면 몫만 나오기 때문에 double로 변형
            } else {
                System.out.println("잘못된 연산 기호 입니다. 다시 입력해 주세요");
                continue;
            }

            System.out.println("연산 결과는 " + result + "입니다.");

            System.out.println("계산기를 종료하시겠습니까?(종료하시기를 원하시면 \"exit\"를 입력해주세요");
            String off = sc.next();
            if (off.equals("exit")) {
                break;
            }

        }
        System.out.println("계산기가 종료되었습니다.");
    }
}