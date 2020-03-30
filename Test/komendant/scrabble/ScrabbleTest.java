package komendant.scrabble;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleTest {

    @Test
    public void isWordExists() throws FileNotFoundException {
        //given
        Scrabble scrabble = new Scrabble();


        //when
        String word = "ARM";

        //then
        assertTrue(scrabble.isWord(word));
    }

    @Test
    public void isWordDoesNotExist() throws FileNotFoundException {
        //given
        Scrabble scrabble = new Scrabble();


        //when
        String word = "AJE";

        //then
        assertFalse(scrabble.isWord(word));
    }

    @Test
    public void isWordCaseInsensitive() throws FileNotFoundException {
        //given
        Scrabble scrabble = new Scrabble();


        //when
        String word = "arm";

        //then
        assertTrue(scrabble.isWord(word));
    }

}