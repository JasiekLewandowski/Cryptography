package OneTimePadCipher;

import java.util.Random;

public class RandomKeyGenerator {
  Random random;

  public RandomKeyGenerator() {
    this.random = new Random();
  }

  public int[] generate (int messageLength){
    int[] randomKeys = new int[messageLength];
    for (int i = 0;i < messageLength;i++){
      randomKeys[i] = random.nextInt(Constants.ALPHABET.length());
    }
    return randomKeys;
  }
}
