import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int n;
	static int[] visit;
	static int[] parent;
	static ArrayList<Integer>[] ar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		ar = new ArrayList[n+1];
		visit = new int[n+1];
		parent= new int[n+1];
		
		for(int i=1;i<=n;i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			ar[x].add(y);
			ar[y].add(x);
		}

		for(int i=1;i<=n;i++) {
			if(visit[i] == 0) {
				getDfs(i);
			}
		}
		
		for(int i=2;i<=n;i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void getDfs(int node) {
		if(visit[node] == 1) return;
		
		visit[node] = 1;
		
		for(int y : ar[node]) {	
			if(visit[y] == 0) {
				parent[y] = node;
				getDfs(y);
			}
		}
	}
}
