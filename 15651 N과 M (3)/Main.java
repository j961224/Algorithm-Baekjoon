import java.util.Arrays;
import java.util.Scanner;
//1번째 중복순열 방법
public class Main{
	
	private static int n, m;
	//private static int[] map;
	private static int[] result;
	private static boolean[] visit;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		result = new int[m];
		visit = new boolean[n+1];
		
		cycle(0);
		System.out.println(sb);
	}

	private static void cycle(int start) {
		
		if (start == m) {
			for (int i=0; i<result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		} 
		else {
			
			for (int i=0; i<n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					result[start] = i+1;
					visit[i] = false;
					cycle(start+1);
				}
			}
		}
		
	}
}

//2번째 중복순열 방법

// import java.util.Scanner;
// public class Main {
// public static int[] arr;
// public static int N, M;
// public static StringBuilder sb = new StringBuilder();
// public static void main(String[] args) {
// Scanner in = new Scanner(System.in);
// N = in.nextInt();
// M = in.nextInt();
// arr = new int[M];
// dfs(0);
// System.out.print(sb);
// }
// public static void dfs(int depth) {
// // 깊이가 M이랑 같아지면 출력후 return
// if (depth == M) {
// for (int i = 0; i < M; i++) {
// sb.append(arr[i] + " ");
// }
// sb.append('\n');
// return;
// }
// for (int i = 1; i <= N; i++) {
// arr[depth] = i;
// dfs(depth + 1);
// }
// }
// }
