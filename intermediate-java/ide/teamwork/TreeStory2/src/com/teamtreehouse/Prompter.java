package com.teamtreehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Prompter {
    private BufferedReader mReader;
    private Set<String> mCensoredWords;
    private Scanner mScanner;

    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mScanner = new Scanner(System.in);
        loadCensoredWords();
    }

    private void loadCensoredWords() {
        mCensoredWords = new HashSet<String>();
        Path file = Paths.get("resources", "censored_words.txt");
        List<String> words = null;
        try {
            words = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println("Couldn't load censored words");
            e.printStackTrace();
        }
        mCensoredWords.addAll(words);
    }

    public void run(Template tmpl) {
        List<String> results = null;
        try {
            results = promptForWords(tmpl);
        } catch (IOException e) {
            System.out.println("There was a problem prompting for words");
            e.printStackTrace();
            System.exit(0);
        }
        String render = tmpl.render(results);
        System.out.println(render);
    }

    /**
     * Prompts user for each of the blanks
     *
     * @param tmpl The compiled template
     * @return
     * @throws IOException
     */
    public List<String> promptForWords(Template tmpl) throws IOException {
        List<String> words = new ArrayList<>();
        for (String phrase : tmpl.getPlaceHolders()) {
            String word = promptForWord(phrase);
            words.add(word);
        }
        return words;
    }


    /**
     * Prompts the user for the answer to the fill in the blank.  Value is guaranteed to be not in the censored words list.
     *
     * @param phrase The word that the user should be prompted.  eg: adjective, proper noun, name
     * @return What the user responded
     */
    public String promptForWord(String phrase) throws IOException {
        String word = "";
        boolean isGoodResponse = false;
        System.out.printf("Enter %s:%n", phrase);
        do {
            word = mScanner.nextLine();

            if (!mCensoredWords.contains(word.toLowerCase())) {
                isGoodResponse = true;
            }

        } while (!isGoodResponse);

        return word;
    }

    public String promptForTemplate() throws IOException{
        System.out.println("Please give your story template. Each place holder word to be wrapped in double underscores. Template Example: ");
        System.out.println("Hello __name__ You are a __adjective__ __noun__.");
        return mScanner.nextLine();
    }
}
