#include <iostream>
#include <queue>
#include<iostream>
#include <stdlib.h>
#include<string>
#include<stack>
#include<algorithm>
#define endl "\n"
using namespace std;

typedef long long ll;
ll N, K, Q;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> N >> K >> Q;
	for (int i = 0; i < Q; i++) {
		ll x, y;
		cin >> x >> y;
		ll ct = 0;
		if (K == 1) {
			cout << abs(x - y) << endl;
		}
		else {
			while (x != y) {
				//cout << x << " " << y << endl;
				if (x < y)swap(x, y);
				x = (x - 2 + K) / K ;
				ct++;
			}
			cout << ct << endl;
		}
	}
	

	return 0;
}