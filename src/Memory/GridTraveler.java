package Memory;

import java.util.HashMap;

/**
 *一个机器人位于一个 m x n 网格的左上角。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 问总共有多少条不同的路径？
 */
public class GridTraveler {
    public static void main(String[] args) {
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(uniquePaths(3, 7, memo));
    }

    public static int uniquePaths(int m, int n, HashMap<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        memo.put(key, uniquePaths(m, n - 1, memo) + uniquePaths(m - 1, n, memo));
        return memo.get(key);
    }
}
