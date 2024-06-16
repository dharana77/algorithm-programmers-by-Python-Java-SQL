#include <string>
#include <vector>
#include<stack>
#include<set>
#include<regex>
#include<algorithm>
#include<iostream>
using namespace std;

int main() {
	regex re("(100+1+|01)+");
	cmatch cm;
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		string str;
		cin >> str;
		bool ans = regex_match(str.c_str(), cm, re);
		cout << (ans ? "YES" : "NO")<<"\n";
	}
	return 0;
}