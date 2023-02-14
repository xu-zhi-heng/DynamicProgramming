package Memory;

import java.util.HashMap;

/**
 * 判断一个字符串能否用给出的字符数组组合起来
 */
public class canConstruct {
    public static void main(String[] args) {
        String str = "chinese";
        System.out.println(can_Construct(str, new String[]{"a","b"}, new HashMap<String, Boolean>()));
    }

    public static boolean can_Construct(String target, String[] strings, HashMap<String, Boolean> memory) {
        if (memory.containsKey(target)) return memory.get(target);
        if (target.equals("")) return true;
        for (String str : strings) {
            // 用于判断字符串中是否包含指定的字符或字符串
            if (target.indexOf(str) == 0) {
                target = target.replaceAll(str, "");
                if (can_Construct(target, strings, memory)) {
                    memory.put(target, true);
                    return true;
                }
            }
        }
        memory.put(target, false);
        return false;
    }
}
