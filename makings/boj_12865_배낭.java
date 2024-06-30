package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        n = Integer.valueOf(sb.toString().split(" ")[0]);
        m = Integer.valueOf(sb.toString().split(" ")[1]);

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder(br.readLine());
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = Integer.valueOf(sb.toString().split(" ")[j]);
            }

        }
    }

}

