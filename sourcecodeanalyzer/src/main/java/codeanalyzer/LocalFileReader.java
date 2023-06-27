package codeanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * This class is responsible for reading the contents of a given file.
 * The file is stored locally.
 * It implements the SourceFileReader interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class LocalFileReader implements SourceFileReader {

    /**
     * This method reads the contents of a file and stores them in a list.
     * Each line of the file is stored as an element of the list.
     *
     * @param filepath The path of the file to be read.
     * @return The contents of the file as a list.
     * @throws IOException If the file does not exist.
     */
    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * This method reads the contents of a file and stores them in a string.
     *
     * @param filepath The path of the file to be read.
     * @return The contents of the file as a single string.
     * @throws IOException If the file does not exist.
     */
    @Override
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }
}
