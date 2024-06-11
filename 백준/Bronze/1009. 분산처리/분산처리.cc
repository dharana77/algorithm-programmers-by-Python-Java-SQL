//#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n = 0;
	int a, b = 0;
	int temp = 0;
	scanf("%d", &n);
	while (n--) {
		scanf("%d%d", &a, &b);
		temp = a;
		b = b - 1;
		while (b--) {
			a = (a*temp)%10;
		}
		a = a % 10;
		if (a == 0) printf("%d\n", 10);
		else printf("%d\n", a);
	}

	//system("pause");
}