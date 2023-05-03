package com.javarush.cryptanalyzer.liashchanka;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import static com.javarush.cryptanalyzer.liashchanka.CryptoAlphabet.ALPHABET;

public class Main {
    public static void main(String[] args) {


        String textForCoding = "Здравствуйте, меня зовут Илья. Я программист.";
        int key = 3;

        StringBuilder textCoding = new StringBuilder();
        //char charSymbol = 'З';

        for (int i = 0; i < textForCoding.length(); i++) {
            for (int j = 0; j < ALPHABET.length(); j++) {
                   if(textForCoding.charAt(i) == ALPHABET.charAt(j)){
                        System.out.println(textForCoding.charAt(i));
                  }



            }



        }





//
//        FileOutputStream fileOutputStream = new FileOutputStream("input.txt");
//        fileOutputStream.write(123);


    }
}