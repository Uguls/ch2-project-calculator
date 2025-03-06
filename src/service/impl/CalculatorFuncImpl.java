package service.impl;

import service.interfaces.ArithmeticCalculator;
import service.interfaces.CalculatorFunc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculatorFuncImpl implements CalculatorFunc {
    private final Scanner sc = new Scanner(System.in);
    private final ArithmeticCalculator cal;

    public CalculatorFuncImpl(ArithmeticCalculator cal) {
        this.cal = cal;
    }

    @Override
    public void delResult() {
        cal.delResult();
    }

    @Override
    public void getBiggerList() {
        System.out.println("저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : ");
        try {
            double num = sc.nextDouble();
            List<Double> biggerList = cal.getBiggerList(num);
            System.out.println(biggerList);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요");
            sc.nextLine();
        }
    }

    @Override
    public void exitCalculator() {
        System.out.println("계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)");
        String isExit = sc.next().toLowerCase(); // toLowerCase를 사용하여 Exit eXit exIt 등 다양한 exit에 대응하도록 함
        if ("yes".equals(isExit)) {
            System.out.println("계산기가 종료되었습니다.");
            System.exit(0);
        }
    }

    @Override
    public void clearResultList() {
        cal.setResultList(new ArrayList<>());
    }
}