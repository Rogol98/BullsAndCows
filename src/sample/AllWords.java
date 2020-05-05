package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Stream;

public class AllWords {

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

    static String[] wordsFromModifiedFile(String playersWord) {

        String pathname = "";
        switch (playersWord.charAt(0)){
            case 'a': pathname =  "resources\\polish_words_A.txt";
            break;
            case 'b': pathname =  "resources\\polish_words_B.txt";
                break;
            case 'c': pathname =  "resources\\polish_words_C.txt";
                break;
            case 'd': pathname =  "resources\\polish_words_D.txt";
                break;
            case 'e': pathname =  "resources\\polish_words_E.txt";
                break;
            case 'f': pathname =  "resources\\polish_words_F.txt";
                break;
            case 'g': pathname =  "resources\\polish_words_G.txt";
                break;
            case 'h': pathname =  "resources\\polish_words_H.txt";
                break;
            case 'i': pathname =  "resources\\polish_words_I.txt";
                break;
            case 'j': pathname =  "resources\\polish_words_J.txt";
                break;
            case 'k': pathname =  "resources\\polish_words_K.txt";
                break;
            case 'l': pathname =  "resources\\polish_words_L.txt";
                break;
            case 'm': pathname =  "resources\\polish_words_M.txt";
                break;
            case 'n': pathname =  "resources\\polish_words_N.txt";
                break;
            case 'o': pathname =  "resources\\polish_words_O.txt";
                break;
            case 'p': pathname =  "resources\\polish_words_P.txt";
                break;
            case 'r': pathname =  "resources\\polish_words_R.txt";
                break;
            case 's': pathname =  "resources\\polish_words_S.txt";
                break;
            case 't': pathname =  "resources\\polish_words_T.txt";
                break;
            case 'u': pathname =  "resources\\polish_words_U.txt";
                break;
            case 'w': pathname =  "resources\\polish_words_W.txt";
                break;
            case 'z': pathname =  "resources\\polish_words_Z.txt";
                break;
            default: pathname =  "resources\\polish_words_Rest.txt";
                break;
        }

        String fileText = "";
        StringBuilder fileTextBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(pathname))) {
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
