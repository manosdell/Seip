package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class NullAnalyzerTest {

    private final static String TEST_CLASS = "a random path";
    SourceFileReader mockedReader = Mockito.mock(LocalFileReader.class);
    private final SourceCodeAnalyzer sca = new NullAnalyzer(mockedReader);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testCalculateLOCNull() throws IOException {
        System.setErr(new PrintStream(outContent));
        sca.calculateLOC(TEST_CLASS);
        Assert.assertEquals("Unknown analyzer type\n", outContent.toString());
    }

    @Test
    public void testCalculateNOMNull() throws IOException {
        System.setErr(new PrintStream(outContent));
        sca.calculateNOM(TEST_CLASS);
        Assert.assertEquals("Unknown analyzer type\n", outContent.toString());
    }

    @Test
    public void testCalculateNOCNull() throws IOException {
        System.setErr(new PrintStream(outContent));
        sca.calculateNOC(TEST_CLASS);
        Assert.assertEquals("Unknown analyzer type\n", outContent.toString());
    }
}
