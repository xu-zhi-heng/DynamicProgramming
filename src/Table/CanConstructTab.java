package Table;

import java.util.Arrays;

public class CanConstructTab {
    public static void main(String[] args) {
        System.out.println(can_construct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    }

    public static boolean can_construct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i]) {
                for (String word : wordBank) {
                    if (i + word.length() <= target.length()) {
                        if (target.substring(i, i + word.length()).equals(word)) {
                            table[i + word.length()] = true;
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }
}
