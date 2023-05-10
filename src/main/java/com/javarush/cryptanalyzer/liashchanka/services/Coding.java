package com.javarush.cryptanalyzer.liashchanka.services;

import com.javarush.cryptanalyzer.liashchanka.functions.AlphabetWithKey;

import static com.javarush.cryptanalyzer.liashchanka.constants.CryptoAlphabet.ALPHABET;

public class Coding {

    // Шифрование нашего текста
    public static StringBuilder codingText(String textForCoding, int key) {
        StringBuilder textAfterCoding = new StringBuilder();
        for (int i = 0; i < textForCoding.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                if (textForCoding.charAt(i) == ALPHABET.charAt(j)) {
                    textAfterCoding.append(AlphabetWithKey.makeNewAlphabetWithKey(key).charAt(j));
                }
            }
        }
        return textAfterCoding;
    }

}
