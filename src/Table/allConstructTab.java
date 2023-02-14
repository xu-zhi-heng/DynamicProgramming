package Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class allConstructTab {
    public static void main(String[] args) {
        System.out.println(all_construct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    }

    public static List all_construct(String target, String[] wordBank) {
        List<List<List<String>>> table = new ArrayList<>(Collections.nCopies(target.length() + 1, null));
        for (int i = 0; i <= target.length(); i++) {
            table.set(i, new ArrayList<>());
        }
        table.get(0).add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            for (String word : wordBank) {
                if (target.substring(i).indexOf(word) == 0) {
                    List<List<String>> newCombinations = new ArrayList<>();

                    for (List<String> subArray : table.get(i)) {
                        List<String> subArrayTemp = new ArrayList<>(subArray);
                        subArrayTemp.add(word);
                        newCombinations.add(subArrayTemp);
                    }

                    for (List<String> subArray : newCombinations) {
                        table.get(i + word.length()).add(new ArrayList<>(subArray));
                    }

                }
            }
        }

        return table.get(target.length());
    }
}
