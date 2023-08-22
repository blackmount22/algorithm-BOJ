import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	static int n;
	static int m;
	static int v;
	static int[][] map;
	static int[] visit;
	static int[] visitBfs;
	
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt(); 	// 탐색 시작 정점
		
		map = new int[n+1][n+1];
		visit = new int[n+1];
		visitBfs = new int[n+1];
		
		q = new LinkedList<Integer>();
		
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		System.out.print(v + " ");
		getDfs(v);
		System.out.println();
		getBfs();
	}
	
	public static void getDfs(int x) {
		visit[x] = 1;
		
		for(int i=1;i<=n;i++) {
			//System.out.println("i : " + i);
			if(map[x][i] == 1 && visit[i] == 0 ) {
				System.out.print(i  + " ");
				getDfs(i);
			}
		}
	}
	
	public static void getBfs() {
		q.add(v);
		visitBfs[v] = 1;
		
		System.out.print(v + " ");
		
		while(q.size() > 0) {
			
			int x = q.poll();
			
			for(int i=1;i<=n;i++) {
				if(map[x][i] == 1 && visitBfs[i] == 0) {
					//System.out.println("("+x+","+i+")");
					System.out.print(i + " ");
					visitBfs[i] = 1;
					q.add(i);
				}
			}
		}
	}

}
