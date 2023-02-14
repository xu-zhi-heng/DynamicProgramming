package Memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
    给你个数组和一个整数，找出可以通过数组元素进行组合成整数的一种方式
 */
public class howSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{7, 14}, 300);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<Integer, List<Integer>> memory = new HashMap<>();
        List<Integer> list = howSum(candidates, target, memory);
        lists.add(list);
        return lists;
    }

    public static List<Integer> howSum(int[] candidates, int target, HashMap<Integer, List<Integer>> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (int num : candidates) {
            int remainder = target - num;
            List<Integer> list = howSum(candidates, remainder, memory);
            if (list != null) {
                list.add(num);
                memory.put(target, list);
                return memory.get(target);
            }
        }
        memory.put(target, null);
        return null;
    }
}
