package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for calculating the metrics of a given source code
 * file using regex. It extends the SourceCodeAnalyzer abstract class and
 * implements the calculateLOC, calculateNOM and calculateNOC methods.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class RegexAnalyzer extends SourceCodeAnalyzer{

    public RegexAnalyzer(SourceFileReader fileReaderType) {
        super(fileReaderType);
    }

    /**
     * This method calculates the LOC of a given source code file using regex.
     * It uses the readFileIntoString method of the SourceFileReader interface.
     *
     * @param filepath The path of the file to be read.
     * @return The LOC of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    @Override
    public int calculateLOC(String filepath) throws IOException {

        String sourceCode = fileReaderType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
            nonCodeLinesCounter++;
        }

        int sourceFileLength = sourceCode.split("\n").length;
        int loc = sourceFileLength - nonCodeLinesCounter;

        return loc;
    }

    /**
     * This method calculates the NOM of a given source code file using regex.
     * It uses the readFileIntoString method of the SourceFileReader interface.
     *
     * @param filepath The path of the file to be read.
     * @return The NOM of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    @Override
    public int calculateNOM(String filepath) throws IOException {

        String sourceCode = fileReaderType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*(public |protected |private" +
                "|static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\)" +
                "*(\\{?|[^;]).*");
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
            methodCounter++;
        }
        return methodCounter;

    }

    /**
     * This method calculates the NOC of a given source code file using regex.
     * It uses the readFileIntoString method of the SourceFileReader interface.
     *
     * @param filepath The path of the file to be read.
     * @return The NOC of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    @Override
    public int calculateNOC(String filepath) throws IOException {

        String sourceCode = fileReaderType.readFileIntoString(filepath);
        Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
            classCounter++;
        }
        return classCounter;

    }
}
