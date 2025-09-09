

# [Goorm Party 1](https://level.goorm.io/exam/352227/goorm-party/quiz/1)

> 쉬움

> 유형 프로그래밍 배점 100점 제출 완료 참여자 17 정답률 76.4%

## 문제

N개의 섬과 M개의 왕복 다리로 이루어진 구름 군도가 있습니다. 섬은 1번부터 N번 섬으로 불리고, i번 섬에는 P, 명의 사람이 살고 있습니다.

구름 군도에서는 매년 구름 파티가 1번 섬에서 개최됩니다. 이때 왕복 다리만 이용하여 1번 섬에 모일 수 있는 사람의 수를 알아보자.

## 입력

첫째 줄에 섬의 개수 N과 다리의 개수 이 공백을 두고 순서대로 주어진다.

둘째 줄에 1번 섬에 살고 있는 사람의 수 P가 순서대로 주어진다.

그 다음 MM 줄에 걸쳐서 다리의 상태가 s, e가 주어진다. 이는 S번 섬과e번 섬이 왕복 다리로 이어져 있음을 의미한다.

- ﻿﻿1≤N≤ 2000
- ﻿1≤MS 10000
- ﻿﻿1 ≤ Pi ≤ 100
- ﻿﻿15s,e≤N
- ﻿﻿입력으로 주어지는 모든 수는 정수이다

## 출력

1번 섬에 모이는 사람의 수를 출력하시오.

### 예시1

```
5 3
1 2 3 4 5
1 3
4 5
2 3
```

```
6
```

### 예시2

```
7 4
1 2 3 4 5 6 7
1 7
2 7
4 7
5 7
```

```
19
```

---



## Solution

### v1 (dfs)

```java
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력값 처리 : 섬과 다리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int totalIsland = Integer.parseInt(st.nextToken());
		int totalBridge = Integer.parseInt(st.nextToken());

		// 입력값 처리 : 섬의 주민 수
		st = new StringTokenizer(br.readLine());
		int[] peopleArr = new int[totalIsland + 1];
		for (int i = 1; i < totalIsland + 1; i++) {
			peopleArr[i] = Integer.parseInt(st.nextToken());
		}

		// 입력값 처리 : 간선 정보
		ArrayList<Integer>[] tree = new ArrayList[totalIsland + 1];
		for (int i = 1; i <totalIsland + 1; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 0; i <totalBridge; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			tree[start].add(end);
			tree[end].add(start);
		}

		// 방문 여부를 포함해 dfs 수행
		boolean[] visited = new boolean[totalIsland + 1];
		int count = dfs(tree, peopleArr, visited, 1);

		// 결과
		System.out.print(count);
	}

	private static int dfs(ArrayList<Integer>[] tree, int[] peopleArr, boolean[] visited, int num) {
		visited[num] = true;
		int count = peopleArr[num];

		for (int island : tree[num]) {
			if (visited[island] == false) {
				visited[island] = true;
				count += dfs(tree, peopleArr, visited, island);
			}
		}

		return count;
	}
}


  // 1   2  
  //  \  /
  //   3   4 - 5
```

