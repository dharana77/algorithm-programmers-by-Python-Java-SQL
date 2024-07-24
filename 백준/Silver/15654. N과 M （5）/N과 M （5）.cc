#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
int n, m;
int num[8];
int c[8];
int arr[8];
using namespace std;
void solve(int n, int m, int idx) {
	if (idx == m) {
		for (int i = 0; i < idx; i++)cout << arr[i]<<" ";
		cout << "\n";
		return;
	}
	for (int i = 0; i < n; i++) {
		if (c[i])continue;
		c[i] = true;
		arr[idx] = num[i];
		solve(n, m, idx + 1);
		c[i] = false;
	}
}
int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++)cin >> num[i];
	sort(num, num+n);
	solve(n, m, 0);
}