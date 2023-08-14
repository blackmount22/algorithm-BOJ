import java.util.Scanner;

public class Main {
	
	static int totalMap = 0;
	static int maxSize = 0;
	static int[][] visit;
	static int[][] map;
	
	static int n;
	static int m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int result2 = 0;
		
		map = new int[n][m];
		visit = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1 && visit[i][j] == 0) {
					maxSize = 0;
					totalMap++;
					getDfs(i, j);
				
					result2 = Math.max(maxSize, result2);
				}
			}
		}
		
		System.out.println(totalMap);
		System.out.println(result2);
	}
	
	public static void getDfs(int x, int y) {
		maxSize++;
		visit[x][y] = 1;
		
		int[] xx = {-1,0,1,0};
		int[] yy = {0,-1,0,1};
		
		for(int i=0;i<4;i++) {
			int ax = x + xx[i];
			int ay = y + yy[i];
			
			if(ax >=0 && ay>=0 && ax < n && ay < m && map[ax][ay] == 1 && visit[ax][ay] == 0) {
				getDfs(ax, ay);
			}
		}
	}

}
