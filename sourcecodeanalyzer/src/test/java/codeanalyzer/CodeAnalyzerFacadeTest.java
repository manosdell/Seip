package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
public class CodeAnalyzerFacadeTest {

    @Test
    public void testAnalyze() {
        String filepath = "src/main/resources/TestClass.java";
        String analyzerType = "regex";
        String sourceFileLocation = "local";
        String outputFilePath = "output_metrics";
        String outputType = "csv";

        CodeAnalyzerFacade facade = new CodeAnalyzerFacade();

        try {
            facade.analyze(filepath, sourceFileLocation, analyzerType, outputFilePath, outputType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(outputFilePath + "." + outputType);
        Assert.assertTrue(file.exists());
        file.delete();


    }



}
