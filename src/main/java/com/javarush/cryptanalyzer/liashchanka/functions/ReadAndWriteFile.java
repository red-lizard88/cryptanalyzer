package com.javarush.cryptanalyzer.liashchanka.functions;

import java.io.*;

import static com.javarush.cryptanalyzer.liashchanka.constants.PathsFiles.*;

public class ReadAndWriteFile {

    // Читаем данные из файла input.txt или encoded.txt
    public static String readFile(String input) {
        try (
                FileReader in = new FileReader(input);
                BufferedReader reader = new BufferedReader(in)) {
            return reader.readLine();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Записываем зашифрованный текст в файл encoded.txt или расшифрованный в output.txt
    public static void writeFile(StringBuilder text, String path) {
        try (
            FileWriter out = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(out)) {
            writer.write(String.valueOf(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
