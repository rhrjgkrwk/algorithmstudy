package graph;

import java.util.Scanner;

class Edge{
	int from;
	int to;
	int cost;
	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return from+" "+to+" "+cost;
	}
}

public class ShortestPath1753_Bellman {
	public static final int INF = 999999999;
	public static int V; //������ ����
	public static int E; //������ ��
	public static int K; //���� ��.
	public static Edge []es; //���� ��.
	public static int d[]; //�ִ� �Ÿ� ������ ���� �迭
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		d = new int[V+1];
		es = new Edge[E];
		for (int i = 0; i < E; i++) {
			es[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		
		bellmanFord(K);
		for (int i = 1; i < d.length; i++) {
			System.out.println((d[i]==INF?"INF":d[i]));
		}
		sc.close();
	}
	
	
	public static void bellmanFord(int s){
		for (int i = 1; i <= V; i++) {
			d[i] = INF;
		}
		d[s] = 0;
		while (true) {
			boolean flag = false;
			for (int i = 0; i < E; i++) {
				Edge e = es[i];
				if (d[e.from] != INF && d[e.to]>d[e.from]+e.cost) {
					d[e.to] = d[e.from] + e.cost;
					flag = true;
				}
			}
			if(flag==false) break;
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
5
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


