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

public class WebFileReaderTest {

    private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
    private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
    private static List<String> expectedList;
    private static String expectedString;
    SourceFileReader sfr = null;

    @BeforeClass
    public static void setUp() throws IOException {
        expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
        expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter)
    }

    @Test
    public void testReadFileIntoListWeb() throws IOException {
        //read a file stored in the web into a List
        sfr = new WebFileReader();
        List<String> actualList = sfr.readFileIntoList(TEST_CLASS_WEB);

        String[] expecteds = expectedList.stream().toArray(String[]::new);
        String[] actuals = actualList.stream().toArray(String[]::new);

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void testReadFileIntoStringWeb() throws IOException {
        //read a file stored in the web into a String
        sfr = new WebFileReader();
        String actuals = sfr.readFileIntoString(TEST_CLASS_WEB);

        assertEquals(expectedString, actuals);
    }

}
