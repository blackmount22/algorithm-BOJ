import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int crossTotalCnt = 1 ;
		int maxNum = 0;
		
		while(true) {
			if(x <= crossTotalCnt + maxNum) {
				if(crossTotalCnt % 2 == 0) {
					System.out.println((x - maxNum) + "/" + (crossTotalCnt - (x - maxNum -1 ))) ;
					return;
				} else {
					System.out.println((crossTotalCnt - (x - maxNum -1 )) + "/" + (x - maxNum)) ;
					return;
				}	
			}
			else {
				maxNum += crossTotalCnt;
				crossTotalCnt++;
			}
		}
		
	}

}
