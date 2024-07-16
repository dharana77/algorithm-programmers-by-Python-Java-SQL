#define NUM 1000000007
#include <iostream>
#include <algorithm>
#include <vector>
#include<queue>
#include<string>
#include<string.h>
using namespace std;
int n,m;
char s[7];
int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);
	n = 0;
	cin >> m;
	while (m--) {
		cin >> s;
		int num;
		if (!strcmp(s,"add")) {
			cin >> num;
			n = n | 1 << num - 1;
		}
		else if (!strcmp(s,"remove")) {
			cin >> num;
			n = n & ~(1 << num - 1);
		}
		else if (!strcmp(s,"toggle")) {
			cin >> num;
			n = n ^ 1 << num - 1;
		}
		else if (!strcmp(s,"empty")) {
			n = 0;
		}
		else if (!strcmp(s,"all")) {
			n = (1 <<20) - 1;
		}
		else if (!strcmp(s,"check")) {
			cin >> num;
			int chk=n & 1 << num - 1;
			if (chk)cout << "1\n";
			else cout << "0\n";
		}
	}
}