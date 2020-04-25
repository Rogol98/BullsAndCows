package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;

public class ObtainingAllWords {

    static String[] wordsFromOriginalFile() {

        String fileText = "";
        StringBuilder fileTextBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("resources\\polish_words_original_file.txt"))) {
            while (scanner.hasNextLine()) {
                fileTextBuilder.append(scanner.nextLine().replaceAll("\\s+", "").replace(",", "\n") + "\n");
            }
            fileText = fileTextBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileText.split("\n");
    }

    static String[] sortAlphabetically() {
        String[] strings = wordsFromOriginalFile();
        try (PrintWriter printWriter = new PrintWriter("resources\\all_polish_words_alphabetically.txt")) {

            strings = Stream.of(strings).map(String::toLowerCase).sorted().toArray(String[]::new);

            for (String string : strings) {
                printWriter.println(string);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return strings;
    }

    static String[] wordsFromModifiedFile() {

        String fileText = "";
        StringBuilder fileTextBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File("resources\\all_polish_words_alphabetically.txt"))) {
            while (scanner.hasNextLine()) {
                fileTextBuilder.append(scanner.nextLine() + "\n");
            }
            fileText = fileTextBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] strings = fileText.split("\n");

        return strings;
    }
}
