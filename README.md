# 계산기 프로그램

## 소개

- 이 프로그램은 Java로 구현된 간단한 콘솔 기반 계산기입니다. 사용자는 두 개의 양의 정수를 입력하고, 사칙연산(+, -, \*, /)을 수행할 수 있습니다. 연산 결과는 리스트에 저장되며, 프로그램이 종료될 때까지 여러 번 계산할 수 있습니다.

- 각각의 입력마다 whlie을 사용하여 숫자 및 연산자를 입력받을 때 잘못된 입력을 받으면 다시 입력받도록 작성했습니다.

- ArithmeticCalculator클래스를 생성하여 모든 연산은 해당 클래스이서 이루어지도록 하였습니다.
- private를 사용하여 결과값에는 접근하지 못하도록 하였고 Getter, Setter를 사용하여 결과값을 저장한 리스트에는 접근이 가능하도록 하였습니다.
- 제네릭을 사용하여 int뿐만 아니라 double타입을 입력받아도 정상적으로 작동하도록 하였습니다.
- enum을 사용하여 연산자들을 관리하도록 하였습니다.
- 스트림과 람다식을 이용하여 기존 계산결과들 중 입력받은 수 보다 높은 수들을 리스트로 뽑을수 있도록 하였습니다.

## 기능

1. **덧셈**: 두 개의 정수를 더합니다.
2. **뺄셈**: 첫 번째 정수에서 두 번째 정수를 뺍니다.
3. **곱셈**: 두 개의 정수를 곱합니다.
4. **나눗셈**: 첫 번째 정수를 두 번째 정수로 나눕니다. (단, 두 번째 정수가 0이면 오류 메시지 출력)
5. **계산 결과 저장**: 각 연산의 결과를 리스트에 저장합니다.
6. **잘못된 입력 처리**: 양의 정수가 아닌 값이나 잘못된 연산 기호 입력 시 예외 처리 기능을 제공합니다.
7. **계산기 종료 기능**: 사용자에게 종료여부를 물어본 후 "yes"을 입력하면 프로그램이 종료됩니다
8. **저장된 계산기록들 중 입력받은 숫자보다 높은 숫자들을 목록으로 출력하기**: 스트림과 람다를 사용하여 연산기록들 중에서 특성 조건을 만족하는 목록을 출력합니다.

## 코드 설명

### 1. `Main.java`

- `Scanner`를 이용하여 사용자 입력을 받습니다.
- `service.impl.ArithmeticCalculatorImpl` 객체를 생성하여 연산을 수행합니다.
- 잘못된 입력(음수 입력, 0으로 나누기, 잘못된 연산 기호 등)에 대한 예외 처리가 포함되어 있습니다.
- 가장 오래된 기록, 저장된 연산 결과들 중 입력받은 값보다 큰 결과값들 출력이 가능합니다.
- 사용자에게 종료여부를 물어본 후 "yes"을 입력하면 프로그램이 종료됩니다.

### 2. `service.impl.ArithmeticCalculatorImpl.java`

- 사칙연산(+, -, \*, /)을 enum으로 관리합니다.
- Main.java에서 cal.calculate를 통해 전달받은 operatorType에 따라 연산을 수행합니다.
- 계산 결과를 `List<Double>`에 저장합니다.
- 저장된 결과를 삭제할 수 있는 `delResult()` 메서드가 포함되어 있습니다.
- 특정 조건을 만족하는 리스트를 뽑을수 있는 `getBiggerList()` 메서드가 있습니다.
- 저장된 결과들을 가져올수 있는 `getResultList()`가 있습니다.
- 계산 횟수를 가져오는 `getCount()`가 있습니다.

## 예제 실행

```
첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): -1
양의 정수를 입력해 주세요
첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): 1
두 번째 숫자를 입력해 주세요(양의 정수(0포함)): -2
-2.0
양의 정수를 입력해 주세요
두 번째 숫자를 입력해 주세요(양의 정수(0포함)): 2
2.0
연산 기호를 입력해 주세요(+,-,x,/): x
계산 결과는 2.0입니다.
1.0 번 계산하셨습니다.
계산 기록 : [2.0]
가장 오래된 기록을 삭제하시겠습니까? (삭제를 원하시면 yes를 입력해주세요)
no
저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : 
no
계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)
no
첫 번째 숫자를 입력해 주세요(양의 정수(0포함)): 1
두 번째 숫자를 입력해 주세요(양의 정수(0포함)): 2
2.0
연산 기호를 입력해 주세요(+,-,x,/): +
계산 결과는 3.0입니다.
2.0 번 계산하셨습니다.
계산 기록 : [2.0, 3.0]
가장 오래된 기록을 삭제하시겠습니까? (삭제를 원하시면 yes를 입력해주세요)
yes
저장된 연산 결과들 중 입력받은 값보다 큰 결과값 들 출력하기(확인할 값을 입력해주세요) : 
1
[3.0]
계산기를 종료하시겠습니까?(종료를 원하시면 yes를 입력해주세요)
yes
계산기가 종료되었습니다.
```