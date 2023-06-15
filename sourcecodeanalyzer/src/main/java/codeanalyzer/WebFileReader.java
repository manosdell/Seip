package codeanalyzer;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This class is responsible for reading a file from the web into a list of strings or a
 * string. It implements the SourceFileReader interface. It is part of the Strategy design pattern.
 * It also uses the BufferedReader class.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class WebFileReader implements SourceFileReader {

    /**
     * This method reads a file from the web into a list of strings.
     *
     * @param filepath The location of the file to be read.
     * @return The list of strings that the file contains.
     * @throws IOException If the file cannot be read.
     */
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    /**
     * This method reads a file from the web into a string.
     *
     * @param filepath The location of the file to be read.
     * @return The string that the file contains.
     * @throws IOException If the file cannot be read.
     */
    public String readFileIntoString(String filepath) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }
}
