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

public class StringAnalyzerTest {

    private final static String TEST_CLASS = "src/test/resources/TestClass.java";
    private static List<String> expectedList;
    SourceFileReader mockedReader = Mockito.mock(LocalFileReader.class);
    private final SourceCodeAnalyzer sca = new StringAnalyzer(mockedReader);

    @BeforeClass
    public static void setup() throws IOException {
        File file = new File(TEST_CLASS);
        expectedList = Files.readAllLines(file.toPath(), Charset.defaultCharset());
    }

    @Test
    public void testCalculateStrCompLOC() throws IOException {
        Mockito.doCallRealMethod().when(mockedReader).readFileIntoList(TEST_CLASS);
        assertEquals(7, sca.calculateLOC(TEST_CLASS));
    }

    @Test
    public void testCalculateStrCompNOM() throws IOException {
        Mockito.doCallRealMethod().when(mockedReader).readFileIntoList(TEST_CLASS);
        assertEquals(3, sca.calculateNOM(TEST_CLASS));
    }

    @Test
    public void testCalculateStrCompNOC() throws IOException {
        Mockito.doCallRealMethod().when(mockedReader).readFileIntoList(TEST_CLASS);
        assertEquals(3, sca.calculateNOC(TEST_CLASS));
    }
}
