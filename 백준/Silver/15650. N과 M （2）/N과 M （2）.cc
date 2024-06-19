#include<cstdio>
using namespace std;
int n, m;
int arr[10];
int visited[10] = { 0, };
void solve(int d) {
	if (d == m) {
		for (int i = 0; i < m; i++) printf("%d ", arr[i]+1);
		printf("\n");
	}
	for (int i = 0; i < n; i++) {
		if (!visited[i]) {
			if (d == 0) {
				arr[d] = i;
				visited[i] = 1;
				solve(d + 1);
				visited[i] = 0;
			}
			else {
				if (i > arr[d - 1]) {
					arr[d] = i;
					visited[i] = 1;
					solve(d + 1);
					visited[i] = 0;
				}
			}
		}
	}
}
int main() {
	scanf("%d%d",&n, &m);
	solve(0);
	return 0;
}