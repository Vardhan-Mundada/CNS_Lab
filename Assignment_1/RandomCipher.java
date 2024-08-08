import java.util.*;

    public class RandomCipher {

        public static String generateRandomPermutation(int key, String alphabet) {
            Random random = new Random(key);
            List<Character> permList = new ArrayList<>();
            for (char c : alphabet.toCharArray()) {
                permList.add(c);
            }
            Collections.shuffle(permList, random);
            StringBuilder perm = new StringBuilder();
            for (char c : permList) {
                perm.append(c);
            }
            return perm.toString();
        }

        public static String encryptString(int key, String text) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String perm = generateRandomPermutation(key, alphabet);
            Map<Character, Character> translationMap = new HashMap<>();
            for (int i = 0; i < alphabet.length(); i++) {
                translationMap.put(alphabet.charAt(i), perm.charAt(i));
            }
            StringBuilder encryptedText = new StringBuilder();
            for (char c : text.toCharArray()) {
                encryptedText.append(translationMap.getOrDefault(c, c));
            }
            return encryptedText.toString();
        }
        public static String decryptString(int key, String text) {
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            String perm = generateRandomPermutation(key, alphabet);
            Map<Character, Character> translationMap = new HashMap<>();
            for (int i = 0; i < alphabet.length(); i++) {
                translationMap.put(perm.charAt(i), alphabet.charAt(i));
            }
            StringBuilder decryptedText = new StringBuilder();
            for (char c : text.toCharArray()) {
                decryptedText.append(translationMap.getOrDefault(c, c));
            }
            return decryptedText.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to encrypt(1) or decrypt(0): ");
            int operationCode = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter the key: ");
            int key = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter the text: ");
            String text = scanner.nextLine();

            if (operationCode == 1) {
                System.out.println("Encrypted Text: " + encryptString(key, text));
            } else if (operationCode == 0) {
                System.out.println("Decrypted Text: " + decryptString(key, text));
            } else {
                System.out.println("Invalid operation entered");
            }
            scanner.close();
    }
}
