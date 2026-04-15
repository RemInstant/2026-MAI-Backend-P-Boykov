package org.reminstant;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

  private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DIGITS = "0123456789";
  private static final String SPECIAL = "#.,!@&^%*";

  private static final int MIN_LENGTH = 8;
  private static final int MAX_ADD_LENGTH = 8;

  private final Random random;

  public PasswordGenerator() {
    this.random = new SecureRandom();
  }

  public String generate() {
    int addLength = random.nextInt(0, MAX_ADD_LENGTH + 1);
    int length = MIN_LENGTH + addLength;

    int availableAddCount = length - 4;

    int lowercaseAddCount = random.nextInt(0, availableAddCount + 1);
    availableAddCount -= lowercaseAddCount;

    int uppercaseAddCount = random.nextInt(0, availableAddCount + 1);
    availableAddCount -= uppercaseAddCount;

    int digitsAddCount = random.nextInt(0, availableAddCount + 1);
    availableAddCount -= digitsAddCount;

    int specialAddCount = availableAddCount;

    int lowercaseCount = 1 + lowercaseAddCount;
    int uppercaseCount = 1 + uppercaseAddCount;
    int digitsCount = 1 + digitsAddCount;
    int specialCount = 1 + specialAddCount;

    List<Character> chars = new ArrayList<>();
    for (int i = 0; i < lowercaseCount; ++i) {
      chars.add(getRandomChar(LOWERCASE));
    }
    for (int i = 0; i < uppercaseCount; ++i) {
      chars.add(getRandomChar(UPPERCASE));
    }
    for (int i = 0; i < digitsCount; ++i) {
      chars.add(getRandomChar(DIGITS));
    }
    for (int i = 0; i < specialCount; ++i) {
      chars.add(getRandomChar(SPECIAL));
    }

    Collections.shuffle(chars, random);
    StringBuilder builder = new StringBuilder(chars.size());
    chars.forEach(builder::append);

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return builder.toString();
  }

  private char getRandomChar(String chars) {
    int pos = random.nextInt(0, chars.length());
    return chars.charAt(pos);
  }
}
