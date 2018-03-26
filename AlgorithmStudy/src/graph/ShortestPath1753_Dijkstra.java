package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class Dij implements Comparable<Dij>{ //Dij = Edge
	int v; //to
	int w; //weight
	public Dij(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Dij o) {
		// TODO Auto-generated method stub
		return   this.w - o.w;
	}
}
public class ShortestPath1753_Dijkstra {
	public static final int INF = Integer.MAX_VALUE;
	public static int V; //# of Vertex 
	public static int E; //# of Edge
	public static int K; //start
	public static int d[]; //d[i] : shortest path from start(K) 
	public static boolean visit[]; //방문 chk
	public static ArrayList<ArrayList<Dij>> list = new ArrayList<ArrayList<Dij>>(); 
	//adj List
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		d = new int[V+1];
		visit = new boolean[V+1];
		for (int i = 0; i < V+1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list.get(a).add(new Dij(b,c));
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
		//pq는 방문하지 않은 점중 시작점으로부터 가장 가까운 점을 poll한다.
		pq.add(new Dij(s, d[s])); //시작점을 pq에 넣는다.
		while (!pq.isEmpty()) { 
			int dist = pq.peek().w; 
			int now = pq.peek().v;
			pq.poll();
			visit[now] = true; //현재 정점(시작점으로부터 가장 가까운 점.)을 방문한다.
			if (dist > d[now]) { //시작점으로부터의 거리가 업데이트될 필요가 없으면.
				continue;
			}
//			for (int i = 0; i < list.get(now).size(); i++) { 
//				Dij next = list.get(now).get(i);
//				if (!visit[next.v] && d[next.v] > d[now] + next.w) { 
//					d[next.v] = d[now] + next.w;
//					pq.add(new Dij(next.v, d[next.v]));
//				}
//			}
			for (Dij adj : list.get(now)) { 
				//현재 정점(시작점으로부터 가장 가까운 점)에서 인접한 점들을 살피고 
				//방문하지 않은 것 중 기존 d값보다 작다면 업데이트한다.
				if (!visit[adj.v]&&d[adj.v]>d[now]+adj.w) {
					d[adj.v] = d[now]+adj.w; 
					pq.add(new Dij(adj.v, d[adj.v])); 
					//다음 시작점으로부터 가장 가까운 점을 얻기 위해 업데이트된 정점정보를 pq에 넣어준다.
				}
			}
		}
	}
}

/*
1753��
�ִܰ�� Ǯ��
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	128 MB	19982	5648	2769	25.373%
����
����׷����� �־����� �־��� ���������� �ٸ� ���
 ���������� �ִ� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻ�
 ��. ��, ��� ������ ����ġ�� 10 ������ �ڿ����̴�.

�Է�
ù° �ٿ� ������ ���� V�� ������ ���� E�� �־�����.
 (1��V��20,000, 1��E��300,000) ��� �������� 1���� V���� -----���⼭ ��Ÿ�� ���� : ������ķ� �����ϸ� �޸� �ʰ��� ��
  ��ȣ�� �Ű��� �ִٰ� �����Ѵ�. ��° �ٿ��� ���� ������
   ��ȣ K(1��K��V)�� �־�����. ��° �ٺ��� E���� �ٿ� ���� 
   �� ������ ��Ÿ���� �� ���� ���� (u, v, w)�� ������� �־�����. 
   �̴� u���� v�� ���� ����ġ w�� ������ �����Ѵٴ� ���̴�. 
   u�� v�� ���� �ٸ��� w�� 10 ������ �ڿ����̴�. 
   ���� �ٸ� �� ���� ���̿� ���� ���� ������ ������ ���� ������ �����Ѵ�.

���
ù° �ٺ��� V���� �ٿ� ����, i��° �ٿ� i�� ���������� �ִ� ����� ��ΰ��� ����Ѵ�. 
������ �ڽ��� 0���� ����ϰ�, ��ΰ� �������� �ʴ� ��쿡�� INF�� ����ϸ� �ȴ�.

���� �Է� 
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
���� ��� 
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


