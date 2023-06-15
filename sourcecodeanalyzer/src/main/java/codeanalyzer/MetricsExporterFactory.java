package codeanalyzer;

/**
 * This class is responsible for creating the appropriate MetricsExporter
 * object. It uses the Factory Method design pattern.
 */
public class MetricsExporterFactory {

    /**
     * This method creates the appropriate MetricsExporter object.
     *
     * @param outputFileType The type of the output file.
     * @return The appropriate MetricsExporter object.
     */
    public static MetricsExporter createMetricsExporter(String outputFileType) {

        MetricsExporter exporter = null;
        if (outputFileType.equals("csv")) {
            exporter = new CsvMetricsExporter();
        } else if (outputFileType.equals("json")) {
            exporter = new JsonMetricsExporter();
        } else {
            exporter = new NullMetricsExporter();
        }
        return exporter;
    }
}
