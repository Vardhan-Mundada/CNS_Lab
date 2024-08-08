import java.util.*;

public class ShuffleCipher {

    // Shift character by the given amount
    private static char shiftCharacter(char c, int shift) {
        return (char) ((c - 'a' + shift) % 26 + 'a');
    }

    // Shuffle text based on the key
    private static String shuffleText(String text, int key) {
        int length = text.length();
        StringBuilder shuffled = new StringBuilder(length);
        int[] keyPattern = Integer.toString(key).chars().map(c -> c - '0').toArray();

        for (int i = 0; i < length; i++) {
            shuffled.append('\0');
        }

        for (int i = 0; i < length; i++) {
            shuffled.setCharAt((i + keyPattern[i % keyPattern.length]) % length, text.charAt(i));
        }

        return shuffled.toString();
    }

    // Encrypt the text
    public static String encryptString(int key, String text) {
        // Step 1: Shift characters
        StringBuilder shiftedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            shiftedText.append(shiftCharacter(c, key));
        }

        // Step 2: Shuffle the shifted text
        return shuffleText(shiftedText.toString(), key);
    }

    // Decrypt the text
    public static String decryptString(int key, String text) {
        int length = text.length();
        StringBuilder unshuffled = new StringBuilder(length);
        int[] keyPattern = Integer.toString(key).chars().map(c -> c - '0').toArray();

        for (int i = 0; i < length; i++) {
            unshuffled.append('\0');
        }

        for (int i = 0; i < length; i++) {
            unshuffled.setCharAt((i - keyPattern[i % keyPattern.length] + length) % length, text.charAt(i));
        }

        // Reverse the shift process
        StringBuilder unshiftedText = new StringBuilder();
        for (char c : unshuffled.toString().toCharArray()) {
            unshiftedText.append(shiftCharacter(c, -key));
        }

        return unshiftedText.toString();
    }

    // Main method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key: ");
        int key = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Do you want to encrypt (1) or decrypt (0): ");
        int operationCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (operationCode == 1) {
            System.out.print("Enter the text you want to encrypt: ");
            String text = scanner.nextLine();
            String encryptedText = encryptString(key, text);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (operationCode == 0) {
            System.out.print("Enter the text you want to decrypt: ");
            String text = scanner.nextLine();
            String decryptedText = decryptString(key, text);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid operation entered");
        }
        scanner.close();
    }
}
