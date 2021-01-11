package OneTimePadCipher;

public class OneTimePadApp {
  public static void main(String[] args) {
    String secretMessage = "Here is a secret message written in English";

    OneTimePadCipher oneTimePadCipher = new OneTimePadCipher();
    RandomKeyGenerator randomKeyGenerator = new RandomKeyGenerator();
    int[] key = randomKeyGenerator.generate(secretMessage.length());

    String encryptedMessage = oneTimePadCipher.encrypt(secretMessage, key);
    System.out.println(encryptedMessage);

    String decryptedMessage = oneTimePadCipher.decrypt(encryptedMessage, key);
    System.out.println(decryptedMessage);
  }
}
