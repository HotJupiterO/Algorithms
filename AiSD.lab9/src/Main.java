import java.io.*;

public class Main {
    private static KMP kmp = new KMP();

    public static void main(String[] args) {
        printTime();
//        for(String fileNames : file.list()) System.out.println(fileNames);
    }

    private static void printTime() {
        String[] books = new String[4];
        books[0] = writeToString(new File("book2.txt"));
        books[1] = writeToString(new File("book3.txt"));
        books[2] = writeToString(new File("book4.txt"));
        books[3] = writeToString(new File("book.txt"));

        String[] texts = new String[4];
        texts[0] = writeToString(new File("shortText"));
        texts[1] = writeToString(new File("shortText2.txt"));
        texts[2] = writeToString(new File("shortText3.txt"));
        texts[3] = writeToString(new File("shortText4.txt"));

        String patternForBooks = "wqeqw"; // from the end of book
       int index1=kmp.search(patternForBooks, books[3]);
        System.out.println("============"+index1);

        System.out.println("==================================");
        System.out.println("Test for books");
        System.out.println("==================================");
      /*  for (int i = 0; i < books.length; i++) {
            long before = System.currentTimeMillis();
            int index = kmp.search(patternForBooks, books[i]);
            long after = System.currentTimeMillis();
            double result = (double)(after - before);

            System.out.println("For " + (i + 1) + " (th) book:");
            System.out.println("Time = " + result + " millis");
            System.out.println("Index of char from which sought pattern started: " + index);
            System.out.println();
        }
        System.out.println("==================================");



        String patternForTexts = "some";
        System.out.println("==================================");
        System.out.println("Test for short texts");
        System.out.println("==================================");
        for (int i = 0; i < texts.length; i++) {
            long before = System.currentTimeMillis();
            int index = kmp.search(patternForTexts, texts[i]);
            long after = System.currentTimeMillis();
            long result = (after - before);

            System.out.println("For " + (i + 1) + " (th) text:");
            System.out.println("Time = " + result + " millis");
            System.out.println("Index of char from which sought pattern started: " + index);
            System.out.println();
        }
        System.out.println("==================================");*/
    }


    private static String writeToString(File filepath) {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text += line;
                text += "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
