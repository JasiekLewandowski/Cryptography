package VigenereCipher;

public class VigenereCipherApp {
  public static void main(String[] args) {
    String secretMessage = "Here is a secret message written in English that has to be cracked by krasinski algorithm " +
            "so I have to make this text really really long so the algorithm could work fine and find some patterns in this text";

    VigenereCipher vigenereCipher = new VigenereCipher();

    String encryptedMessage = vigenereCipher.encrypt(secretMessage);
    System.out.println(encryptedMessage);

    String decryptedMessage = vigenereCipher.decrypt(encryptedMessage);
    System.out.println(decryptedMessage);
  }
}
