#include <iostream>
int t, n, m;
int num[11];
int ct[4];
int arr[11];
bool visited[11];
using namespace std;
void solve(int n, int m,int ct) {
	if (ct == m) {
		for (int i = 0; i < ct; i++)cout << arr[i] << " ";
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (visited[i])continue;
		visited[i] = true;
		arr[ct] = i;
		solve(n, m, ct + 1);
		visited[i] = false;
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n>>m;
	for (int i = 0; i < n; i++)arr[i] = i;
	solve(n,m,0);
	

	return 0;
}