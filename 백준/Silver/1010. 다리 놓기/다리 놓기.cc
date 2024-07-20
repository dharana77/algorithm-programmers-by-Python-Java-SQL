#include <iostream>
#include<algorithm>
#include<stdlib.h>
#include<vector>
#include<string>
#include<queue>
using namespace std;
int n, m,t;
int main(){
	cin >> t;
	
	for (int i = 0; i < t; i++) {
		long long ans = 1;
		cin >> n >> m;
		
		for (int j = 1; j <= n; j++) {
			ans = ans * (m - j + 1) / j;
		}
		cout << ans << endl;
	}
	
	//system("pause");
	return 0;
}