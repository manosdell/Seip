package codeanalyzer;

import java.io.IOException;

/**
 * This class is responsible for calculating the metrics of a given source code
 * file. It implements the calculateLOC, calculateNOM and calculateNOC methods.
 * It also uses the SourceFileReader interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.1
 * @since 14-6-2023
 */
public abstract class SourceCodeAnalyzer {

    protected SourceFileReader fileReaderType;

    public SourceCodeAnalyzer(SourceFileReader fileReaderType) {
        this.fileReaderType = fileReaderType;
    }

    public abstract int calculateLOC(String filepath) throws IOException;

    public abstract int calculateNOM(String filepath) throws IOException;

    public abstract int calculateNOC(String filepath) throws IOException;

}
