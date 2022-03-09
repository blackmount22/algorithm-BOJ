import java.util.Scanner;

public class BaekjoonAlgo_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int groupWord = 0;
		
		for(int i=0;i<testCase;i++) {
			String str= sc.next();
			
			boolean[] alpha = new boolean[26];
			char[] arr= str.toCharArray();
			char prev= ' ';
			char now = ' ';
			
			for(int j=0;j<arr.length;j++) {
				now = arr[j];
				
				// 이미 나온 문자 체크
				if(alpha[now -'a']) {
					// 앞글자와 다른 글자면 해당 문자 false 처리
					if(prev != now) {
						alpha[now-'a'] = false;
					}  
				} else {
					alpha[now-'a'] = true;
				}
				
				prev= arr[j];
				
				if(!alpha[now-'a']) break;
				else if(j==arr.length-1) groupWord++;
			}
		}
		
		System.out.println(groupWord);
	}

}