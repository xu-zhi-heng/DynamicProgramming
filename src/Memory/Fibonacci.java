package Memory;

import java.util.HashMap;

// 斐波拉契数列
public class Fibonacci {
    public static void main(String[] args) {
        HashMap<Integer, Long> memory = new HashMap<>();
        int result = (int) dynamicFib(50, memory);
        System.out.println(dynamicFib(50, memory));
    }

    // 通过递归实现，速度很慢，O(2^n)
    public static int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // 动态规划实现, 通过递归画出一根递归树，会发现，有很多课子树是重复的，这些重复的子树可以不需要再次计算，通过hashmap记录即可
    public static long dynamicFib(int n, HashMap<Integer, Long> memory) {
        if (memory.containsKey(n)) return memory.get(n);
        if (n <= 2) return 1;
        memory.put(n, dynamicFib(n - 1, memory) + dynamicFib(n - 2, memory)) ;
        return memory.get(n);
    }
}
