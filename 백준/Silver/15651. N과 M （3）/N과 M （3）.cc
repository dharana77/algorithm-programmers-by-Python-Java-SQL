#include <iostream>
int t, n, m;
int num[11];
int ct[4];
int arr[11];
bool visited[11];
using namespace std;
void solve(int idx, int n, int m) {
	if (idx == m) {
		for (int i = 0; i < idx; i++)cout << arr[i] << " ";
		cout << "\n";
		return;
	}
	for (int i = 1; i <= n; i++) {  
		arr[idx] = i;
		solve(idx + 1, n, m);
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cin >> n>>m;
	solve(0,n,m);
	

	return 0;
}