package OneTimePadCipher;

public class OneTimePadCipher {
  public String encrypt(String secretMessage, int[] key){
    secretMessage = secretMessage.toUpperCase();
    String encryptedMessage;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0;i < secretMessage.length();i++){
      int currentKeyIndex = key[i];
      int currentCharacterIndex = Constants.ALPHABET.indexOf(secretMessage.charAt(i));
      int encryptedCharacterIndex = Math.floorMod(currentCharacterIndex + currentKeyIndex, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(encryptedCharacterIndex));
    }
    encryptedMessage = stringBuilder.toString();
    return encryptedMessage;
  }

  public String decrypt(String encryptedMessage, int[] key){
    encryptedMessage = encryptedMessage.toUpperCase();
    String decryptedMessage;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0;i < encryptedMessage.length();i++){
      int currentKeyIndex = key[i];
      int currentCharacterIndex = Constants.ALPHABET.indexOf(encryptedMessage.charAt(i));
      int encryptedCharacterIndex = Math.floorMod(currentCharacterIndex - currentKeyIndex, Constants.ALPHABET.length());
      stringBuilder.append(Constants.ALPHABET.charAt(encryptedCharacterIndex));
    }
    decryptedMessage = stringBuilder.toString();
    return decryptedMessage;
  }
}
