#include <iostream>
#include <queue>
#include<iostream>
#include <stdlib.h>
#include<queue>
#include<stack>
#include <tuple>
using namespace std;
int n, t;
int a, b;
int test[1000003] = { 0, };
long long sum = 0;
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> test[i];
	}
	cin >> a >> b;
	for (int i = 0; i < n; i++) {
		test[i] -= a;
		if (test[i] > 0) {
			int temp = test[i] % b;
			if (!temp) {
				sum += test[i] / b;
			}
			else {
				sum += ((test[i] / b) + 1);
			}
		}sum++;
	}
	cout << sum << endl;
	return 0;
}