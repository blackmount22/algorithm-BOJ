import java.util.Scanner;

public class BaekjoonAlgo_5622 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] arr = str.toCharArray();
		
		int result = 0;
		
		for(int i=0;i<arr.length;i++) {
			if((int)arr[i] <68) result +=3;
			else if((int)arr[i] < 71) result +=4;
			else if((int)arr[i] < 74) result +=5;
			else if((int)arr[i] < 77) result +=6;
			else if((int)arr[i] < 80) result +=7;
			else if((int)arr[i] < 84) result +=8;
			else if((int)arr[i] < 87) result +=9;
			else if((int)arr[i] < 91) result +=10;
		}
		
		System.out.println(result);
	}
}
