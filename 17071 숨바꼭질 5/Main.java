// import java.util.*;

// class Point{
//     int x;
//     int cost;
//     int kx;
//     Point(int x, int cost, int kx){
//         this.x=x;
//         this.cost=cost;
//         this.kx=kx;
//     }
// }

// class Main{
//     static int min = -1;
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         boolean[] visited = new boolean[1000001];
        
//         int N = sc.nextInt();
//         int K = sc.nextInt();
//         int co=0;
//         if(N>K){
//             while(true){
//                 if(N-1>=0 && K+co+1<=500000 && N>K && N-1>K+co+1){
//                     N-=1;
//                     K+=co+1;
//                     co+=1;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
        
        
//         Queue<Point> qu = new LinkedList<>();
//         qu.add(new Point(N,co,K));
//         while(!qu.isEmpty()){
//             Point tmp = qu.poll();
//             visited[tmp.x]=true;
//             if(tmp.x<0 || tmp.x>500000 || tmp.kx>500000){
//                 continue;
//             }
                
//             if(tmp.x==tmp.kx){
//                 if(min<0){
//                     min=tmp.cost;
//                 }
//                 else if(min>tmp.cost){
//                     min=tmp.cost;
//                 }
//                 break;
//             }
            
            
             
//             if(tmp.x*2<=500000 && !visited[tmp.x*2] && tmp.kx+tmp.cost+1<=500000){
//                 qu.add(new Point(2*tmp.x,tmp.cost+1,tmp.kx+tmp.cost+1));
//             }
                
//             if(tmp.x+1<=100000 && !visited[tmp.x+1] && tmp.kx+tmp.cost+1<=500000){
//                 qu.add(new Point(tmp.x+1,tmp.cost+1,tmp.kx+tmp.cost+1));
//             }
                
//             if(tmp.x-1>=0 && !visited[tmp.x-1] && tmp.kx+tmp.cost+1<=500000){
//                 qu.add(new Point(tmp.x-1,tmp.cost+1,tmp.kx+tmp.cost+1));
//             }
            
//         }
        
        
//         System.out.println(min);
//     }
// }

import java.util.*;

public class Main {

	private static class Node {
		int index, step;

		Node(int index, int step) {
			this.index = index;
			this.step = step;
		}
	}

	static int time = 0, dest;
	static Queue<Node> q = new LinkedList<>();
	static int[] map = new int[500001];
	static boolean[][] visit = new boolean[1000002][2];
    //미리 동생이 언제쯤 특정 지점에 도착하는데 수빈이가 그 자리에 일찍이 도착하면 -1과 1로 비비면 그 자리에 계속 있을 수 있으니 2차원 배열

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		q.add(new Node(input.nextInt(), 0));
		visit[q.peek().index][0] = true;
		dest = input.nextInt();
		Arrays.fill(map, -1);
		int time = 0;
		while (true) { // 동생좌표부터 쭉 뿌려줌
			dest += time;
			if (dest > 500000) break;
			map[dest] = time;
			time++;
		}

		bfs();
		return;

	}

	private static boolean bfs() {
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.step > min) {
				break;
			}
			if (map[n.index] != -1 && map[n.index] >= n.step) { // 동생이 도착할 곳과 수빈이가 동생보다 그 지점에 먼저 도착할 경우
				if (Math.abs(map[n.index] - n.step) % 2 == 0) { //-1과 1 스텝을 계속 쓰면서 수빈이가 그 지점에 도착할 시점에 수빈이도 그 지점에 있을 수 있는가
					min = Math.min(min, map[n.index]); //동생이 도착한 시간이 더 늦으니 동생 시간과 비교
				}
			}

			for (int i = 0; i < 3; i++) {
				int nx = nextNum(n.index, i);
				if (nx > 500000) {
					break;
				}
				if (nx >= 0 && !visit[nx][n.step % 2]) {
					visit[nx][n.step % 2] = true;
					q.add(new Node(nx, n.step + 1));
				}
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : (min));
		return true;

	}

	private static int nextNum(int num, int dir) {
		switch (dir) {
		case 0:
			return num + 1;
		case 1:
			return num - 1;
		case 2:
			return num * 2;
		}
		return -1;
	}

}