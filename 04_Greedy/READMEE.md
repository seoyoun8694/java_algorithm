## 💡 그리디 알고리즘

### ✔️ 그리디 알고리즘
**그리디 알고리즘**: 현재 상태에서 보는 선택지 중 최선의 선택지가 전체 선택지 중 최선의 선택지라고 가정하는 알고리즘 -> 선택의 순간마다 당장 눈앞에 보이는 최적의 상황만을 쫓아 최종적인 해답에 도달

-> 순간마다 하는 선택은 그순간에 대해 **지역적으로는 최적**이지만, 그 선택들을 계속 수집하여 최종적(전역적)인 해답을 만들었다고 해서, 그것이 **최적이라는 보장은 없다.**

-> but 그리디 알고리즘을 적용할 수 있느 문제들은 지역적으로 최적이면서 전역적으로 최적인 문제들 ~~== 매트로이드~~

1. 그리디 알고리즘을 사용해도 항상 최적해를 구할 수 있는 문제를 만난 경우, 그리디 알고리즘은 동적 계획법보다 수행 시간이 훨씬 빠르기 때문에 유용하다.
2. 시간이나 공간적 제약으로 인해 ㅏ른 방법으로 최적해를 찾기 너무 어렵다면, 최적해 대신 적당히 괜찮은 답(근사해)를 찾는 것으로 타협 가능하다. -> 임의의 답보다는 좋은 답을 구하는 용도로 사용

***

### 🚩 그리디 알고리즘 수행 과정
- 1. 선택 절차(Selection Procedure) _ 해 선택: 현재 상태에서 최적의 해답을 찾는다.

- 2. 적절성 검사(Feasivility Check): 현재 선택된 해가 문제의 조건에 벗어나지 않는지 검사한다.

- 3. 해답 검사(Solution Check) _ 해 검사: 원래의 문제가 해겨뢰었는지 검사하고, 해결되지 않았다면 선택 절차로 돌아가 위(1~2) 과정들을 반복한다.

***

### ❕ 그리디 알고리즘 2가지 조건 _ 정당성 증명
1. 탐욕적 선택 속성(Greedy Choice Property): 앞의 선택이 이후의 선택에 영향을 주지 않는다.
2. 최적 부분 구조(Optimal Substructure): 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성 된다.

-> 두 조건이 성립하지 않으면 그리디 알고리즘은 최적해를 구하지 못하지만, 근사 알고리즘으로 사용 가능하며 대부분의 경우 계산 속도가 빠르기 때문에 실용적으로 사용 가능하다.

- +) 매트로이드: 어떤 특별한 구조가 있는 문제에 대해 그리디 알고리즘이 최적해를 찾아내는 것, 모든 문제에서 나타나는 것은 아니지만 여러 곳에서 발견됨.

- +) 근사 알고리즘: 어떤 최적화 문제에 대한 해의 근사값을 구하는 알고리즘. -> 가장 최적화되는 답을 구할 수는 없지만, 비교적 빠른 시간에 계산 가능하며 어느 정도 보장된 근사해를 계산할 수 있다.

- +) 메타휴리스틱 알고리즘: 목적 함수를 미분할 수 있다는 가정을 사용하지 않는 최적화 알고리즘
