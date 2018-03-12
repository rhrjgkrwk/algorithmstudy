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
	public static int V; //������ ����
	public static int E; //������ ��
	public static int K; //���� ��.
	public static int d[]; //�ִ� �Ÿ� ������ ���� �迭
	public static boolean visit[]; //�ִ� �Ÿ� ������ ���� �迭
	public static int weight[][]; //�ִ� �Ÿ� ������ ���� �迭
	
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
			int cost = pq.peek().w; //������ �������� ���� ����� ���� ���� pop
			int now = pq.peek().v; 
			pq.poll();
			if (cost>d[now]) {//���� �ִܰŸ����� ũ�� ����� �ʿ� ����.
				continue;
			}
			for (int i = 1; i < weight[now].length; i++) {
				if (weight[now][i]!=0 && d[i] > d[now]+weight[now][i]) { //�� �� �ִ� ���� ��带 �����ͼ� pq�� �ִ´�.
					d[i] = d[now]+weight[now][i];
					pq.add(new Dij(i,d[i]));
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
 (1��V��20,000, 1��E��300,000) ��� �������� 1���� V����
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
3
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


