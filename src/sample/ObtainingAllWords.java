package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObtainingAllWords {

    static String[] listOfAllWords() {

        String fileText = "";
        StringBuilder fileTextBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("all_polish_words.txt"))) {
            while (scanner.hasNextLine()) {
                fileTextBuilder.append(scanner.nextLine().replaceAll("\\s+", "").replace(",", "\n")+"\n");
            }
            fileText = fileTextBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] strings = fileText.split("\n");

        return strings;
    }
}
