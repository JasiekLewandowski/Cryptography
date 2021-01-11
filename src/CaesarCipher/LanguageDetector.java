package CaesarCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDetector {
  List<String> englishWords;

  public LanguageDetector() {
    this.englishWords = new ArrayList<>();
    getLanguageSamples();
  }
  private void getLanguageSamples(){
    try {
      FileReader fileReader = new FileReader(new File("C:/Users/lewan/Desktop/KODERKA/Cryptography/src/CaesarCipher/english_words.txt"));
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String word;
      while ((word = bufferedReader.readLine()) != null){
        this.englishWords.add(word.toUpperCase());
      }
      fileReader.close();
      bufferedReader.close();
    } catch (IOException e){
      e.printStackTrace();
    }
  }
 private int countEnglishWords(String decryptedMessage){
    int matchesCount = 0;
    String[] words = decryptedMessage.split(" ");
    for (String word : words){
      if (this.englishWords.contains(word)){
        matchesCount++;
      }
    }
    return matchesCount;
 }
 public boolean isMessageEnglish(String decryptedMessage){
    int matches = countEnglishWords(decryptedMessage.toUpperCase());
    int wordsCount = decryptedMessage.split(" ").length;
    if (((float)matches / wordsCount*100) >= 70){
      return true;
    } else
    return false;
 }
}
