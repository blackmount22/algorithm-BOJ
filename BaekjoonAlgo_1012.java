import java.util.ArrayList;
import java.util.Scanner;

public class BaekjoonAlgo_1012 {

	static int tc;
	static int[][] map;
	static int[][] visit;
	static int m;
	static int n;
	static int bc;
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> answer = new ArrayList<>();
		
		tc= sc.nextInt();
		
		while(tc > 0) {
			
			cnt =0;
			m = sc.nextInt();
			n = sc.nextInt();
			bc = sc.nextInt();
			
			map = new int[m][n];
			visit = new int[m][n];
			
			for(int i=0;i<bc;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				map[x][y] = 1;
			}
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == 1 && visit[i][j] == 0 ) {
						getDFS(i, j);
						cnt++;
					}
				}
			}
			
			answer.add(cnt);
			
			tc--;
		}
		
		for(int i=0;i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		
	}
	
	public static void getDFS(int x, int y) {
		int[] xx = {-1,0,1,0};
		int[] yy = {0,1,0,-1};
		
		visit[x][y] = 1;
		
		for(int i=0;i<4;i++) {
			int ax = x + xx[i];
			int ay = y + yy[i];
			
			if(ax >=0 && ay >=0 && ax<m && ay<n && map[ax][ay] == 1 && visit[ax][ay] == 0) {
				getDFS(ax, ay);
			}
		}
	}

}
