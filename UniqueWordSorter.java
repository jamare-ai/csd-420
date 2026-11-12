package csd420.mod5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Jamare Noah McCallum
// 2024-01-21
// CSD420 - Module 5

public class UniqueWordSorter {

    private final Path wordFile;

    public UniqueWordSorter(String filename) {
        this.wordFile = Path.of(filename);
    }

    public List<String> getWords(boolean descending) throws IOException {
        String content = Files.readString(wordFile);
        String[] tokens = content.split("\\s+");

        Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String token : tokens) {
            if (!token.isEmpty()) {
                uniqueWords.add(token.toLowerCase());
            }
        }

        List<String> orderedWords = new ArrayList<>(uniqueWords);
        if (descending) {
            Collections.reverse(orderedWords);
        }
        return orderedWords;
    }

    public void displaySortedWords() throws IOException {
        System.out.println("Non-duplicate words in ascending order:");
        for (String word : getWords(false)) {
            System.out.println(word);
        }

        System.out.println("\nNon-duplicate words in descending order:");
        for (String word : getWords(true)) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        try {
            UniqueWordSorter sorter = new UniqueWordSorter("collection_of_words.txt");
            sorter.displaySortedWords();
        } catch (IOException e) {
            System.err.println("Unable to read the word file: " + e.getMessage());
        }
    }
}
