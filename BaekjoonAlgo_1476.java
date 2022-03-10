import java.util.Scanner;

public class BaekjoonAlgo_1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int year = 1;
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		while(true) {
			
			int tempE = year%15 == 0 ? 15 : year%15;
			int tempS = year%28 == 0 ? 28 : year%28;
			int tempM = year%19 == 0 ? 19 : year%19;
			
			if(tempE == E && tempS == S && tempM == M) {
				System.out.println(year);
				return;
			}
			
			year++;
		}
	}

}
