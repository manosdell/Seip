package codeanalyzer;


import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderFactoryTest {

    SourceFileReaderFactory factory = new SourceFileReaderFactory();

    @Test
    public void testCreateSourceFileReaderWeb() {
        SourceFileReader reader = factory.createSourceFileReader("web");
        Assert.assertTrue(reader instanceof WebFileReader);
    }

    @Test
    public void testCreateSourceFileReaderLocal() {
        SourceFileReader reader = factory.createSourceFileReader("local");
        Assert.assertTrue(reader instanceof LocalFileReader);
    }

    @Test
    public void testCreateSourceFileReaderNull() {
        SourceFileReader reader = factory.createSourceFileReader("invalid location");
        Assert.assertTrue(reader instanceof NullFileReader);
    }
}
