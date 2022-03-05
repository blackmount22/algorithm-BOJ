import java.util.Scanner;

public class BaekjoonAlgo_1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] arr = new char[26];
		
		for(int i=0;i<str.length();i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				arr[str.charAt(i) - 'A']++;
			} else {
				arr[str.charAt(i) - 'a']++;
			}
		}
		
		int max = -1;
		char finalChar = '?';
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
				finalChar = (char)(i+65);
			}
			else if(arr[i] == max) {
				finalChar = '?';
			}
		}
		
		System.out.println(finalChar);
	}

}
