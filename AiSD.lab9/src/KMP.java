public class KMP {
    private String soughtText;
    private int[] pi;


    public int[] prefixFunction(String text) {
        pi = new int[text.length()];
        int k;
        for (int i = 1; i < text.length(); i++) {
            k = pi[i - 1];
            while (k > 0 && text.charAt(i) != text.charAt(k)) {
                k = pi[k - 1];
            }
            if (text.charAt(i) == text.charAt(k)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }


    int search(String pattern, String text) {
        int[] lsp = prefixFunction(pattern);

        int j = 0;  // Number of chars matched in pattern
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                // Fall back in the pattern
                j = lsp[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                // Next char matched, increment position
                j++;
                if (j == pattern.length())
                    return i - (j - 1);
            }
        }

        return -1;  // Not found
    }

    /*public int[] kmp(String soughtText, String inText) {
        int sl = soughtText.length();
        int tl = inText.length();
        int[] answer = new int[tl];
        int[] p = prefixFunction(soughtText + "#" + inText);
        int count = 0;
        for (int i = 0; i < tl - 1; i++) {
            if (p[sl + i + 1] == sl) {
                answer[count++] = i;
            }
        }
        return answer;
    }*/


}
