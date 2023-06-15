package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SourceCodeAnalyzerFactoryTest {

    SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();
    SourceFileReader mockLocalReader = mock(LocalFileReader.class);
    SourceFileReader mockWebReader = mock(LocalFileReader.class);

    @Test
    public void TestCreateSourceCodeAnalyzerRegexLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("regex", mockLocalReader);
        Assert.assertTrue(codeAnalyzer instanceof RegexAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerStringLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("strcomp", mockLocalReader);
        Assert.assertTrue(codeAnalyzer instanceof StringAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerNullLocal() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("unknown", mockLocalReader);
        Assert.assertTrue(codeAnalyzer instanceof NullAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerRegexWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("regex", mockWebReader);
        Assert.assertTrue(codeAnalyzer instanceof RegexAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerStringWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("strcomp", mockWebReader);
        Assert.assertTrue(codeAnalyzer instanceof StringAnalyzer);
    }

    @Test
    public void TestCreateSourceCodeAnalyzerNullWeb() {
        SourceFileReader mockedFileReader = mock(LocalFileReader.class);
        SourceCodeAnalyzer codeAnalyzer = factory.createSourceCodeAnalyzer("unknown", mockWebReader);
        Assert.assertTrue(codeAnalyzer instanceof NullAnalyzer);
    }


}
