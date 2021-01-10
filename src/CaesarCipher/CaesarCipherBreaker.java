package CaesarCipher;

import java.util.HashMap;
import java.util.Map;

public class CaesarCipherBreaker {

    public void bruteForceAttack(String encryptedMessage){
      StringBuilder stringBuilder = new StringBuilder();
      LanguageDetector languageDetector = new LanguageDetector();
        for (int key = 0; key < Constants.ALPHABET.length(); key++) {
          for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentCharacter = encryptedMessage.charAt(i);
            int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
            int decryptedCharacterIndex = Math.floorMod(currentCharacterIndex - key, Constants.ALPHABET.length());
            stringBuilder.append(Constants.ALPHABET.charAt(decryptedCharacterIndex));
          }
          if (languageDetector.isMessageEnglish(stringBuilder.toString())){
            System.out.println("The key is " + key + " and the message is: " + stringBuilder.toString());
            break;
          } else {
            stringBuilder.setLength(0);
          }
        }
    }

   public void frequencyAnalysisAttack(String encryptedMessage){
      Map<Character,Integer> lettersFrequency = analyzeLettersFrequency(encryptedMessage);
      Map.Entry<Character, Integer> maxEntry = null;
      for (Map.Entry<Character, Integer> entry : lettersFrequency.entrySet()){
        if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
          maxEntry = entry;
        }
      }
      if(maxEntry != null) {
        char mostFrequentChar = maxEntry.getKey();
        int approximatedKey = Constants.ALPHABET.indexOf(mostFrequentChar) - Constants.ALPHABET.indexOf("E");
        System.out.println("The key is: " + approximatedKey);
      }
   }

   public Map<Character, Integer> analyzeLettersFrequency(String encryptedMessage){
      Map<Character, Integer> lettersFrequency = new HashMap<>();
      for (int i = 0;i < Constants.ALPHABET.length();i++){
        lettersFrequency.put(Constants.ALPHABET.charAt(i), 0);
      }
      for (int j = 0;j < encryptedMessage.length();j++){
        char currentChar = encryptedMessage.charAt(j);
        if (Constants.ALPHABET.indexOf(currentChar) != -1){
          lettersFrequency.put(currentChar, lettersFrequency.get(currentChar) + 1);
        }
      }
  return lettersFrequency;
}
}
