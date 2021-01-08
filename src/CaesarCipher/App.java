package CaesarCipher;

public class App {
  public static void main(String[] args) {
    CaesarCipher caesarCipher = new CaesarCipher();
    String plainText = "This is a secret message from me";
    String secretMessage = caesarCipher.encrypt(plainText);
    System.out.println(secretMessage);
    System.out.println("Encrypted message:");
    System.out.println(caesarCipher.decrypt(secretMessage));
  }
}
