import java.util.*;

public class CharacterCounter {
    public static void main(String[] args) {
        String text = "Super Man Bat Man Spider Man";
        text = text.replaceAll(" ", "").toLowerCase();

        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : text.toCharArray()) {
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) + 1);
            } else {
                charCount.put(ch, 1);
            }
        }

        System.out.println("Character Frequency:");
        for (char key : charCount.keySet()) {
            System.out.println(key + ": " + charCount.get(key));
        }
    }
}
