package com.solvd.deliveryservice.fileanalizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;


public class FileAnalyzerTwo {
    private final static Logger LOGGER = LogManager.getLogger(FileAnalyzerTwo.class);

    public static void main(String[] args) {

        wordCounter1("src/main/resources/text/sample.txt", "fly");
    }

    public static void wordCounter1(String path, String target) {
        try {
            File file = new File(path);

            FileAnalyzerTwo.LOGGER.info("Reading the file and converting words to lower case");
            final String[] text = {StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"))};

            FileAnalyzerTwo.LOGGER.info("Removing punctuation");
            // uses stream forEach() to remove punctuation
            Stream.of(",", "?", "!", ".", "-", ":", ";", "/").forEach((String el)-> text[0] = StringUtils.remove(text[0], el));

            FileAnalyzerTwo.LOGGER.info("Counting target word frequency");
            List<String> wordList = new ArrayList<>(Arrays.asList(StringUtils.split(text[0], " ")));
            // uses stream filter() to count target word frequency
            long count = wordList.stream().filter((String el)-> el.equals(target)).count();

            FileAnalyzerTwo.LOGGER.info("Creating a new file at src/main/resources/text");
            File newFile = new File ("src/main/resources/text/output.txt");
            FileUtils.touch(newFile);

            FileAnalyzerTwo.LOGGER.info("Writing to the new file");
            FileUtils.write(newFile, "\""+target+"\""+" count="+count, "UTF-8", false);
            FileAnalyzerTwo.LOGGER.info("Successful");
        } catch (IOException e) {
            FileAnalyzerTwo.LOGGER.error(e.getMessage(), e);
        }
    }
}
