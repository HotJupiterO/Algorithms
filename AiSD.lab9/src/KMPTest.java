import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPTest {
    KMP kmp;

    @BeforeEach
    void setUp() {
        kmp = new KMP();
    }

    /*@Test
    void searchInTextTest() throws IOException {
        File file = new File("shortText");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = "", line;
        while ((line = br.readLine()) != null) {
            text += line;
            text += "\n";
        }
        br.close();

        String pattern = "algorithm";
        long result;
        int index;
        long before = System.nanoTime();
        index = kmp.search(pattern, text);
        long after = System.nanoTime();
        result = after - before;
        System.out.println("Test for short text");
        System.out.println("Time in nanos = " + result);
        System.out.println("Index of char from which sought pattern started" + index);
    }*/

    @Test
    void searchInBookTest() throws IOException {
        File file = new File("book.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String book = "", line;
        while ((line = br.readLine()) != null) {
            book += line;
            book += "\n";
        }
        br.close();

        String pattern = "The Project Gutenberg";
        long result;
        int index;
        long before = System.nanoTime();
        index = kmp.search(pattern, book);
        long after = System.nanoTime();
        result = after - before;
        System.out.println();
        System.out.println("Test for book");
        System.out.println("Time = " + result/10e6 + " millis");
        System.out.println("Index of char from which sought pattern started: " + index);
        System.out.println();
        assertEquals(0, index);
    }

    @Test
    public void prefixFunctionTest() {
        String pattern = "abbaabbab";
        int[] expected = {0, 0, 0, 1, 1, 2, 3, 4, 2};
        int[] actual = kmp.prefixFunction(pattern);
        assertArrayEquals(expected, actual);
    }
}