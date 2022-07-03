import java.util.Scanner;

public class BaekjoonAlgo_10872 {

	static int result = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		refact(n);
		
		System.out.println(result);
	}
	
	public static void refact(int x) {
		if(x > 0) {
			result *=x;
			refact(x-1);
		}
	}
}
