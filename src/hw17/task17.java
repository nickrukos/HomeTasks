package hw17;

import java.io.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class task17
{
    public static void readWithScanner(String filename) throws IOException {
        /* Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8)
                .useDelimiter(" "); для чтения по указанному разделителю */
        String findStr = "spam";
        int lastIndex;
        int count = 0;
        try (Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8)) {
            String line = null;

            while (scanner.hasNextLine()) {
                lastIndex = 0;
                line = scanner.nextLine();
                while (lastIndex != -1) {

                    lastIndex = line.indexOf(findStr, lastIndex);

                    if (lastIndex != -1) {
                        count++;
                        lastIndex += findStr.length();
                    }
                }
            }
            System.out.println("Number of Occurrences of the word 'spam' in the file " + count);
            scanner.close();
            if (scanner.ioException() != null) {
                throw scanner.ioException();
            }
        }
    }
    public static void readWithFilesToStream(String filename) throws IOException {
        // ресурс закрывается, когда закрывается Stream
        try (Stream<String> lines = Files.lines(Path.of(filename))) {
            System.out.println("Number of Occurrences of the word 'spam' in the file "
                               + lines.filter(s->s.contains("spam")).count());

        }
    }
    public static void main(String[] args) {
        try {
            readWithScanner("src/hw17/text.txt");
            readWithFilesToStream("src/hw17/text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
