import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekjoonAlgo_1260 {

	static int n;
	static int m;
	static int v;
	static int[] visitDFS;
	static int[] visitBFS;
	static int[][] ar; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		visitDFS = new int[1001];
		visitBFS = new int[1001];
		ar = new int[1001][1001];
		
		for(int i=0;i<m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			ar[x][y] = 1;
			ar[y][x] = 1;
		}

		getDFS(v);
		System.out.println("");
		getBFS(v);;
		
	}
	
	// DFS
	private static void getDFS(int node) {
		visitDFS[node] = 1;
		System.out.print(node + " ");
		
		for(int i=1;i<=n;i++) {
			if(ar[node][i] == 1 && visitDFS[i] == 0) {
				getDFS(i);
			}
		}
	}
	
	// BFS
	private static void getBFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(node);
		visitBFS[node] = 1;
		
		while(!(q.isEmpty())) {
			int pollNode = q.poll();
			System.out.print(pollNode + " ");
			for(int i=1;i<=n;i++) {
				if(ar[pollNode][i] == 1 && visitBFS[i] == 0) {
					visitBFS[i] = 1;
					q.offer(i);
				}
			}
		}
	}
}
