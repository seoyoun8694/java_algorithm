## 💡 퀵 정렬

### ✔️ 퀵 정렬
- **퀵 정렬**: 기준값을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘
- -> 평균적인 시간 복잡도는 O(nlogn) _ **기준값**이 어떻게 선정되는지가 시간 복잡도에 많은 영향을 미침

***

### ✔️ 퀵 정렬의 핵심 이론
- 기준값(pivot)을 중심으로 계속 데이터를 2개의 집합으로 나누면서 정렬하기

***

### 🚩 퀵 정렬 과정
1. 데이터를 분할하는 pivot을 설정한다.
   
3. pivot을 기준으로 다음 과정을 거쳐 데이터를 2개의 집합으로 분리한다.
   
   2-1) start가 가리키는 데이터가 privot이 가리키는 데이터보다 작으면 start를 오른쪽으로 1칸 이동한다.
   
   2-2) end가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 end를 왼쪽으로 1칸 이동한다.
   
   2-3) start가 가리키는 데이터가 pivot이 가리키는 데이터보다 크고, end가 가리키는 데이터가 pivot이 가리키는 데이터보다 작으면 start, end가 가리키는 데이터를 swap하고 start는 오른쪽, end는 왼쪽으로 한칸씩 이동한다.

   2-4) start와 end가 만날때 까지 2-1 ~ 2-3 과정을 반복한다.

   2-5) start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여 pivot이 가리키는 데이터가 크면 만난 지점의 오른쪽에, 작으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입한다..

3. 분리 집합에서 각각 다시 pivot을 선정한다.
4. 분리 집합이 1개 이하가 될 떄까지 과정 1~3을 반복한다.
   
