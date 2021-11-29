import java.util.Scanner;

public class BaekjoonAlgo_15650 {

	static int[] arr;
	static int n;
	static int m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		
		getDFS(1, 0);
	}
	
	public static void getDFS(int num, int depth) {
		
		if(depth == m) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=num;i<=n;i++) {
			arr[depth] = i;
			getDFS(i+1, depth+1);
		}
	}

}
