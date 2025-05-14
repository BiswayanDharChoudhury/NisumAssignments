import java.util.*;

public class q7 {

    // Method to process and clean the text
    private static String cleanText(String text) {
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
    }

    // Method to count the frequency of each word
    private static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = cleanText(text).split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }

    // Method to display words sorted by frequency
    private static void displaySortedWordFrequencies(Map<String, Integer> wordCountMap) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());

        // Sort by frequency (descending)
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nWord Frequencies (Sorted by Frequency):");
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String inputText = scanner.nextLine();

        Map<String, Integer> wordCount = countWords(inputText);
        displaySortedWordFrequencies(wordCount);

        scanner.close();
    }
}
