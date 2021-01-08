package CaesarCipher;

public class CaesarCipher {
  public String encrypt(String plainText) {
    String cipherText = "";
    plainText = plainText.toUpperCase();
    for (int i = 0;i < plainText.length(); i ++){
      char character = plainText.charAt(i);
      int charIndex = Constants.ALPHABET.indexOf(character);
      int encryptedIndex = Math.floorMod(charIndex + Constants.KEY, Constants.ALPHABET.length());
      cipherText = cipherText + Constants.ALPHABET.charAt(encryptedIndex);
    }
    return cipherText;
  }

  public String decrypt(String plainText) {
    String cipherText = "";
    for (int i = 0; i < plainText.length();i++){
      char character = plainText.charAt(i);
      int charIndex = Constants.ALPHABET.indexOf(character);
      int decryptedIndex = Math.floorMod(charIndex - Constants.KEY, Constants.ALPHABET.length());
      cipherText = cipherText + Constants.ALPHABET.charAt(decryptedIndex);
    }
    return cipherText;
  }
}
