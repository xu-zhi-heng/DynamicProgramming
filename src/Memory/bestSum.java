package Memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 需注意
 * 找到最短的可以组合成目标数的方式
 */
public class bestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<Integer, List<Integer>>()));
    }

    public static List<Integer> bestSum(int target, int[] nums, HashMap<Integer, List<Integer>> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> shortestCombination = null;
        for (int num : nums) {
            int remainder = target - num;
            List<Integer> currentCombination  = bestSum(remainder, nums, memory);
            if (currentCombination != null) {
                ArrayList<Integer> tempCombination = new ArrayList<>(currentCombination);
                tempCombination.add(num);
                if(shortestCombination == null || tempCombination.size() < shortestCombination.size()){
                    shortestCombination = tempCombination;
                }
            }
        }
        memory.put(target, shortestCombination);
        return shortestCombination;
    }
}
