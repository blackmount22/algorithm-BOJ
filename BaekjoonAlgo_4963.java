import java.util.ArrayList;
import java.util.Scanner;

public class BaekjoonAlgo_4963 {

	static int w;
	static int h;
	static int[][] map;
	static int[][] visit;
	static ArrayList<Integer> result = new ArrayList<>();
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			cnt =0;
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w == 0 && h== 0) {
				for(int i=0;i<result.size();i++) {
					System.out.println(result.get(i));
				}
				
				return;
			}
			
			map = new int[w][h];
			visit = new int[w][h];
			
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					if(map[i][j] == 1 && visit[i][j] == 0) {
						getDFS(i, j);
						cnt++;
					}
				}
			}
			
			result.add(cnt);
		}
	}
	
	public static void getDFS(int x, int y) {
		int[] xx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] yy = {0, 1, 1, 1, 0, -1, -1, -1};
		
		visit[x][y] = 1;
		
		for(int i=0;i<8;i++) {
			int ax = x + xx[i];
			int ay = y + yy[i];
			
			if(ax >= 0 && ay>=0 && ax<w && ay < h && visit[ax][ay] == 0 && map[ax][ay] == 1) {
				getDFS(ax, ay);
			}
		}
		
	}

}
