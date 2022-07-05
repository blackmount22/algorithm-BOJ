import java.util.Scanner;

public class BaekjoonAlgo_10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String[] result = new String[tc];
		
		for(int i=0;i<tc; i++) {
			
			int idx = 0;
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			while(true) {
				if(idx * h >= n) {
					n = n - ((idx-1)*h);
				
					if(idx < 10) {
						result[i] = String.valueOf(n) + "0" + String.valueOf(idx);
						break;
					}else {
						result[i] = String.valueOf(n) + "" + String.valueOf(idx);
						break;
					}
				}else {
					idx++;
				}
			}
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

}
