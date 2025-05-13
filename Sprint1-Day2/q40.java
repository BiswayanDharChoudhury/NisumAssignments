public class WordSeparator {
    public static void main(String[] args) {
        String line = "Exploring Java with fun";
        String[] segments = line.split(" ");

        System.out.println("Words extracted from sentence:");
        for (String part : segments) {
            System.out.println(part);
        }
    }
}
