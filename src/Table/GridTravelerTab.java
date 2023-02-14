package Table;

public class GridTravelerTab {
    public static void main(String[] args) {
        System.out.println(grid_traveler(3, 2));
    }

    public static long grid_traveler(int m, int n) {
        long[][] table = new long[m + 1][n + 1];

        table[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long current = table[i][j];
                // 下和右
                if (j + 1 <= n) {
                    table[i][j + 1] += current;
                }
                if (i + 1 <= m) {
                    table[i + 1][j] += current;
                }
            }
        }

        return table[m][n];
    }
}
