#include<iostream>
#include<algorithm>
#include<stdlib.h>
#include<vector>
using namespace std;
int main() {
	int n[9];
	int a, b;
	int sum = 0;
	for (int i = 0; i < 9; i++) {
		cin >> n[i]; sum += n[i];
	}
	sort(&n[0], &n[0] + 9);
	for (int i = 0; i < 8; i++) {
		for (int j = i + 1; j < 9; j++) {
			int x = n[i] + n[j];
			if ((sum - x) == 100) {
				a = i; b = j;
				break;
			}
		}
	}
	for (int i = 0; i < 9; i++) {
		if ((i != a) && (i != b))cout << n[i] << endl;
	}
	//system("pause");
	return 0;
}