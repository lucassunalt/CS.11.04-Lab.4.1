public class Main {

    // 1. parenthesesCheck

    // NOTE: This is a valid solution, but is a more efficient solution that 
    // can run in O(log(n)) time in parallel, while this solution runs in O(n) time. 
    // See LOGCFL complexity class for more information about the parallel approach.

    public static boolean parenthesesCheck(String s) {
        int openCount = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                openCount--;
                // If we have more closing than opening at any point, it's invalid
                if (openCount < 0) {
                    return false;
                }
            }
        }
        
        // Valid only if all parentheses are matched
        return openCount == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        return new StringBuilder(String.valueOf(n)).reverse().toString();
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        if (input.isEmpty()) return "";
        
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(encryptWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    // Helper method to encrypt a single word
    private static String encryptWord(String word) {
        if (word.isEmpty()) return "";
        if (word.length() == 1) {
            return String.valueOf((int) word.charAt(0));
        }
        if (word.length() == 2) {
            return (int) word.charAt(0) + String.valueOf(word.charAt(1));
        }
        
        // Replace first letter with ASCII code
        int firstCharCode = (int) word.charAt(0);
        
        // Swap second and last letter
        char secondChar = word.charAt(1);
        char lastChar = word.charAt(word.length() - 1);
        
        // Build encrypted word
        StringBuilder encrypted = new StringBuilder();
        encrypted.append(firstCharCode);
        encrypted.append(lastChar);
        
        // Add middle characters if any
        if (word.length() > 3) {
            encrypted.append(word.substring(2, word.length() - 1));
        }
        
        encrypted.append(secondChar);
        
        return encrypted.toString();
    }


    // 4. decipherThis
    
    public static String decipherThis(String input) {
        if (input.isEmpty()) return "";
        
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(decipherWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    // Helper method to decipher a single word
    private static String decipherWord(String word) {
        if (word.isEmpty()) return "";
        
        // Extract the ASCII code at the beginning
        int i = 0;
        while (i < word.length() && Character.isDigit(word.charAt(i))) {
            i++;
        }
        
        int asciiCode = Integer.parseInt(word.substring(0, i));
        char firstChar = (char) asciiCode;
        
        String remaining = word.substring(i);
        
        if (remaining.isEmpty()) {
            return String.valueOf(firstChar);
        }
        if (remaining.length() == 1) {
            return firstChar + remaining;
        }
        
        // Swap second and last letter back
        char secondChar = remaining.charAt(0);
        char lastChar = remaining.charAt(remaining.length() - 1);
        
        StringBuilder deciphered = new StringBuilder();
        deciphered.append(firstChar);
        deciphered.append(lastChar);
        
        // Add middle characters if any
        if (remaining.length() > 2) {
            deciphered.append(remaining.substring(1, remaining.length() - 1));
        }
        
        deciphered.append(secondChar);
        
        return deciphered.toString();
    }

}
