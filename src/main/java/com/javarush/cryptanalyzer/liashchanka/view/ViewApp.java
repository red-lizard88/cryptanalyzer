package com.javarush.cryptanalyzer.liashchanka.view;

import com.javarush.cryptanalyzer.liashchanka.functions.RandomKey;
import com.javarush.cryptanalyzer.liashchanka.functions.ReadAndWriteFile;
import com.javarush.cryptanalyzer.liashchanka.services.BruteForce;
import com.javarush.cryptanalyzer.liashchanka.services.Coding;
import com.javarush.cryptanalyzer.liashchanka.services.Decoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.javarush.cryptanalyzer.liashchanka.constants.PathsFiles.*;
import static com.javarush.cryptanalyzer.liashchanka.constants.ViewConstants.*;

public class ViewApp extends JFrame {
    JTextField pathInputFileField, keyForCodingField, pathEncodedField, keyForEncodingField;

    public ViewApp() {
        super(TITLE_APP);
        super.setBounds(300, 200, 700, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel pathInputFile = new JLabel(PATH_INPUT_FILE);
        pathInputFileField = new JTextField("", 1);

        JLabel keyForCoding = new JLabel(KEY_FOR_DECODING);
        keyForCodingField = new JTextField("", 1);

        JButton buttonForCoding = new JButton(BUTTON_CODING);

        JLabel blank = new JLabel("");

        JLabel pathEncodingFile = new JLabel(PATH_ENCODING);
        pathEncodedField = new JTextField("", 1);

        JLabel keyForEncoding = new JLabel(KEY_FOR_ENCODING);
        keyForEncodingField = new JTextField("", 1);

        JButton buttonForEncoding = new JButton(BUTTON_ENCODING);
        JButton buttonBruteForce = new JButton(BRUT_FORCE);


        container.add(pathInputFile);
        container.add(pathInputFileField);
        container.add(keyForCoding);
        container.add(keyForCodingField);
        container.add(buttonForCoding);

        container.add(blank);
        container.add(pathEncodingFile);
        container.add(pathEncodedField);
        container.add(keyForEncoding);
        container.add(keyForEncodingField);
        container.add(buttonForEncoding);
        container.add(buttonBruteForce);

        buttonForCoding.addActionListener(new ButtonCoding());
        buttonForEncoding.addActionListener(new ButtonEncoding());
        buttonBruteForce.addActionListener(new ButtonBruteForce());

    }

    class ButtonCoding implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pathInputFile;
            if(!pathInputFileField.getText().equals("")){
                pathInputFile = pathInputFileField.getText();
            }else {
                pathInputFile = INPUT;
            }

            int key;
            if(!keyForCodingField.getText().equals("")){
                key = Integer.parseInt(keyForCodingField.getText());
            }else {
                key = RandomKey.generateRandomKey();
            }

            String textForCoding = ReadAndWriteFile.readFile(pathInputFile);
            StringBuilder textAfterCoding = Coding.codingText(textForCoding, key);

            ReadAndWriteFile.writeFile(textAfterCoding, DEST);

            JOptionPane.showMessageDialog(null, "Текст закодирован ключом: " +
                    key + "\nРезультат кодирования: "+textAfterCoding, "Кодирование текста", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEncoding implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String pathEncodingFile;
            if(!pathEncodedField.getText().equals("")){
                pathEncodingFile = pathEncodedField.getText();
            }else {
                pathEncodingFile = DEST;
            }

            int key;
            if(!keyForEncodingField.getText().equals("")){
                key = Integer.parseInt(keyForEncodingField.getText());
            }else {
                key = 1;
            }


            String textForDecoding = ReadAndWriteFile.readFile(pathEncodingFile);
            StringBuilder textAfterDecoding = Decoding.decodingText(textForDecoding, key);

            ReadAndWriteFile.writeFile(textAfterDecoding, OUTPUT);


            JOptionPane.showMessageDialog(null, "Результат раскодирования: "+textAfterDecoding,
                    "Раскодирование текста", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonBruteForce implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String textForDecoding = ReadAndWriteFile.readFile(DEST);
            String textAfterDecoding = BruteForce.makeBruteForse(textForDecoding);

            ReadAndWriteFile.writeFile(new StringBuilder(textAfterDecoding), OUTPUT);


            JOptionPane.showMessageDialog(null, "Результат раскодирования методом Брут форс: "
                            +textAfterDecoding,
                    "Брут форс", JOptionPane.PLAIN_MESSAGE);
        }
    }


}
