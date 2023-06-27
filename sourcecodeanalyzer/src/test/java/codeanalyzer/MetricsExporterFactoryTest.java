package codeanalyzer;


import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterFactoryTest {

    MetricsExporterFactory factory = new MetricsExporterFactory();

    @Test
    public void testCreateCsvExporter() {
        MetricsExporter exporter = factory.createMetricsExporter("csv");
        Assert.assertTrue(exporter instanceof CsvMetricsExporter);
    }

    @Test
    public void testCreateJsonExporter() {
        MetricsExporter exporter = factory.createMetricsExporter("json");
        Assert.assertTrue(exporter instanceof JsonMetricsExporter);
    }

    @Test
    public void testCreateNullExporter() {
        MetricsExporter exporter = factory.createMetricsExporter("whatever");
        Assert.assertTrue(exporter instanceof NullMetricsExporter);
    }
}
