package service;

import java.util.List;
import java.util.Scanner;

public class OutputHandler {
    private final Scanner sc = new Scanner(System.in);

    // 계산 결과 출력
    public void printResult(String result, double count, List<Double> resultList) {
        System.out.println("계산 결과는 " + result + "입니다.");
        System.out.println((int) count + "번 계산하셨습니다.");
        System.out.println("계산 기록 : " + resultList);
    }

    // 원하는 기능 입력받기
    public String getUserChoice() {
        System.out.println("1. 가장 오래된 기록 삭제\n" +
                "2. 저장된 연산 결과들 중 입력받은 값보다 큰 결과값들 출력하기\n" +
                "3. 종료하기\n" +
                "(계속하기를 원하시면 아무거나 입력해주세요)");
        String lastInput = sc.next();
        return lastInput;
    }

}
