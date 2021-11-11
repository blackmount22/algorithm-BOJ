import java.util.Scanner;

public class BaekjoonAlgo_15649 {

	public static int[] arr;
	public static int[] visit;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		arr = new int[m];
		visit = new int[n];
		
		getDFS(n, m, 0);
	}
	
	public static void getDFS(int n, int m, int depth) {
		
		if(depth == m) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visit[i] == 0) {
				visit[i] = 1;
				arr[depth] = i+1;
				getDFS(n,m,depth+1);
				
				visit[i] = 0;
			}
		}
	}

}
