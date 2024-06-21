#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m, t;
int dp[50][2];
int main(){
	dp[0][0] = 1;
	dp[1][1] = 1;
	for (int i = 2; i <= 50; i++) {
		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
	}
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		cout << dp[n][0]<<" "<<dp[n][1]<<"\n";
	}
	return 0;
}