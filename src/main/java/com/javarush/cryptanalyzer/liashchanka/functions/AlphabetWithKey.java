package com.javarush.cryptanalyzer.liashchanka.functions;

import static com.javarush.cryptanalyzer.liashchanka.constants.CryptoAlphabet.ALPHABET;

public class AlphabetWithKey {

    // Создание алфавита со смещением (ключом)
    public static StringBuilder makeNewAlphabetWithKey(int key) {
        StringBuilder newAlphabet = new StringBuilder();
        for (int i = key; i < ALPHABET.length(); i++) {
            newAlphabet.append(ALPHABET.charAt(i));
            if (i == ALPHABET.length() - 1) {
                for (int j = 0; j < key; j++) {
                    newAlphabet.append(ALPHABET.charAt(j));
                }
            }

        }
        return newAlphabet;
    }
}
