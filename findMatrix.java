/**
 * 
 */
package findMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class findMatrix {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc =new Scanner(System.in);
		Scanner sc = new Scanner(new File("input.txt"));
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] res = findSubMatrix(arr, N, M, K);
			System.out.printf("#%d %d %d\n", test, res[0], res[1]);
		}
	}

	private static int[] findSubMatrix(int[][] a, int n, int m, int k) {
		int[] res = { -1, -1 };
		int minDiff = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i <= n - m; i++) {
			for (int j = 0; j <= n - m; j++) {
				int sum = 0;
				for (int r = i; r < i + m; r++) {
					for (int c = j; c < j + m; c++) {
						sum += a[r][c];
					}
				}
				int diff = Math.abs(sum - k);
				if (diff < minDiff) {
					minDiff = diff;
					res[0] = i;
					res[1] = j;
				} else if (diff == minDiff && sum < minSum) {
					res[0] = i;
					res[1] = j;
				} else if ((i < res[0] || (i == res[0] && j < res[1]))) {
					res[0] = i;
					res[1] = j;
				}
			}
		}
		return res;
	}
}
