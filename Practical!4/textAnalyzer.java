public class TextAnalyzer {

    private String userInput;
    private int totalChars;
    private int totalWords;
    private int totalLines;
    private int totalSpaces;
    private int totalTabs;
    private int distinctChars;

    public TextAnalyzer(String userInput) {
        this.userInput = userInput;
        evaluateText();
    }

    private void evaluateText() {
        totalChars = userInput.length();
        totalLines = totalChars > 0 ? userInput.split("\n", -1).length : 0;
        totalSpaces = userInput.split(" ", -1).length - 1;
        totalTabs = userInput.split("\t", -1).length - 1;

        String[] tokens = userInput.split("[\\s\\n\\t]");
        int wordCounter = 0;
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                wordCounter++;
            }
        }
        totalWords = wordCounter;

        java.util.HashSet<Character> uniqueSet = new java.util.HashSet<>();
        for (char ch : userInput.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                uniqueSet.add(ch);
            }
        }
        distinctChars = uniqueSet.size();
    }


    public String getUserText() {
        return userInput;
    }

    public int getCharCount() {
        return totalChars;
    }

    public int getWordTotal() {
        return totalWords;
    }

    public int getLineTotal() {
        return totalLines;
    }

    public int getSpaceTotal() {
        return totalSpaces;
    }

    public int getTabTotal() {
        return totalTabs;
    }

    public int getDistinctCharacterCount() {
        return distinctChars;
    }
}
