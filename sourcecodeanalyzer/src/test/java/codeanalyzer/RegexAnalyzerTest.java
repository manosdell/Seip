package codeanalyzer;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegexAnalyzerTest {

    private final static String TEST_CLASS = "src/test/resources/TestClass.java";
    private static List<String> expectedList;
    private static String expectedString;
    SourceFileReader mockedReader = Mockito.mock(LocalFileReader.class);
    private final SourceCodeAnalyzer sca = new RegexAnalyzer(mockedReader);


    @BeforeClass
    public static void setUp() throws IOException {
        expectedList = Files.readAllLines(new File(TEST_CLASS).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    @Test
    public void testCalculateRegexLOC() throws IOException {
        Mockito.when(mockedReader.readFileIntoString(TEST_CLASS)).thenReturn(expectedString);
        assertEquals(21, sca.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOM() throws IOException {
        Mockito.when(mockedReader.readFileIntoString(TEST_CLASS)).thenReturn(expectedString);
        assertEquals(3, sca.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateRegexNOC() throws IOException {
        Mockito.when(mockedReader.readFileIntoString(TEST_CLASS)).thenReturn(expectedString);
        assertEquals(3, sca.calculateNOC(TEST_CLASS));
    }
}
