package demTamGiac;

import java.io.File;
import java.util.Scanner;

public class main {

	static int[][] moveSet = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("input.txt"));
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
//			sc.nextLine();

			int M = sc.nextInt();
			int N = sc.nextInt();
			int[][] mat = new int[M][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mat[i][j] == 1) {
						int flag = 0;
						int [] ar = new int[4];
						for (int x = 0; x < moveSet.length; x++) {
							if (i + moveSet[x][0] >= 0 && i + moveSet[x][0] < N && j + moveSet[x][1] < N
									&& j + moveSet[x][1] >= 0) {
								if (mat[i + moveSet[x][0]][j + moveSet[x][1]] == 1) {
									ar[x] = 1;
									flag++;
								}
							}
							
						}
						if(flag == 2 && (ar[0] == ar[2] || ar[1] == ar[3])){
							continue;
						}
						if (flag == 4) {
							count = count + flag;
						}
						if (flag == 2 || flag == 3) {
							count = count + flag - 1;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
