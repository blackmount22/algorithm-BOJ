import java.util.Scanner;

public class BaekjoonAlgo_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[1001];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] = dp[i]%10007;
		}

		if(n == 0) {
			System.out.println(0);
			return;
		} else {
			System.out.println(dp[n]);
		}
	}
}
