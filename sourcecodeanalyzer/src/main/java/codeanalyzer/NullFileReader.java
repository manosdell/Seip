package codeanalyzer;

import java.util.List;

/**
 * This class is responsible for handling the case where the
 * file reader type is unknown. It implements the Null Object
 * design pattern. It also implements the SourceFileReader interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class NullFileReader implements SourceFileReader {

    /**
     * This method prints an error message.
     *
     * @param filepath The path of the file to be read.
     * @return null.
     */
    @Override
    public List<String> readFileIntoList(String filepath) {
        System.err.println("Unknown file reader type. \n");
        return null;
    }

    /**
     * This method prints an error message.
     *
     * @param filepath The path of the file to be read.
     * @return null.
     */
    @Override
    public String readFileIntoString(String filepath) {
        System.err.println("Unknown file reader type. \n");
        return null;
    }
}
