package codeanalyzer;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNull;

public class NullFileReaderTest {

    private static List<String> expectedList;
    private static String expectedString;
    SourceFileReader sfr = null;

    @Test
    public void testReadFileIntoListNull() throws IOException {
        //give a none existing type to cause a null List return
        sfr = new NullFileReader();
        List<String> actualList = sfr.readFileIntoList("any-filepath");

        assertNull(actualList);
    }

    @Test
    public void testReadFileIntoStringNull() throws IOException {
        //give a none existing type to cause a null String return
        sfr = new NullFileReader();
        String actualString = sfr.readFileIntoString("any-filepath");

        assertNull(actualString);
    }
}
