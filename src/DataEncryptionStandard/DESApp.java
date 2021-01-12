package DataEncryptionStandard;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class DESApp {
  public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    String secretMessage = "Here is a secret message written in English";
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();

    DataEncryptionStandard des = new DataEncryptionStandard();

    String encryptedMessage = des.encrypt(secretMessage, key);
    System.out.println("Encrypted text: " + encryptedMessage);

    String decryptedMessage = des.decrypt(encryptedMessage, key);
    System.out.println("Decrypted text: " + decryptedMessage);

  }
}
