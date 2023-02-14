package Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowSumTab {
    public static void main(String[] args) {
        System.out.println(how_sum(7, new int[]{2, 4, 2, 3, 5}));
    }

    public static List how_sum(int target, int[] nums) {
        List[] table = new List[target + 1];
        Arrays.fill(table, null);

        table[0] = new ArrayList();

        for (int i = 0; i <= target; i++) {
            if (table[i] != null) {
                for (int num : nums) {
                    if (i + num <= target) {
                        table[i + num] = new ArrayList();
                        table[i + num].add(num);
                        table[i + num].addAll(table[i]);
                    }
                }
            }
        }

        return table[target];
    }
}
