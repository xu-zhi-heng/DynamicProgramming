package Table;

public class countConstructTab {
    public static void main(String[] args) {
        System.out.println(count_construct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }

    public static int count_construct(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != 0) {
                for (String word : wordBank) {
                    if (i + word.length() <= target.length()) {
                        if (target.substring(i, i + word.length()).equals(word)) {
                            table[i + word.length()] += table[i];
                        }
                    }
                 }
            }
        }

        return table[target.length()];
    }
}
