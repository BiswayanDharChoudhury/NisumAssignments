public class q38 {
    public static void main(String[] args) {
        String phrase = "Learn Java Fast";
        StringBuffer bufferTool = new StringBuffer(phrase);
        String reversedOutput = bufferTool.reverse().toString();
        System.out.println("Reversed Output: " + reversedOutput);
    }
}
