package CaesarCipher.ImplementingCaesarCipher;

public class App {
  public static void main(String[] args) {
    CaesarCipher caesarCipher = new CaesarCipher();
    String secretMessage = "This is a secret message";
    System.out.println(secretMessage);
    String encryptedMessage = caesarCipher.encrypt(secretMessage);
    System.out.println(encryptedMessage);
    System.out.println("Encrypted message:");
    System.out.println(caesarCipher.decrypt(encryptedMessage));
  }
}
