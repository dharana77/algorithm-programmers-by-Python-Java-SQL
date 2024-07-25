#include<iostream>
#include<stdlib.h>
#include<string>
#include<stack>
#include<math.h>
#include<vector>
#include<algorithm>
using namespace std;
int n;
int rgb[1001][3];
int dp[1001][3];
int ans = 0;
int r, g, b,R,G,B;
int sr = 0, sg = 0, sb = 0;
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> r >> g >> b;
		r += min(G, B);
		g += min(R, B);
		b += min(G, R);
		R = r; G = g; B = b;
	}
	ans = min(r,min(g,b) );
	cout << ans << endl;
	//system("pause");
	return 0;
}