import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class CommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flock"})); // flo
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight", "flakes", "fauna"})); // f
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"})); // ""
    }

    public static String longestCommonPrefix(String[] words) {
        StringBuilder commonPrefix = new StringBuilder();
        String shortestWord = Arrays.stream(words).min(Comparator.comparing(String::length)).orElse("");
        commonPrefix.append(shortestWord);

        for (String word : words) {
            while (!word.startsWith(commonPrefix.toString())) {
                commonPrefix.deleteCharAt(commonPrefix.length() - 1);
            }
        }

        return commonPrefix.toString();
    }
}
