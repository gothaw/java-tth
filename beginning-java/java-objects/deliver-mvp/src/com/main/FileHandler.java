package com.main;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {

    public static void saveScoreToFile(String playerName) throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            fileWriter = new FileWriter(Constants.SCORE_FILE_NAME);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Highest Score:" + Prompter.highestScore + "\nPlayer Name:" + playerName);

        } catch (IOException e) {
            throw e;
        } finally {

            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }

        }
    }

    public static void readScoreFromFile() throws IOException {
        File file = new File(Constants.SCORE_FILE_NAME);

        if (file.exists()) {

            FileReader fileReader = null;
            BufferedReader bufferedReader = null;

            try {
                fileReader = new FileReader(Constants.SCORE_FILE_NAME);

                bufferedReader = new BufferedReader(fileReader);

                String line;
                ArrayList<String> scoreData = new ArrayList<>();

                while((line = bufferedReader.readLine()) != null){

                    String[] content = line.split(":");
//                    System.out.println(Arrays.toString(content));
                    scoreData.add(content[1]);
                }

                Prompter.highestScore = Integer.parseInt(scoreData.get(0));
                Prompter.highestScoredPlayer = scoreData.get(1);

            } catch (IOException io) {
                throw io;
            } finally {

                if (bufferedReader != null) {
                    bufferedReader.close();
                }

                if (fileReader != null) {
                    fileReader.close();
                }

            }
        }

    }
}
