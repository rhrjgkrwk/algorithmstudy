package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class Dij implements Comparable<Dij>{
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
	public static int V; //������ ����
	public static int E; //������ ��
	public static int K; //���� ��.
	public static int d[]; //�ִ� �Ÿ� ������ ���� �迭
	public static boolean visit[]; //��� �湮 ����.
	public static ArrayList<ArrayList<Dij>> list = new ArrayList<ArrayList<Dij>>(); //�ִ� �Ÿ� ������ ���� �迭
	
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
		pq.add(new Dij(s, d[s]));
		while (!pq.isEmpty()) { 
			int dist = pq.peek().w; //������ ���� �Ÿ�.
			// ������ �������� ���� ����� ���� ���� pop
			int now = pq.peek().v;
			pq.poll();
			visit[now] = true;
			System.out.println("���� ��� : " + now);
			if (dist > d[now]) {// ���� �ִܰŸ����� ũ�� ����� �ʿ� ����.
				continue;
			}
			for (int i = 0; i < list.get(now).size(); i++) {
				Dij next = list.get(now).get(i);
				if (!visit[next.v] && d[next.v] > d[now] + next.w) { // �� �� �ִ� ���� ��带 �����ͼ� pq��// �ִ´�.
					d[next.v] = d[now] + next.w;
					pq.add(new Dij(next.v, d[next.v]));
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


