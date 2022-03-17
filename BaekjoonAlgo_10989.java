import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekjoonAlgo_10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append('\n');
		}
		
		// ArrayList > Collections.Sort = 시간 초과
		// 배열 > Arrays.Sort = 시간초과
		// 입력 Scanner 아닌 BufferedReader 처리
		// 출력 StringBuilder 처리 
		
		// Scanner 보단 BufferedReader
		// for문 출력 보단 StringBuilder 생성 후 출력
		
		System.out.println(sb);
	}

}
