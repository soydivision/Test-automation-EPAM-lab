package com.epam.core.utilities.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public final class StringService {
    private static final String REGEXP = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    private StringService() {
    }

    public static String getRandomString(final int len) {
        StringBuilder builder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            builder.append(REGEXP.charAt(RANDOM.nextInt(REGEXP.length())));
        }
        return builder.toString();
    }

    public static String getFirstWordFromString(final String string, final String regex) {
        String[] wordsFromString = string.split(regex);
        return wordsFromString[0];
    }

    public static List<String> getWordsFromString(final String testForParsing) {
        return Arrays.asList(testForParsing.split(" "));
    }

    public static String getCapitalizedWord(String word) {
        String firstLetterInWordToUpperCase = word.substring(0, 1).toUpperCase();
        word = firstLetterInWordToUpperCase + word.substring(1);
        return word;
    }

    public static int getNumberOfEqualWordsInStrings(final String firstString, final String secondString) {
        List<String> wordsFromFirstString = getWordsFromString(firstString);
        List<String> wordsFromSecondString = getWordsFromString(secondString);
        int numberOfEqualWords = 0;
        for (String wordFromFirstString : wordsFromFirstString) {
            for (String wordFromSecondString : wordsFromSecondString) {
                if (wordFromSecondString.equalsIgnoreCase(wordFromFirstString)) {
                    numberOfEqualWords++;
                }
            }
        }
        return numberOfEqualWords;
    }
}
