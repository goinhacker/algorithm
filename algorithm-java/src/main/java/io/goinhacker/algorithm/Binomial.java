package io.goinhacker.algorithm;

import java.util.Arrays;

/**
 * io.goinhacker.algorithm.Binomial Coefficient(이항계수)
 * <p>
 * if n = k or k = 0, =>    nCk = 1
 * otherwise,         =>    nCk = (n-1)Ck + (n-1)C(k-1)
 */
class Binomial {

    /**
     * Using Recursion
     */

    static int binomialByRecursion(int n, int k) {
        if (n == k || 0 == k) {
            return 1;
        } else {
            return binomialByRecursion(n - 1, k) + binomialByRecursion(n - 1, k - 1);
        }
    }

    private static int[][] binomial = new int[100][100];

    /**
     * Using Memoization
     */

    static int binomialByMemozation(int n, int k) {
        for (int[] array : binomial) {
            Arrays.fill(array, -1);
        }

        return binomialMemoization(n, k);
    }

    private static int binomialMemoization(int n, int k) {
        if (n == k || 0 == k) {
            return 1;
        } else if (-1 < binomial[n][k]) {
            return binomial[n][k];
        } else {
            binomial[n][k] = binomialByRecursion(n - 1, k) + binomialByRecursion(n - 1, k - 1);
            return binomial[n][k];
        }
    }

    /**
     * Using Dynamic Programming
     */

    static int binomialByDynamic(int n, int k) {
        for (int[] array : binomial) {
            Arrays.fill(array, 0);
        }

        return binomialDynamic(n, k);
    }

    private static int binomialDynamic(int n, int k) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k && j <= i; j++) {
                if (0 == j || i == j) {
                    binomial[i][j] = 1;
                } else {
                    binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j];
                }
            }
        }

        return binomial[n][k];
    }
}
