package komendant.scrabble;

import java.io.*;
import java.util.*;

public class Scrabble {

    HashSet<String> hashSet = new HashSet<>();

    public Scrabble() throws FileNotFoundException {
        String Filename = "dictionary.txt";
        File file = new File(Filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            hashSet.add(scanner.next());
            scanner.nextLine();
        }

    }

    public boolean isWord(String word) {
        String containsWord = word.toUpperCase();
        return hashSet.contains(containsWord);
    }
}