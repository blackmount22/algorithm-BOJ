while문을 통해 처음 문제를 접근하였지만, 기본 수학 문제로 반복문이 아닌 식을 통해 문제를 풀도록 유도 하는 문제이다.

while문 등 아래와 같이 반복문을 통해 풀게 될 경우 문제의 조건인 (1 ≤ B < A ≤ V ≤ 1,000,000,000)

10억이란 숫자로 반복문을 처리할 경우 시간 초과가 발생한다.

```java

		int cur = 0;
		int days = 1;
		
		while(true) {
			cur = cur + a;

			if(cur >= v) {
				System.out.println(days);
				return;
			}
			
			cur = cur -b;
			days++;
		}
```

즉, 수학적 접근으로 아래와 같은 식을 만들 수 있다.

**V(나무 막대 높이) / A(오르는 높이) - B (내려가는 높이)**

하지만, 위와 같은 식을 처리할 경우 ‘**또, 정상에 올라간 후에는 미끄러지지 않는다.’**

를 고려해서 식을 바꿔주어야한다.

여기서 접근한 방식은, 높이에서 - 내려가는 높이를 뺀 후, 하루를 올라야하는지 아니면 정상에 도달했는지를 구하는 방식으로 처리하였다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekjoonAlgo_2869 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		
		int days = (v-b) / (a - b);
		
		if(((v-b) % (a - b)) != 0) {
			days++;
		}
		
		System.out.println(days);
	}
}
```

- 추가적으로 Java11에서는 Scanner로 처리 시 시간초과가 발생하여 BufferedReader로 변경하여 제출하였다.
