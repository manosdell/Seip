package codeanalyzer;

import java.util.Map;

/**
 * This class is responsible for handling the case where the
 * metrics exporter type is unknown. It implements the Null Object
 * design pattern. It also implements the MetricsExporter interface.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 14-6-2023
 */
public class NullMetricsExporter implements MetricsExporter{

    /**
     * This method prints an error message.
     *
     * @param metrics The metrics to be exported.
     * @param filepath The path of the file to be written.
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        System.err.print("Unsupported export type\n");
    }
}
