import java.util.Scanner;

public class BaekjoonAlgo_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		
		int result = 0; 
		
		for(int i=0;i<str.length();i++) {
			result += (int)str.charAt(i) - '0';
		}
		
		System.out.println(result);
	}

}
