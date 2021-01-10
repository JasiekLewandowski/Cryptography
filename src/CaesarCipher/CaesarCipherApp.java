package CaesarCipher;

public class CaesarCipherApp {
  public static void main(String[] args) {
    String secretMessage = "Here is a secret message written in English where the most common letter is the letter e";

    CaesarCipher caesarCipher = new CaesarCipher();
    String encryptedMessage = caesarCipher.encrypt(secretMessage);


    CaesarCipherBreaker breaker = new CaesarCipherBreaker();
    breaker.bruteForceAttack(encryptedMessage);
  }
}
