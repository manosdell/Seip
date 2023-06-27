package codeanalyzer;

/**
 * This class is responsible for handling the case where the
 * analyzer type is unknown (neither string nor regex).
 * It extends the SourceCodeAnalyzer abstract class.
 * It implements the Null Object design pattern.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class NullAnalyzer extends SourceCodeAnalyzer{

    public NullAnalyzer(SourceFileReader fileReaderType) {
        super(fileReaderType);
    }

    /**
     * This method prints an error message.
     *
     * @param filepath The path of the file to be analyzed.
     * @return The number zero.
     */
    @Override
    public int calculateLOC(String filepath) {
        System.err.print("Unknown analyzer type\n");
        return 0;
    }

    /**
     * This method prints an error message.
     *
     * @param filepath The path of the file to be analyzed.
     * @return The number zero.
     */
    @Override
    public int calculateNOM(String filepath) {
        System.err.print("Unknown analyzer type\n");
        return 0;
    }

    /**
     * This method prints an error message.
     *
     * @param filepath The path of the file to be analyzed.
     * @return The number zero.
     */
    @Override
    public int calculateNOC(String filepath) {
        System.err.print("Unknown analyzer type\n");
        return 0;
    }

}
