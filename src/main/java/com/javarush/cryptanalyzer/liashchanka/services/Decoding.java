package com.javarush.cryptanalyzer.liashchanka.services;

import com.javarush.cryptanalyzer.liashchanka.functions.AlphabetWithKey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptanalyzer.liashchanka.constants.CryptoAlphabet.ALPHABET;

public class Decoding {

// Расшифровка нашего текста
    public static StringBuilder decodingText(String text, int key) {
        StringBuilder textDeCoding = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < AlphabetWithKey.makeNewAlphabetWithKey(key).length(); j++) {
                if (text.charAt(i) == AlphabetWithKey.makeNewAlphabetWithKey(key).charAt(j)) {
                    textDeCoding.append(ALPHABET.charAt(j));

                }
            }
        }
        return textDeCoding;
    }
}
