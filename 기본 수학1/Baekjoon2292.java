import java.util.Scanner;

public class BaekjoonAlgo_2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 1;
		int start = 1;
		
		if(n == 1 ) {
			System.out.println(result);
			return;
		}

		for(int i=1;i<=n;i++) {
			int m = 6 * i;
			
			start += m;

			if(n <= start) {
				result += i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
