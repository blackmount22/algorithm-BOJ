import java.util.Scanner;

public class BaekjoonAlgo_1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count= 0;
		
		for(int i=0;i<n;i++) {
			boolean isPrime = true;
			int num = sc.nextInt();
			
			if(num >1) {
				for(int j=2;j<num;j++) {
					if (num%j ==0) {
						isPrime = false;
						break;
					} 
				}			
				
				if(isPrime) count++; 				
			}
		}
		
		System.out.println(count);
	}

}
