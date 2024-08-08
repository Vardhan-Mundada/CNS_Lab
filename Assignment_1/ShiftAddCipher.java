import java.util.Scanner;


    public class ShiftAddCipher {
      public static String encryptString(String key, String text) {
            StringBuilder ans = new StringBuilder();
            int keyLength = key.length();

            for (int i = 0; i < text.length(); i++) {
                int textIndex = text.charAt(i) - 'a';
                int keyIndex = key.charAt(i % keyLength) - 'a';

                int encryptedIndex = (textIndex + keyIndex) % 26;
                char encryptedChar = (char)(encryptedIndex + 'a');
                ans.append(encryptedChar);
            }
            return ans.toString();
        }

        public static String decryptString(String key, String text) {
            StringBuilder ans = new StringBuilder();
            int keyLength = key.length();

            for (int i = 0; i < text.length(); i++) {
                int textIndex = text.charAt(i) - 'a';
                int keyIndex = key.charAt(i % keyLength) - 'a';

                int encryptedIndex = (textIndex - keyIndex + 26) % 26;
                char encryptedChar = (char)(encryptedIndex + 'a');
                ans.append(encryptedChar);
            }
            return ans.toString();
        }

        public static void encrypt() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the key: ");
            String key = scanner.nextLine();
            System.out.print("Enter the text you want to encrypt: ");
            String textToProcess = scanner.nextLine();
            System.out.println(encryptString(key, textToProcess));
        }

        public static void decrypt() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the key: ");
            String key = scanner.nextLine();
            System.out.print("Enter the text you want to decrypt: ");
            String textToProcess = scanner.nextLine();
            System.out.println(decryptString(key, textToProcess));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to encrypt(1) or decrypt(0): ");
            int operationCode = scanner.nextInt();

            if (operationCode == 1) {
                encrypt();
            } else if (operationCode == 0) {
                decrypt();
            } else {
                System.out.println("Invalid operation entered");
            }
    }
}
