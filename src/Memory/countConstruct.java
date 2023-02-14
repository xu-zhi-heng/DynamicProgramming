package Memory;

import java.util.HashMap;

/**
 * 统计数组中能够组成目标字符串有多少种方式
 */
public class countConstruct {
    public static void main(String[] args) {
        System.out.println(count_Construct("purple", new String[]{"purp","p","ur","le","purpl"}, new HashMap<String, Integer>()));
    }

    public static int count_Construct(String target, String[] wordBank, HashMap<String, Integer> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        if (target.equals("")) return 1;
        int total = 0;

        for (String word : wordBank) {
            // 组合单词从单词的前面开始寻找
            if (target.indexOf(word) == 0) {
                target = target.replaceAll(word, "");
                int i = count_Construct(target, wordBank, memory);
                total += i;
            }
        }
        memory.put(target, total);
        return total;
    }
}
