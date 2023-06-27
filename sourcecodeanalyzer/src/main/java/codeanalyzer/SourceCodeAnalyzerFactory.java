package codeanalyzer;

/**
 * This class is responsible for creating the appropriate SourceCodeAnalyzer
 * object. It uses the Factory Method design pattern.
 * It also implements the SourceCodeAnalyzer interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class SourceCodeAnalyzerFactory {

    /**
     * This method creates the appropriate SourceCodeAnalyzer object.
     *
     * @param fileReaderType The type of the file reader.
     * @param location The location of the file to be read.
     * @return The appropriate SourceCodeAnalyzer object.
     */
    public SourceCodeAnalyzer createSourceCodeAnalyzer(String fileReaderType, SourceFileReader location) {
        SourceCodeAnalyzer analyzer = null;
        if (fileReaderType.equals("regex")) {
            analyzer = new RegexAnalyzer(location);
        } else if (fileReaderType.equals("strcomp")) {
            analyzer = new StringAnalyzer(location);
        } else {
            analyzer = new NullAnalyzer(location);
        }
        return analyzer;
    }
}
