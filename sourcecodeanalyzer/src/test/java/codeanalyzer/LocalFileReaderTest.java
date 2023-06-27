package codeanalyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LocalFileReaderTest {

    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private static List<String> expectedList;
    private static String expectedString;
    LocalFileReader sfr = null;

    @BeforeClass
    public static void setUp() throws IOException {
        expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    @Test
    public void testReadFileIntoListLocal() throws IOException {
        //read a locally stored file into a List
        sfr = new LocalFileReader();
        List<String> actualList = sfr.readFileIntoList(TEST_CLASS_LOCAL);

        String[] expecteds = expectedList.stream().toArray(String[]::new);
        String[] actuals = actualList.stream().toArray(String[]::new);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testReadFileIntoStringLocal() throws IOException {
        //read a locally stored file into a String
        sfr = new LocalFileReader();
        String actuals = sfr.readFileIntoString(TEST_CLASS_LOCAL);

        assertEquals(expectedString, actuals);
    }
}
