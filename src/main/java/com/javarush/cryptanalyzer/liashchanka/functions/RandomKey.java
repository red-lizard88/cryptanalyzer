package com.javarush.cryptanalyzer.liashchanka.functions;

import java.security.SecureRandom;
import java.util.Random;

public class RandomKey {
    public static int generateRandomKey(){
        Random random = new SecureRandom();
        return random.nextInt(83 - 1 + 1) + 1;
    }
}
