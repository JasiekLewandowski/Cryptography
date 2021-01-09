package CaesarCipher;

public class CaesarCipher {
  public String encrypt(String secretMessage) {
    String encryptedMessage = "";
    StringBuilder stringBuilder = new StringBuilder(encryptedMessage);
    secretMessage = secretMessage.toUpperCase();
    for (int i = 0;i < secretMessage.length(); i ++){
      char currentCharacter = secretMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int encryptedCharIndex = Math.floorMod(currentCharacterIndex + Constants.KEY, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(encryptedCharIndex));
    }
    return stringBuilder.toString();
  }

  public String decrypt(String encryptedMessage) {
    String decryptedMessage = "";
    StringBuilder stringBuilder = new StringBuilder(decryptedMessage);
    for (int i = 0; i < encryptedMessage.length();i++){
      char currentCharacter = encryptedMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int decryptedCharIndex = Math.floorMod(currentCharacterIndex - Constants.KEY, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(decryptedCharIndex));
    }
    return stringBuilder.toString();
  }
}
