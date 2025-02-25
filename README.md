# ch2-project-calculator

계산기 프로그램

소개

이 프로그램은 Java로 구현된 간단한 콘솔 기반 계산기입니다.
사용자는 두 개의 양의 정수를 입력하고, 사칙연산(+, -, *, /)을 수행할 수 있습니다.
연산 결과는 리스트에 저장되며, 프로그램이 종료될 때까지 여러 번 계산할 수 있습니다.

기능

덧셈: 두 개의 정수를 더합니다.

뺄셈: 첫 번째 정수에서 두 번째 정수를 뺍니다.

곱셈: 두 개의 정수를 곱합니다.

나눗셈: 첫 번째 정수를 두 번째 정수로 나눕니다. (단, 두 번째 정수가 0이면 오류 메시지 출력)

계산 결과 저장: 각 연산의 결과를 리스트에 저장합니다.

잘못된 입력 처리: 양의 정수가 아닌 값이나 잘못된 연산 기호 입력 시 예외 처리 기능을 제공합니다.

계산기 종료 기능: "exit"를 입력하면 프로그램이 종료됩니다.

실행 방법

Java가 설치된 환경에서 Main.java 파일을 실행합니다.

콘솔에서 첫 번째 정수, 두 번째 정수를 입력합니다.

연산 기호 (+, -, *, /)를 입력합니다.

결과가 출력되며, 계산을 계속 진행할지 여부를 선택할 수 있습니다.

프로그램을 종료하려면 "exit"을 입력합니다.

코드 설명

1. Main.java

Scanner를 이용하여 사용자 입력을 받습니다.

Calculator 객체를 생성하여 연산을 수행합니다.

잘못된 입력(음수 입력, 0으로 나누기, 잘못된 연산 기호 등)에 대한 예외 처리가 포함되어 있습니다.

사용자가 "exit"을 입력하면 프로그램이 종료됩니다.

2. Calculator.java

사칙연산(+, -, *, /)을 수행하는 메서드를 포함합니다.

계산 결과를 List<String>에 저장합니다.

저장된 결과를 삭제할 수 있는 delResult() 메서드가 포함되어 있습니다.

예제 실행

첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): 10
두 번째 숫자를 입력해 주세요(양의 정수(0포함)): 5
연산 기호를 입력해 주세요(+,-,x,/): +
연산 결과는 15입니다.
계산기를 종료하시겠습니까?(종료하시기를 원하시면 "exit"를 입력해주세요)
exit
계산기가 종료되었습니다.