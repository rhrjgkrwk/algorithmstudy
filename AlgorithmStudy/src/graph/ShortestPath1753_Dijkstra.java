package graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class Dij implements Comparable<Dij>{
	int v;
	int w;
	public Dij(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Dij o) {
		// TODO Auto-generated method stub
		return  o.w - this.w;
	}
}
public class ShortestPath1753_Dijkstra {
	public static final int INF = Integer.MAX_VALUE;
	public static int V; //정점의 개수
	public static int E; //간선의 수
	public static int K; //시작 점.
	public static int d[]; //최단 거리 정보를 담을 배열
	public static boolean visit[]; //최단 거리 정보를 담을 배열
	public static int weight[][]; //최단 거리 정보를 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		d = new int[V+1];
		weight = new int[V+1][V+1];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			weight[a][b]=weight[a][b]>c?c:weight[a][b];
		}
		Arrays.fill(d, INF);
		d[K] = 0;
		dijkstra(K);
		for (int i = 1; i < d.length; i++) {
			System.out.println((d[i]==INF?"INF":d[i]));
		}
		sc.close();
	}
	
	
	public static void dijkstra(int s){
		PriorityQueue<Dij> pq = new PriorityQueue<>();
		pq.add(new Dij(s, d[s]));
		while (!pq.isEmpty()) { 
			int cost = pq.peek().w; //시작점 기준으로 가장 가까운 점을 먼저 pop
			int now = pq.peek().v; 
			pq.poll();
			if (cost>d[now]) {//현재 최단거리보다 크면 고려할 필요 없음.
				continue;
			}
			for (int i = 1; i < weight[now].length; i++) {
				if (weight[now][i]!=0 && d[i] > d[now]+weight[now][i]) { //갈 수 있는 다음 노드를 가져와서 pq에 넣는다.
					d[i] = d[now]+weight[now][i];
					pq.add(new Dij(i,d[i]));
				}
			}			
		}
	}
}

/*
1753번
최단경로 풀이
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	19982	5648	2769	25.373%
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든
 정점으로의 최단 경로를 구하는 프로그램을 작성하시
 오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
 (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지
  번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의
   번호 K(1≤K≤V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 
   각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
   이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
   u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
   서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

예제 입력 
5 6
3
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
예제 출력 
0
2
3
7
INF
*/
/*
#include <cstdio>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
typedef pair<int,int> ii;
vector<ii> v[1111];
const int inf = 1<<30;
int d[1111];
int dijkstra(int st,int ed) {
    fill(d,d+1111,inf);
    priority_queue<ii,vector<ii>,greater<ii> > pq;
    d[st] = 0;
    pq.push(ii(d[st],st));
    while ( !pq.empty() ) {
        ii now = pq.top();pq.pop();
        int cur = now.second;
        if ( d[cur] < now.first ) continue;
        for ( int i = 0 ; i < v[cur].size() ; i++ ) {
            ii next = v[cur][i];
            if ( d[next.first] > d[cur]+next.second ) {
                d[next.first] = d[cur]+next.second;
                pq.push(ii(d[next.first],next.first));
            }
        }
    }
    return d[ed];
}
int main() {
    int tc;
    scanf("%d",&tc);
    while ( tc-- ) {
        int T,N;
        scanf("%d%d",&T,&N);
        for ( int i = 0 ; i < T ; i++ ) {
            int st,ed,cost;
            scanf("%d %d %d",&st,&ed,&cost);
            v[st].push_back(ii(ed,cost));
            v[ed].push_back(ii(st,cost));
        }
        printf("%d\n",dijkstra(N,1));
        for ( int i = 0 ; i < 1111 ; i++ ) 
            v[i].clear();
    }
    return 0;
}
*/


