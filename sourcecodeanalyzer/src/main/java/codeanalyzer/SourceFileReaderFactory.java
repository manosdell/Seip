package codeanalyzer;

/**
 * This class is responsible for creating the appropriate SourceFileReader
 * object. It uses the Factory Method design pattern.
 * It also implements the SourceFileReader interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class SourceFileReaderFactory {

    /**
     * This method creates the appropriate SourceFileReader object.
     *
     * @param location The location of the file to be read.
     * @return The appropriate SourceFileReader object.
     */
    public SourceFileReader createSourceFileReader(String location) {
        SourceFileReader reader = null;
        if (location.equals("local")) {
            reader = new LocalFileReader();
        } else if (location.equals("web")) {
            reader = new WebFileReader();
        } else {
            reader = new NullFileReader();
        }
        return reader;
    }
}
