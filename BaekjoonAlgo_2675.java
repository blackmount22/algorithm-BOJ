import java.util.Scanner;

public class BaekjoonAlgo_2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String[] result = new String[tc];
		
		for(int i=0;i<tc;i++) {
			result[i] ="";
			int r = sc.nextInt();
			String s = sc.next();
			
			char[] arr = s.toCharArray();
			
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<r;k++) {
					result[i] += arr[j];					
				}
			}
		}
		
		for(int i=0;i<tc;i++) {
			System.out.println(result[i]);
		}
	}

}
