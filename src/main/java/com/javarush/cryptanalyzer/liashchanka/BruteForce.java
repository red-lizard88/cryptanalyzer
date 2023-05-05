package com.javarush.cryptanalyzer.liashchanka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptanalyzer.liashchanka.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyzer.liashchanka.Main.makeNewAlphabetWithKey;

public class BruteForce {

    public static int counter;

    public static void main(String[] args) {
        String str = "Здравствуйте, меня зовут Илья! Я, программист?";

        countSymbolsRegExp(str);


        System.out.println(counter);
    }

    // Подсчет символов используя регулярку
    public static void countSymbols(String substr, String str) {
        Pattern p = Pattern.compile(substr);
        Matcher m = p.matcher(str);
        while (m.find()) {
            counter++;
        }
    }

    // Подсчет конкретных символов используя регулярку
    public static int countSymbolsRegExp(String str) {
        String substr1 = ", ";
        String substr2 = "\\. ";
        String substr3 = "! ";
        String substr4 = "\\? ";
        String substr5 = " ";

        countSymbols(substr1, str);
        countSymbols(substr2, str);
        countSymbols(substr3, str);
        countSymbols(substr4, str);
        countSymbols(substr5, str);

        return counter;
    }

    // Расшифровка текста методом брутфорс
    public static void makeBruteForse(String textCodingFromFile) {
        List<String> variantTextOfDecoding = new ArrayList<>();
        List<Integer> countOfDecoding = new ArrayList<>();

        for (int k = 1; k < 84; k++) {
            StringBuilder textDeCodingBrutForce = new StringBuilder();
            for (int i = 0; i < textCodingFromFile.length(); i++) {
                for (int j = 0; j < makeNewAlphabetWithKey(k).length(); j++) {
                    if (textCodingFromFile.charAt(i) == makeNewAlphabetWithKey(k).charAt(j)) {
                        textDeCodingBrutForce.append(ALPHABET.charAt(j));

                    }
                }
            }
            counter = 0;
// Выбираем максимальное количество пробелов, точка с пробелом и т.д. из вариантов шифровок
            variantTextOfDecoding.add(String.valueOf(textDeCodingBrutForce));
            countOfDecoding.add(countSymbolsRegExp(String.valueOf(textDeCodingBrutForce)));
        }
        int indexMaxValue = countOfDecoding.indexOf(Collections.max(countOfDecoding));

        System.out.println(variantTextOfDecoding.get(indexMaxValue));


    }


}
