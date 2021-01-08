package CaesarCipher.ImplementingCaesarCipher;

public class CaesarCipher {
  public String encrypt(String secretMessage) {
    String encryptedMessage = "";
    secretMessage = secretMessage.toUpperCase();
    for (int i = 0;i < secretMessage.length(); i ++){
      char currentCharacter = secretMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int encryptedCharIndex = Math.floorMod(currentCharacterIndex + Constants.KEY, Constants.ALPHABET.length());
      encryptedMessage = encryptedMessage + Constants.ALPHABET.charAt(encryptedCharIndex);
    }
    return encryptedMessage;
  }

  public String decrypt(String encryptedMessage) {
    String decryptedMessage = "";
    for (int i = 0; i < encryptedMessage.length();i++){
      char currentCharacter = encryptedMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int decryptedCharIndex = Math.floorMod(currentCharacterIndex - Constants.KEY, Constants.ALPHABET.length());
      decryptedMessage = decryptedMessage + Constants.ALPHABET.charAt(decryptedCharIndex);
    }
    return decryptedMessage;
  }
}
