import java.util.Scanner;

public class BaekjoonAlgoV2_1520 {

	static int n;
	static int m;
	static int[][] map;
	static int[][] visit;
	static int[][] dp;
	
	static int[] xx = {-1, 0, 1, 0};
	static int[] yy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		map = new int[m][n];
		visit = new int[m][n];
		dp = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dp[m-1][n-1] = 1;
		getDFS(0,0);
		
		System.out.println(dp[0][0]);
		
	}
	
	public static void getDFS(int x, int y) {
		if(x == m-1 && y == n-1) return;
		
		if(visit[x][y] == 1) return;
		
		visit[x][y] = 1;
		
		for(int i=0;i<4;i++) {
			int ax = x+xx[i];
			int ay = y+yy[i];
			
			if(ax >= 0 && ax < m && ay >= 0 && ay<n && map[x][y] > map[ax][ay]) {
				if(dp[ax][ay] != 0) {
					dp[x][y] += dp[ax][ay];
					continue;
				} else {
					getDFS(ax,ay);
					dp[x][y] += dp[ax][ay];
				}
			}
		}
	}

}
