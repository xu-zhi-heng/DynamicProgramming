package Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSumTab {
    public static void main(String[] args) {
        System.out.println(best_sum(100, new int[]{25, 1, 5, 2}));
    }

    public static List best_sum(int target, int[] nums) {
        List[] table = new List[target + 1];
        Arrays.fill(table, null);

        table[0] = new ArrayList();

        for (int i = 0; i <= target; i++) {
            if (table[i] != null) {
                for (int num : nums) {
                    if (i + num <= target) {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(num);
                        combination.addAll(table[i]);
                        if (table[i + num] == null) {
                            table[i + num] = combination;
                        }
                        if (table[i + num].size() > combination.size()) {
                            table[i + num] = combination;
                        }
                    }
                }
            }
        }

        return table[target];
    }
}
