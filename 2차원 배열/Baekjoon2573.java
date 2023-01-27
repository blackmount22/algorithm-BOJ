import java.util.Scanner;

public class BOJ2738 {

	static int A[][];
	static int B[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		A = new int[n][m];
		B = new int[n][m];
		int[][] result = new int[n][m];
		
		for(int num=0;num<2;num++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(num == 0 ) A[i][j] = sc.nextInt();
					else if(num == 1) B[i][j] = sc.nextInt();
					
					result[i][j] = A[i][j] + B[i][j];
				}
			}			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(result[i][j]+ " ");
			}
			System.out.println("");
		}
	}

}
