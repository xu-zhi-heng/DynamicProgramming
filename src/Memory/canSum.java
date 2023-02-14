package Memory;

import java.util.HashMap;

/**
 * 判断整数是否能由数组中的元素通过通过加法组合而来
 */
public class canSum {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> memory = new HashMap<>();
        System.out.println(solve(7, new int[]{5}, memory));
    }

    public static boolean solve(int targetNum, int[] nums, HashMap<Integer, Boolean> memory) {
        if (memory.containsKey(targetNum)) return memory.get(targetNum);
        // 如果最后一个元素等于0代表可以减完
        if (targetNum == 0) return true;
        // 如果最后是负数，代表不可以减完
        if (targetNum < 0) return false;
        for (int num : nums) {
            int remainder = targetNum - num;
            if (solve(remainder, nums, memory)) {
                memory.put(targetNum, true);
                return true;
            }
        }
        return false;
    }
}
