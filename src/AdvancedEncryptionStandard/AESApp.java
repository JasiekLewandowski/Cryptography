package AdvancedEncryptionStandard;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class AESApp {
  public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    String secretMessage = "Here is a secret message written in English";
    SecretKey key = KeyGenerator.getInstance("AES").generateKey();

    AdvancedEncryptionStandard aes = new AdvancedEncryptionStandard();

    String encryptedMessage = aes.encrypt(secretMessage, key);
    System.out.println("Encrypted text: " + encryptedMessage);

    String decryptedMessage = aes.decrypt(encryptedMessage, key);
    System.out.println("Decrypted text: " + decryptedMessage);
  }
}
