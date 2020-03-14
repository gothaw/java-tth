package com.teamtreehouse;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Prompter prompter = new Prompter();

        Template tmpl = null;
        try {
            tmpl = new Template(prompter.promptForTemplate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        prompter.run(tmpl);
    }
}
