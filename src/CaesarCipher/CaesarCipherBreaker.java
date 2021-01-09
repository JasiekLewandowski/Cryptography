package CaesarCipher;

import java.util.HashMap;
import java.util.Map;

public class CaesarCipherBreaker {
    public void bruteForceAttack(String encryptedMessage){
      for (int key = 0;key < Constants.ALPHABET.length();key++){
        String decryptedMessage = "";
        StringBuilder stringBuilder = new StringBuilder(decryptedMessage);
        for (int i = 0;i < encryptedMessage.length();i++){
          char currentCharacter = encryptedMessage.charAt(i);
          int currentCharacterIndex = Constants.ALPHABET.indexOf(currentCharacter);
          int decryptedCharacterIndex = Math.floorMod(currentCharacterIndex - key,Constants.ALPHABET.length());
          stringBuilder.append(Constants.ALPHABET.charAt(decryptedCharacterIndex));
        }
        System.out.println("With key = " + key + " encrypted message is: " + stringBuilder.toString());
      }
    }

   public void frequencyAnalizeAttack(String encryptedMessage){
      Map<Character,Integer> lettersFrequency = analyze(encryptedMessage);
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

   public Map<Character, Integer> analyze (String encryptedMessage){
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
