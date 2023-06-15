package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This interface is responsible for reading a file into a list of strings or a
 * string. It is used by the SourceCodeAnalyzer class.
 * It is part of the Strategy design pattern.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public interface SourceFileReader {

    List<String> readFileIntoList(String filepath) throws IOException;

    String readFileIntoString(String filepath) throws IOException;
}
