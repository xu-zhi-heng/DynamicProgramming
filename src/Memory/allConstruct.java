package Memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 找出所有能够组成目标值的方式
 */
public class allConstruct {
    public static void main(String[] args) {
        System.out.println(all_Construct("purple", new String[]{"purp","p","ur","le","purpl"}, new HashMap<String, List<List<String>>>()));
    }

    public static List<List<String>> all_Construct(String target, String[] wordBank, HashMap<String, List<List<String>>> memory) {
        if (memory.containsKey(target)) return memory.get(target);

        if (target.equals("")) return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        List<List<String>> result = new ArrayList<>();
        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                // 将目标字符串中的word给去掉
                String suffix = target.replaceAll(word, "");
                List<List<String>> suffixWays = all_Construct(suffix, wordBank, memory);
                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> suffixWay : suffixWays) {
                    List<String> temp = new ArrayList<>(suffixWay);
                    temp.add(0, word);
                    targetWays.add(temp);
                }
                result.addAll(targetWays);
            }
        }
        memory.put(target, result);
        return result;
    }
}
