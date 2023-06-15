package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

public class NullMetricsExporterTest {

    @Test
    public void testPrint() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setErr(new PrintStream(outContent));

        MetricsExporter mockedExporter = mock(NullMetricsExporter.class);
        // create an empty metrics content
        Map<String, Integer> metrics = new HashMap<>();
        String outputFilepath = "whatever-path";

        //this is a demo of how a mocked object can call a real method (partial mocking)
        doCallRealMethod().when(mockedExporter).writeFile(metrics, outputFilepath);
        mockedExporter.writeFile(metrics, outputFilepath);
        //check if your error message is in the output variable
        System.out.println(outContent.toString());
        File file = new File(outputFilepath.concat(".csv"));
        file.delete();
        Assert.assertEquals("Unsupported export type\n", outContent.toString());
    }
}
