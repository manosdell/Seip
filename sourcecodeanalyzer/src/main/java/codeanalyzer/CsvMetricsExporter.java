package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class is responsible for exporting the metrics to a CSV file.
 *
 * @version 1.1
 * @since 14-6-2023
 * @author Emmanouil Dellatolas
 */
public class CsvMetricsExporter implements MetricsExporter {

    /**
     * This method writes the metrics to a CSV file.
     * @param metrics The metrics to be written to the CSV file.
     * @param filepath The path of the CSV file.
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
        StringBuilder metricsNames = new StringBuilder();
        StringBuilder metricsValues = new StringBuilder();

        for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
            metricsNames.append(entry.getKey()).append(",");
            metricsValues.append(entry.getValue()).append(",");
        }

        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.append(String.valueOf(metricsNames)).append("\n");
            writer.append(String.valueOf(metricsValues)).append("\n");
            writer.close();
            System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
