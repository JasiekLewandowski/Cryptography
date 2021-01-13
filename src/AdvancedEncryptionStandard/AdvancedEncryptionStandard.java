package AdvancedEncryptionStandard;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AdvancedEncryptionStandard {
    public String encrypt(String secretMessage, SecretKey key){
      byte[] encryptedMessage = null;
      try {

        Cipher encryptionCipher = Cipher.getInstance("AES");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = secretMessage.getBytes();
        encryptedMessage = encryptionCipher.doFinal(bytes);
        encryptedMessage = Base64.getEncoder().encode(encryptedMessage);

      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (NoSuchPaddingException e) {
        e.printStackTrace();
      } catch (InvalidKeyException e) {
        e.printStackTrace();
      } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
      } catch (BadPaddingException e) {
        e.printStackTrace();
      }

      return new String(encryptedMessage);
    }

    public String decrypt(String encryptedMessage, SecretKey key) throws UnsupportedEncodingException {
      byte[] decryptedMessage = null;
      try {

        Cipher decryptionCipher = Cipher.getInstance("AES");
        decryptionCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytedDecrypted = Base64.getDecoder().decode(encryptedMessage.getBytes());
        decryptedMessage = decryptionCipher.doFinal(bytedDecrypted);

      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      } catch (NoSuchPaddingException e) {
        e.printStackTrace();
      } catch (InvalidKeyException e) {
        e.printStackTrace();
      } catch (IllegalBlockSizeException e) {
        e.printStackTrace();
      } catch (BadPaddingException e) {
        e.printStackTrace();
      }

      return new String(decryptedMessage, "UTF8");
    }
}

