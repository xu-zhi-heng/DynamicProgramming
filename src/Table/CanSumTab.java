package Table;

import java.util.Arrays;

public class CanSumTab {
    public static void main(String[] args) {
        System.out.println(can_sum(7, new int[]{2, 2, 8, 1}));
    }

    public static boolean can_sum(int target, int[] arr) {
        boolean[] table = new boolean[target + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i]) {
                for (int num : arr) {
                    if (i + num <= target) {
                        table[i + num] = true;
                    }
                }
            }
        }
        return table[target];
    }
}
