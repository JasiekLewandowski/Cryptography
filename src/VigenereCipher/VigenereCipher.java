package VigenereCipher;

public class VigenereCipher {

  public String encrypt(String secretMessage){
    StringBuilder stringBuilder = new StringBuilder();
    secretMessage = secretMessage.toUpperCase();
    String key = Constants.KEY;
    int keyCharacterIndex = 0;
    for (int i = 0;i < secretMessage.length();i++){
      char currentCharacter = secretMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int keyCharacterPositionInAlphabet = Constants.ALPHABET.indexOf(key.charAt(keyCharacterIndex));
      int encryptedCharacterIndex = Math.floorMod(currentCharacterIndex + keyCharacterPositionInAlphabet, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(encryptedCharacterIndex));
      keyCharacterIndex++;
      if (keyCharacterIndex == key.length())
        keyCharacterIndex = 0;
    }
    String encryptedMessage = stringBuilder.toString();
    return encryptedMessage;
  }

  public String decrypt(String encryptedMessage){
    StringBuilder stringBuilder = new StringBuilder();
    encryptedMessage = encryptedMessage.toUpperCase();
    String key = Constants.KEY;
    int keyCharacterIndex = 0;
    for (int i = 0;i < encryptedMessage.length();i++){
      char currentCharacter = encryptedMessage.charAt(i);
      int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
      int keyCharacterPositionInAlphabet = Constants.ALPHABET.indexOf(key.charAt(keyCharacterIndex));
      int encryptedCharacterIndex = Math.floorMod(currentCharacterIndex - keyCharacterPositionInAlphabet, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(encryptedCharacterIndex));
      keyCharacterIndex++;
      if (keyCharacterIndex == key.length())
        keyCharacterIndex = 0;
    }
    String decryptedMessage = stringBuilder.toString();
    return decryptedMessage;
  }
}
