package CaesarCipher;

public class App {
  public static void main(String[] args) {
    CaesarCipher caesarCipher = new CaesarCipher();
    String secretMessage = "Here is a secret message written in English where the most common letter is the letter e";
    System.out.println(secretMessage);
    String encryptedMessage = caesarCipher.encrypt(secretMessage);
    System.out.println(encryptedMessage);
    System.out.println("Encrypted message: ");
    System.out.println(encryptedMessage);
    System.out.println("Decrypted message: ");
    System.out.println(caesarCipher.decrypt(encryptedMessage));

    CaesarCipherBreaker breaker = new CaesarCipherBreaker();
    breaker.frequencyAnalizeAttack(encryptedMessage);
  }
}
