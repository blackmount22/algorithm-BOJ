package baekjoonPjt;

import java.util.Scanner;

public class Baekjoon11724 {

	static int n;
	static int m;
	static int[][] map;
	static int[] visit;
	static int cnt =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n+1][n+1];
		visit = new int[n+1];
		
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		for(int i=1;i<n+1;i++) {
			if(visit[i] != 1) {
				getConnected(i);
				cnt++;				
			}
		}
		
		System.out.println(cnt);
	}

	public static void getConnected(int x) {
		visit[x] = 1;
		
		for(int y=1;y<n+1;y++) {
			if(map[x][y] == 1 && visit[y] != 1) {
				getConnected(y);
			}
		}
	}
}
