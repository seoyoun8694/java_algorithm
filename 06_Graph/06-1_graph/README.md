## 💡 그래프의 표현

## 1️⃣ 에지 리스트
**에지 리스트**: 에지를 중심으로 그래프 표현, 배열에 `출발 노드, 도착 노드` & `출발 노드, 도착 노드, 가중치`를 저장하여 에지를 표현한다.

- 그래프의 모든 간선을 piar<int,int>형 일차원 배열에 저장한다.
- 정점 x에서 y로 가는 간선이 존재한다면, 배열에 (x,y)를 저장한다. -> 순서는 중요하지 않음!
- 인접 리스트와 인접 행렬을 모두 사용할 수 없는 경우 사용 (== STL, Array collection 등을 사용할 수 없는 경우)
- 하나의 배열을 이용하여 모든 간선을 저장하고, 누적합을 저장한 다른 배열로 한 정점의 간선이 저장된 index의 범위를 알려주도록 한다.

***

1. **가중치 없는 그래프(무방향 그래프) 표현하기** -> 양쪽 모두로 방향이 있다고 생각하고 xy를 바꿔서 두 번 씩 저장해도 되지만 효율적으로 간선 당 한 번 씩만 저장하고 처리할 때 고려해서 처리 하는 게 훨씬 효율적임

-> == `(x,y)`를 `x, y 사이에 간선이 있다`, 즉 `x에서도 y로 갈 수 있고 y에서도 x로 갈 수 있다`고 처리

  - 출발 노드와 도착 노드만 표현하므로 배열의 행은 2개이다.
  - 노드는 여러 자료형을 사용 가능하다.

2. **가중치 있는 그래프 표현하기** -> pair형의 일차원 배열에 저장하는 대신 tuple형의 일차원 배열에 저장 == 정점x에서 y로 가는 가중치가 w인 간선이 존재한다면 배열에 **(x,y,w)**를 저장

***

### ✔️ 에지 리스트 특징
- **장점**
  - 구현이 가장 간단하다.
  - 모든 간선을 탐색할 때 유리하다. -> *`벨만 포드 & 크루스칼(MST) 알고리즘`* 에 사용
 
- **단점**
  - 특정 두 노드가 이웃한지 알아보려면 모든 간선을 탐색해야 한다.
  - 특정 노드에 연결된 간선을 알아보려면 모든 간선을 탐색해야 한다.
 
***

## 2️⃣ 인접 행렬
**인접 행렬**: 그래프의 연결 관계를 이차원 배열로 나타내는 방식, `노드 중심`으로 그래프를 표현함

-> dj[][]라고 한다면 adj[i][j] =  노드 i에서 노드 j로 가는 간선이 있으면 1, 아니면 0

~~+) 만약 간선에 가중치가 있는 그래프라면 1 대신에 가중치의 값을 직접 넣어주는 방식으로 구현 가능~~

***

1. **유향 그래프 표현하기**

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F21029250584C0F2413)

2. **무향 그래프 표현하기** -> 노드 i에서 노드 j로 가는 간선이 있다는 말은 노드 j에서 노드 i로 가는 간선도 존재한다는 의미 == 인접 행렬이 대각 성분(adj[i][j]에서 i와 j가 같은 원소들)을 기준으로 대칭인 성질을 가짐

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2405384D584C11BC2E)

***

### ✔️ 인접 행렬의 특징
- **장점**
  - 구현이 쉽다.
  - 노드 i와 노드 j가 연결되어 있는지 확인하고 싶을 때, adj[i][j]가 1인지 0인지만 확인하면 되기 때문에 `O(1)이라는 시간 복잡도`에 확인할 수 있다.
- **단점**
  - 전체 노드의 개수를 V개, 간선의 개수를 E개라고 했을 때, 노드 i에 연결된 모든 노드들에 방문해보고 싶은 경우 adj[i][1]부터 adj[i][V]를 모두 확인해보아야 하기 때문에 총 `O(V)의 시간`이 걸린다. -> 노드 개수에 비해 에지가 적을 때 `공간 효율성`이 떨어짐
  - 노드 개수가 많은 경우 아예 2차원 배열 선언 자체를 할 수 없다. -> 노드가 3만개가 넘어가면 `자바 힙 스페이스 에러`가 발생함

 ***

 ## 3️⃣ 인접 리스트
 **인접 리스트**: 노드 개수만큼 ArrayLIst를 선언함, 그래프의 연결 관계를 vector의 배열(vector<int> adj[])로 나타내는 방식 ->> vector<int>에 노드의 번호가 직접 저장됨

 -> adj[i] = 노드 i에 연결된 노드들을 원소로 갖는 vector (vector의 배열이기 때문에, adj[i]는 vector가 됨)

 ~~만약 간선에 가중치가 있다면, pair<int,int> adj[]를 통해 구현 가능 -> pair<int,int>의 first에는 노드의 번호, second에는 간선의 가중치를 저장해주면 됨~~

 ***

 1. **유향 그래프 표현하기**

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2269874B584C17F301)

-> 위의 그림에서 편의상, 벡터를 링크드 리스트와 같은 형태로 나타냄 ~~(vector는 push_back을 통해 뒤에 원소를 계속 붙일 수 있기 때문에 링크드 리스트의  형태와 비슷하다고 생각하면 편하기 때문)~~

-> 노드 1과 연결된 노드는 노드 2, 3, 4. 총 세 개이다, 따라서 adj[1]의 vector는 총 세 개의 성분을 갖는다. 각각의 성분에 접근하기 위해선 이차원 배열과 같은 방식을 이용하면 된다. (adj[1][0] = 2, adj[1][1] = 3, adj[1][2] = 4, adj[2][0] = 3)

-> 오른쪽의 인접 리스트에서, adj[1]에 있는 **세 노드의 순서는 의미가 없다.** ~~(adj[1]의 노드 2와 노드 3사이에 화살표가 있는 것을 노드 2와 노드 3사이에 간선이 있다는 의미가 아니라 단순히, vector에 노드 3이 노드 2보다 나중에 push_back 되었기 때문)~~

2. **무향 그래프 표현하기**

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F265E074D584C26DD2B)

***

### ✔️ 인접 리스트의 특징
- **장점**
  - **실제로 연결된 노드들에 대한 정보만 저장**하기 때문에, 모든 벡터들의 원소의 개수의 합이 간선의 개수와 같다. == **간선의 개수에 비례하는 메모리만 차지한다.**
  - -> 노드가 V개, 간선이 E개일 떄, 인접 행렬은 `O(V*V)`의 시간복잡도를 가지는 반면, 인접 리스트를 사용하면 **각 노드마다 연결된 노드만 확인하는 것이 가능**하기 때문에, 전체 간선의 개수만큼만 확인해 볼 수 있다. 따라서 `O(E)`의 시간복잡도를 가진다.
  
- **단점**
  - 노드 i와 노드 j가 연결되어 있는지에 대해 알려면 **adj[i]의 벡터 전체를 돌며** j를 성분으로 갖는지 확인해보아야 한다.
  -  -> 인접 행렬의 경우 adj[i][j]가 1인지 0인지만 확인하면 되기 때문에 `O(1)`의 시간 복잡도를 가지지만, 인접 리스트는 `O(V)`의 시간 복잡도를 가진다. 

***

*[참고](https://sarah950716.tistory.com/12)*
