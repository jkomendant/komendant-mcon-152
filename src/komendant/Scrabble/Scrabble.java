package komendant.Scrabble;

import java.io.*;
import java.util.*;

public class Scrabble {

    Hashtable<Integer, String> hashtable = new Hashtable<>();

    public void addWords() throws FileNotFoundException {
        String Filename = "C:/Users/Chashie/Downloads/dictionary.txt";
        File file = new File(Filename);
        Scanner scanner = new Scanner(file);

        int count = 0;
        while (scanner.hasNext()) {
            hashtable.put(count, scanner.next());
            scanner.nextLine();
            count++;
        }

    }

    public boolean isWord(String word) {
        String containsWord = word.toUpperCase();
        return hashtable.contains(containsWord);
    }
}