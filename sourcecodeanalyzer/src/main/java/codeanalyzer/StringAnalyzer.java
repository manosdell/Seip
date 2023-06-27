package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This class is responsible for calculating the metrics of a given source code
 * file using string manipulation. It extends the SourceCodeAnalyzer abstract
 * class and implements the calculateLOC, calculateNOM and calculateNOC methods.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class StringAnalyzer extends SourceCodeAnalyzer {

    /**
     * This constructor calls the constructor of the parent class.
     *
     * @param fileReaderType The type of the file reader.
     */
    public StringAnalyzer(SourceFileReader fileReaderType) {
        super(fileReaderType);
    }

    /**
     * This method calculates the LOC of a given source code file using string
     * manipulation. It uses the readFileIntoList method of the SourceFileReader
     * interface.
     *
     * @param filepath The path of the file to be read.
     * @return The LOC of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    public int calculateLOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReaderType.readFileIntoList(filepath);
        int nonCodeLinesCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (line.startsWith("//") || line.startsWith("/*") ||
                    line.startsWith("*") || line.equals("{") ||
                    line.equals("}") || line.equals("")) {
                nonCodeLinesCounter++;
            }
        }
        int loc = sourceCodeList.size() - nonCodeLinesCounter;
        return loc;
    }

    /**
     * This method calculates the NOM of a given source code file using string
     * manipulation. It uses the readFileIntoList method of the SourceFileReader
     * interface.
     *
     * @param filepath The path of the file to be read.
     * @return The NOM of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    public int calculateNOM(String filepath) throws IOException {
        List<String> sourceCodeList = fileReaderType.readFileIntoList(filepath);
        int methodCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if (((line.contains("public") || line.contains("private")
                    || line.contains("protected")) || line.contains("void") ||
                    line.contains("int") || line.contains("String"))
                    && line.contains("(") && line.contains(")")
                    && line.contains("{")) {

                methodCounter++;
            }
        }
        return methodCounter;
    }

    /**
     * This method calculates the NOC of a given source code file using string
     * manipulation. It uses the readFileIntoList method of the SourceFileReader
     * interface.
     *
     * @param filepath The path of the file to be read.
     * @return The NOC of the given source code file.
     * @throws IOException If the file cannot be read.
     */
    public int calculateNOC(String filepath) throws IOException {
        List<String> sourceCodeList = fileReaderType.readFileIntoList(filepath);
        int classCounter = 0;
        for (String line : sourceCodeList) {
            line = line.trim(); //clear all leading and trailing white spaces
            if ((line.startsWith("class ") || line.contains(" class "))
                    && line.contains("{")) {
                classCounter++;
            }
        }
        return classCounter;
    }
}
