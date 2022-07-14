빙산이 2개 이상의 덩어리로 분리될때의 년도 Count를 구하는 문제이다.

풀이 접근 방법은 먼저 

(1) dfs로(bfs로도 적용할 수 있다) 덩어리 Count를 구하는 부분과,

(2) 1년이란 시간이 흘렀을때 빙산의 변화된 모습을 Map[n][m] 에 어떻게 처리할지를 고민했다.

위 두 가지 케이스 처리를 위해 (1), (2) 번을 2덩어리로 분리될때까지 while문으로 감싸서 처리했다.

일단 2덩어리로 분리되는 dfs 풀이는 정말 기본 적인 dfs 재귀함수를 통해 재귀함수가 종료될때 

덩어리 Count+1 을 해주었다.

```jsx
//divCnt : 빙산 덩어리 Count

for(int i=0;i<n;i++) {
	for(int j=0;j<m;j++) {
		if(map[i][j] > 0 && visit[i][j] == 0) {
			flag = true;
			GetDFS(i, j);
			divCnt++;
		}
	}
}

// 분리된 빙산 체크
public static void GetDFS(int x, int y){
	visit[x][y] = 1;
	
	int[] xx = {-1, 0, 1, 0};
	int[] yy = {0, 1, 0 ,-1};
	
	for(int i=0;i<4;i++) {
		int ax = x + xx[i];
		int ay = y + yy[i];
		
		if(ax >= 0 && ay >= 0 && ax<n && ay<m && map[ax][ay] > 0 && visit[ax][ay] == 0 ) {
			GetDFS(ax, ay);
		}
	}
}
```

빙산의 1년 후 모습은 동,서,남,북 방면의 ‘0’ 개수만큼 melt[n][m] 배열에 +1씩 해주고

실제 빙산 지도에서 melt[n][m] 를 빼주는 방식으로 처리하였다.

```jsx
// 녹는거 처리
for(int i=0;i<n;i++) {
	for(int j=0;j<m;j++) {
		if(map[i][j] > 0) {
			for(int k=0;k<4;k++) {
				int ax = i + xx[k];
				int ay = j + yy[k];
				
				if(ax>=0 && ay>=0 && ax<n && ay<m && map[ax][ay] == 0) {
					melt[i][j]++;
				}
			}
		}
	}
}

for(int i=0;i<n;i++) {
	for(int j=0;j<m;j++) {
		if(melt[i][j] > 0) {						
			map[i][j] = map[i][j] - melt[i][j] < 0 ? 0 : map[i][j] - melt[i][j];
		}
	}
}
```

이제 

(1) dfs로(bfs로도 적용할 수 있다) 덩어리 Count를 구하기

(2) 1년이란 시간이 흘렀을때 빙산의 변화된 모습을 Map[n][m] 처리

(1), (2) 번을 모두 처리하였으며, 문제에서 주어진

‘만일 전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력한다.’

처리는 flag 변수를 통해 처리했다.

[풀이]

```jsx
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2573 {

	static int n;
	static int m;
	static int[][] map;
	static int[][] visit;
	static int[][] melt; 
	static int year = 0;

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		int[] xx = {-1, 0, 1, 0};
		int[] yy = {0, 1, 0, -1};
		
		// 빙산 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = true;
		
		while(true) {
			visit = new int[n][m];
			melt = new int[n][m];
			int divCnt = 0;
			
			// 분리 체크
			flag = false;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] > 0 && visit[i][j] == 0) {
						flag = true;
						GetDFS(i, j);
						divCnt++;
					}
				}
			}
			
			if(divCnt > 1) {
				System.out.println(year);
				return;
			}
			
			if(!flag) {
				System.out.println(0);
				return;
			};
			
			// 녹는거 처리
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] > 0) {
						for(int k=0;k<4;k++) {
							int ax = i + xx[k];
							int ay = j + yy[k];
							
							if(ax>=0 && ay>=0 && ax<n && ay<m && map[ax][ay] == 0) {
								melt[i][j]++;
							}
						}
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(melt[i][j] > 0) {						
						map[i][j] = map[i][j] - melt[i][j] < 0 ? 0 : map[i][j] - melt[i][j];
					}
				}
			}
			
			year++;
			
		}
	}
	
	// 분리된 빙산 체크
	public static void GetDFS(int x, int y){
		visit[x][y] = 1;
		
		int[] xx = {-1, 0, 1, 0};
		int[] yy = {0, 1, 0 ,-1};
		
		for(int i=0;i<4;i++) {
			int ax = x + xx[i];
			int ay = y + yy[i];
			
			if(ax >= 0 && ay >= 0 && ax<n && ay<m && map[ax][ay] > 0 && visit[ax][ay] == 0 ) {
				GetDFS(ax, ay);
			}
		}
	}

}
```
