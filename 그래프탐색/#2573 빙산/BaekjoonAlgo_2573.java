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
