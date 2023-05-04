package com.javarush.cryptanalyzer.liashchanka;

import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

import static com.javarush.cryptanalyzer.liashchanka.CryptoAlphabet.ALPHABET;

public class Main {
    public static void main(String[] args) {

        String textForCoding;
        String textCodingFromFile;

        String input = "input.txt";
        String dest = "encoded.txt";
        String output = "output.txt";

// Читаем данные из файла input.txt
        try(FileReader in = new FileReader(input);
            BufferedReader reader = new BufferedReader(in))
        {
            textForCoding = reader.readLine();

            System.out.println(textForCoding);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //   String textForCoding = "Здравствуйте, меня зовут Илья! Я программист?";
        Random random = new SecureRandom();
        int key = random.nextInt(83 - 1 + 1) + 1;

        System.out.println("Ключ: "+key);


        StringBuilder textAfterCoding = new StringBuilder();
        StringBuilder textDeCoding = new StringBuilder();

        System.out.println(ALPHABET);
        System.out.println(makeNewAlphabetWithKey(key));


// Шифрование нашего текста
        for (int i = 0; i < textForCoding.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                if (textForCoding.charAt(i) == ALPHABET.charAt(j)) {
                    textAfterCoding.append(makeNewAlphabetWithKey(key).charAt(j));

                }
            }
        }

// Записываем зашифрованный текст в файл encoded.txt
        try(FileWriter out = new FileWriter(dest);
            BufferedWriter writer = new BufferedWriter(out))
        {
            writer.write(String.valueOf(textAfterCoding));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// Читаем данные из файла encoded.txt
        try(FileReader in = new FileReader(dest);
            BufferedReader reader = new BufferedReader(in))
        {
            textCodingFromFile = reader.readLine();

            System.out.println(textCodingFromFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


// Расшифровка нашего текста
        for (int i = 0; i < textCodingFromFile.length(); i++) {
            for (int j = 0; j < makeNewAlphabetWithKey(key).length(); j++) {
                if (textCodingFromFile.charAt(i) == makeNewAlphabetWithKey(key).charAt(j)) {
                    textDeCoding.append(ALPHABET.charAt(j));

                }
            }
        }


// Записываем расшифрованный текст в файл output.txt
        try(FileWriter out = new FileWriter(output);
            BufferedWriter writer = new BufferedWriter(out))
        {
            writer.write(String.valueOf(textDeCoding));
            System.out.println(textDeCoding);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("--------------------------------");

// Расшифровка текста методом брутфорс
        for (int k = 1; k < 84; k++) {
            StringBuilder textDeCodingBrutForce = new StringBuilder();
            for (int i = 0; i < textCodingFromFile.length(); i++) {
                for (int j = 0; j < makeNewAlphabetWithKey(k).length(); j++) {
                    if (textCodingFromFile.charAt(i) == makeNewAlphabetWithKey(k).charAt(j)) {
                        textDeCodingBrutForce.append(ALPHABET.charAt(j));

                    }
                }
            }
            System.out.println(k + " " + textDeCodingBrutForce);
        }














    }

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