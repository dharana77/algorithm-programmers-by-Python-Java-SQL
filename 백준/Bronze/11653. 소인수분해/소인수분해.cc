#include<iostream>
#include<stdlib.h>
#include<string>
#include<stack>
#include<vector>
#include<algorithm>
using namespace std;
int n, k;
int main() {
	cin >> n;
	while (n) {
		if (n <= 1)break;
		for (int i = 2; i <= n; i++) {
			if (n%i == 0) {
				cout << i << endl;
				n /= i;
				break;
			}
		}
	}
	//system("pause");
	return 0;
}